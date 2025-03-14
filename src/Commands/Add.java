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

        while (true)
        {
            try {
                System.out.println("enter ticket name:");
                String ticketName = inputReader.readInput();
                ticket.setName(ticketName);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("illegal argument! try again...");
            }
        }

        while (true)
        {
            try {
                System.out.println("enter x coordinate:");
                long x = Integer.parseInt(inputReader.readInput());
                coordinates.setX(x);
                break;
            } catch (NumberFormatException e) {
                System.out.println("x coordinate must be integer! try again...");
            } catch (IllegalArgumentException e) {
                System.out.println("x coordinate must be greater than -205! try again...");
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
                System.out.println("y coordinate must be integer! try again...");
            } catch (IllegalArgumentException e) {
                System.out.println("y coordinate can't be grater than 143! try again...");
            }
        }

        ticket.setCoordinates(coordinates);

        while (true)
        {
            try {
                System.out.println("enter price:");
                long price = Integer.parseInt(inputReader.readInput());
                ticket.setPrice(price);
                break;
            } catch (NumberFormatException e) {
                System.out.println("price must be integer! try again...");
            } catch (IllegalArgumentException e) {
                System.out.println("price can't be negative! try again...");
            }
        }

        while (true)
        {
            try {
                System.out.println("choose ticket type:\n0) usual,\n1) budgetary,\n2) cheap.");
                int ticketTypeNum = Integer.parseInt(inputReader.readInput());
                ticket.setTicketTypeByNum(ticketTypeNum);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("no such option! try again...");
            }
        }

        while (true)
        {
            try {
                System.out.println("enter venue name:");
                String venueName = inputReader.readInput();
                venue.setName(venueName);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("name can't be empty! try again...");
            }
        }

        while (true)
        {
            try {
                System.out.println("enter venue capacity:");
                int capacity = Integer.parseInt(inputReader.readInput());
                venue.setCapacity(capacity);
                break;
            } catch (NumberFormatException e) {
                System.out.println("capacity must be integer! try again...");
            } catch (IllegalArgumentException e) {
                System.out.println("capacity can't be negative! try again...");
            }
        }

        while (true)
        {
            try {
                System.out.println("choose venue type:\n0) bar,\n1) loft,\n2) mall.");
                int venueTypeNum = Integer.parseInt(inputReader.readInput());
                venue.setVenueTypeByNum(venueTypeNum);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("no such option! try again...");
            }
        }

        ticket.setVenue(venue);
        storageManager.addTicket(ticket);
        System.out.println("ticket was added!");
    }

    @Override
    public String getDescription()
    {
        return "adds new ticket to collection.";
    }
}
