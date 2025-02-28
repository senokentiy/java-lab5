package Commands;


public interface Command
{
    void execute(String arg);

    String getDescription();
}
