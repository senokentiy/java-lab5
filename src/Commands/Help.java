package Commands;

import java.util.HashMap;
import java.util.Map;
import App.*;


public class Help implements Command
{
    @Override
    public void execute(String arg)
    {
        CommandManager commandManager = App.getInstance().getCommandManager();
        HashMap<String, Command> commands = commandManager.getCommands();

        for(Map.Entry<String, Command> entry : commands.entrySet())
        {
            String name = entry.getKey();
            Command command = entry.getValue();

            System.out.println(name + " -- " + command.getDescription());
        }
    }

    @Override
    public String getDescription()
    {
        return "shows description of all available commands.";
    }
}
