package Commands;

import App.*;
import model.Ticket;
import java.util.LinkedList;


public class Show implements Command
{
    @Override
    public void execute(String arg)
    {
        StorageManager storageManager = App.getInstance().getStorageManager();
        LinkedList<Ticket> tickets = storageManager.getTickets();

        for (Ticket ticket : tickets) { System.out.println(ticket); }
    }

    @Override
    public String getDescription()
    {
        return "prints tickets info.";
    }
}
