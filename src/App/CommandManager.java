package App;

import Commands.*;
import exceptions.*;
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

        try
        {
            Command command = commands.get(commandName);
            command.execute(commandArg);
        }
        catch (NoSuchCommandException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public HashMap<String, Command> getCommands()
    {
        return commands;
    }
}
