package Commands;

import App.*;
import model.*;


public class Update implements Command, Argumentable
{
    StorageManager storageManager = App.getInstance().getStorageManager();
    InputReader inputReader = App.getInstance().getInputReader();

    @Override
    public void execute(String arg)
    {
        long id = 0L;
        Ticket ticket = null;

        try {
            id = Integer.parseInt(arg);
        } catch (NumberFormatException e) {
            System.out.println("illegal argument! try again...");
        }

        try {
            ticket = storageManager.getTicketByID(id);
        } catch (NullPointerException e) {
            System.out.println("no ticket with id=" + id + ".");
        }

        if (ticket != null)
        {
            while (true)
            {
                System.out.println("""
                        choose option to update or exit [Enter]:
                        0) ticket_name,
                        1) coordinates,
                        2) price,
                        3) ticket_type,
                        4) venue_name,
                        5) venue_capacity,
                        6) venue_type.""");
                try {
                    String input = inputReader.readInput();
                    if (input.isEmpty())
                    {
                        System.out.println("exit...");
                        break;
                    }
                    int option = Integer.parseInt(input);
                    doOption(ticket, option);
                } catch (IllegalArgumentException e) {
                    System.out.println("no such option! try again...");
                }
            }
        }
    }

    private void doOption(Ticket ticket, int option)
    {
        if (option > 6 || option < 0) { throw new IllegalArgumentException(); }

        switch (option)
        {
            case 0 -> changeName(ticket);
            case 1 -> changeCoordinates(ticket);
            case 2 -> changePrice(ticket);
            case 3 -> changeTicketType(ticket);
            case 4 -> changeVenueName(ticket);
            case 5 -> changeVenueCapacity(ticket);
            case 6 -> changeVenueType(ticket);
        }
    }

    private void changeVenueType(Ticket ticket)
    {
        while (true)
        {
            try {
                System.out.println("choose new venue type:\n0) bar,\n1) loft,\n2) mall.");
                int venueTypeNum = Integer.parseInt(inputReader.readInput());
                ticket.getVenue().setVenueTypeByNum(venueTypeNum);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("no such option! try again...");
            }
        }
        System.out.println("venue type was updated.");
    }

    private void changeVenueCapacity(Ticket ticket)
    {
        while (true)
        {
            try {
                System.out.println("enter new venue capacity:");
                int capacity = Integer.parseInt(inputReader.readInput());
                ticket.getVenue().setCapacity(capacity);
                break;
            } catch (NumberFormatException e) {
                System.out.println("capacity must be integer! try again...");
            } catch (IllegalArgumentException e) {
                System.out.println("capacity can't be negative! try again...");
            }
        }
        System.out.println("venue capacity was updated.");
    }

    private void changeVenueName(Ticket ticket)
    {
        while (true)
        {
            try {
                System.out.println("enter new venue name:");
                String venueName = inputReader.readInput();
                ticket.getVenue().setName(venueName);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("name can't be empty! try again...");
            }
        }
        System.out.println("venue name was updated.");
    }

    private void changeTicketType(Ticket ticket)
    {
        while (true)
        {
            try {
                System.out.println("choose new ticket type:\n0) usual,\n1) budgetary,\n2) cheap.");
                int ticketTypeNum = Integer.parseInt(inputReader.readInput());
                ticket.setTicketTypeByNum(ticketTypeNum);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("no such option! try again...");
            }
        }
        System.out.println("ticket type was updated.");
    }

    private void changePrice(Ticket ticket)
    {
        while (true)
        {
            try {
                System.out.println("enter new price:");
                long price = Integer.parseInt(inputReader.readInput());
                ticket.setPrice(price);
                break;
            } catch (NumberFormatException e) {
                System.out.println("price must be integer! try again...");
            } catch (IllegalArgumentException e) {
                System.out.println("price can't be negative! try again...");
            }
        }
        System.out.println("price was updated.");
    }

    private void changeCoordinates(Ticket ticket)
    {
        while (true)
        {
            try {
                System.out.println("enter new x coordinate:");
                long x = Integer.parseInt(inputReader.readInput());
                ticket.getCoordinates().setX(x);
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
                System.out.println("enter new y coordinate:");
                int y = Integer.parseInt(inputReader.readInput());
                ticket.getCoordinates().setY(y);
                break;
            } catch (NumberFormatException e) {
                System.out.println("y coordinate must be integer! try again...");
            } catch (IllegalArgumentException e) {
                System.out.println("y coordinate can't be grater than 143! try again...");
            }
        }
        System.out.println("coordinates was updated.");
    }

    private void changeName(Ticket ticket)
    {
        while (true)
        {
            try {
                System.out.println("enter new ticket name:");
                String ticketName = inputReader.readInput();
                ticket.setName(ticketName);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("illegal argument! try again...");
            }
        }
        System.out.println("ticket name was updated.");
    }

    @Override
    public String getDescription()
    {
        return "updates ticket data by id.";
    }
}
