package App;

import model.Ticket;
import java.util.LinkedList;


public class StorageManager {
    private final LinkedList<Ticket> tickets = new LinkedList<>();
    private long maxID;

    public void addTicket(Ticket ticket) {
        ticket.setID(++maxID);
        ticket.getVenue().setID(maxID);
        maxID = ticket.getID();
        tickets.add(ticket);
    }

    public Ticket getTicketByID(long id)
    {
        for (Ticket ticket : tickets)
        {
            if (ticket.getID() == id) { return ticket; }
        }
        throw new NullPointerException();
    }

    public void removeByID(long id)
    {
        for (Ticket ticket : tickets)
        {
            if (ticket.getID() == id)
            {
                tickets.remove(ticket);
                return;
            }
        }
        throw new NullPointerException();
    }

    public LinkedList<Ticket> getTickets()
    {
        return tickets;
    }
}

