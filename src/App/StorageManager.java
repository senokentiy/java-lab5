package App;

import model.Ticket;

import java.util.LinkedList;


public class StorageManager
{
    LinkedList<Ticket> storage = new LinkedList<>();

    public void addTicket(Ticket ticket)
    {
        storage.add(ticket);
    }
}

