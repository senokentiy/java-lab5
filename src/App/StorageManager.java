package App;

import model.Ticket;
import java.util.LinkedList;


public class StorageManager
{
    private final LinkedList<Ticket> tickets = new LinkedList<>();
    private long maxID;

    public void addTicket(Ticket ticket)
    {
        ticket.setID(++maxID);
        ticket.getVenue().setID(maxID);
        maxID = ticket.getID();
        tickets.add(ticket);
    }

    public LinkedList<Ticket> getTickets()
    {
        return tickets;
    }
}

