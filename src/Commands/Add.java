package Commands;

import App.*;
import model.*;


public class Add implements Command
{
    @Override
    public void execute(String arg)
    {
        StorageManager storageManager = App.getInstance().getStorageManager();
        InputReader inputReader = App.getInstance().getInputReader();
        Ticket ticket = new Ticket();
        Coordinates coordinates = new Coordinates();
        Venue venue = new Venue();

        System.out.println("enter ticket name:");
        String ticketName = inputReader.readInput();
        ticket.setName(ticketName);

        while (true)
        {
            try {
                System.out.println("enter x coordinate:");
                Long x = (long) Integer.parseInt(inputReader.readInput());
                coordinates.setX(x);
                break;
            } catch (NumberFormatException e) {
                System.out.println("illegal argument! try again...");
            }
        }

        while (true)
        {
            try {
                System.out.println("enter y coordinate:");
                int y = Integer.parseInt(inputReader.readInput());
                coordinates.setY(y);
                break;
            } catch (NumberFormatException e) {
                System.out.println("illegal argument! try again...");
            }
        }

        ticket.setCoordinates(coordinates);

        while (true)
        {
            try {
                System.out.println("enter price:");
                Long price = (long) Integer.parseInt(inputReader.readInput());
                ticket.setPrice(price);
                break;
            } catch (NumberFormatException e) {
                System.out.println("illegal argument! try again...");
            }
        }

        while (true)
        {
            try {
                System.out.println("choose ticket type:\n0) usual,\n1) budgetary,\n2) cheap.");
                int ticketTypeNum = Integer.parseInt(inputReader.readInput());
                ticket.setTicketTypeByNum(ticketTypeNum);
                break;
            } catch (NumberFormatException e) {
                System.out.println("illegal argument! try again...");
            }
        }

        System.out.println("enter venue name:");
        String venueName = inputReader.readInput();

        while (true)
        {
            try {
                System.out.println("enter venue capacity:");
                int capacity = Integer.parseInt(inputReader.readInput());
                venue.setCapacity(capacity);
                break;
            } catch (NumberFormatException e) {
                System.out.println("illegal argument! try again...");
            }
        }

        while (true)
        {
            try {
                System.out.println("choose venue type:\n0) bar,\n1) loft,\n2) mall.");
                int venueTypeNum = Integer.parseInt(inputReader.readInput());
                venue.setVenueTypeByNum(venueTypeNum);
                break;
            } catch (NumberFormatException e) {
                System.out.println("illegal argument! try again...");
            }
        }

        ticket.setVenue(venue);

        storageManager.addTicket(ticket);
        System.out.println("ticket was added!");
    }

    @Override
    public String getDescription()
    {
        return "adds new element to collection.";
    }
}
