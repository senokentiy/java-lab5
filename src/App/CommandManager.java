package App;

import Commands.*;
import exceptions.*;
import java.io.IOException;
import java.util.HashMap;


public class CommandManager
{
    HashMap<String, Command> commands = new HashMap<>();

    public void add(String name, Command command)
    {
        this.commands.put(name, command);
    }

    public void call(String input)
    {
        String[] data = input.split(" ", 2);
        String commandName = data[0];
        String commandArg = "";

        if (data.length > 1) commandArg = data[1];

        try {
            Command command = commands.get(commandName);
            if (!(command instanceof Argumentable) && !commandArg.isEmpty())
            {
                throw new NotArgumentableCommandException();
            }
            command.execute(commandArg);
        } catch (NotArgumentableCommandException e) {
            System.out.println(e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("no such command!");
        } catch (IOException e) {
            System.out.println("an io error was occurred!");
        }
    }

    public HashMap<String, Command> getCommands()
    {
        return commands;
    }
}
