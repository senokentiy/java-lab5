package Commands;


import misc.ConsoleCleaner;

public class Clear implements Command
{
    @Override
    public void execute(String arg)
    {
        ConsoleCleaner.clean();
    }

    @Override
    public String getDescription()
    {
        return "clears console.";
    }
}
