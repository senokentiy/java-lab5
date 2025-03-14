package App;

import Commands.*;
import exceptions.*;
import java.util.HashMap;


public class CommandManager
{
    private final HashMap<String, Command> commands = new HashMap<>();

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
            if (!commandName.isEmpty())
            {
                Command command = commands.get(commandName);

                if (!(command instanceof Argumentable) && !commandArg.isEmpty()) {
                    throw new NotArgumentableCommandException();
                } else if (command instanceof Argumentable && commandArg.isEmpty()) {
                    throw new IllegalArgumentException();
                }
                command.execute(commandArg);
            }
        } catch (NotArgumentableCommandException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("command must have argument!");
        } catch (NullPointerException e) {
            System.out.println("no such command!");
        }
    }

    public HashMap<String, Command> getCommands()
    {
        return commands;
    }
}
