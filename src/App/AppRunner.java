package App;


public class AppRunner
{
    public void run()
    {
        CommandManager commandManager = App.getInstance().getCommandManager();
        InputReader inputReader = App.getInstance().getInputReader();

        String input;

        while (true)
        {
            try
            {
                input = inputReader.readInput();
                commandManager.call(input);
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
                break;
            }
        }
    }
}
