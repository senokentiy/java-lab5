import java.util.Scanner;
import Commands.*;
import App.*;


public class Main
{
    public static void main(String[] args)
    {
        App app = App.getInstance();

        app.setScanner(new Scanner(System.in));
        app.setCommandManager(new CommandManager());
        app.setStorageManager(new StorageManager());
        app.setInputReader(new InputReader());
        app.setAppRunner(new AppRunner());

        app.getCommandManager().add("add", new Add());
        app.getCommandManager().add("help", new Help());

        app.getAppRunner().run();
    }
}



