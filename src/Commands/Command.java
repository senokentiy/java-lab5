package Commands;


import java.io.IOException;

public interface Command
{
    void execute(String arg) throws IOException;

    String getDescription();
}
