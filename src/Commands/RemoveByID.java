package Commands;

import App.*;
import model.Ticket;


public class RemoveByID implements Command, Argumentable
{
    StorageManager storageManager = App.getInstance().getStorageManager();

    @Override
    public void execute(String arg)
    {
        long id = 0L;

        try {
            id = Integer.parseInt(arg);
        } catch (NumberFormatException e) {
            System.out.println("illegal argument! try again...");
        }

        try {
            storageManager.removeByID(id);
            System.out.println("ticket was removed.");
        } catch (NullPointerException e) {
            System.out.println("no ticket with id=" + id + ".");
        }
    }

    @Override
    public String getDescription()
    {
        return "removes ticket by id.";
    }
}
