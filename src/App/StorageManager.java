package App;

import model.Ticket;
import java.util.LinkedList;


public class StorageManager
{
    private final LinkedList<Ticket> tickets = new LinkedList<>();

    public void addTicket(Ticket ticket)
    {
        tickets.add(ticket);
    }

    public void removeTicket(Ticket ticket)
    {
        tickets.remove(ticket);
    }

    public LinkedList<Ticket> getTickets()
    {
        return tickets;
    }
}

