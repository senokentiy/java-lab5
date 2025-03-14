package Commands;


public class Exit implements Command
{
    @Override
    public void execute(String arg)
    {
        System.exit(0);
    }

    @Override
    public String getDescription()
    {
        return "quits program without saving.";
    }
}
