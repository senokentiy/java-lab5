package App;

import java.util.Scanner;


public class App
{
    private static App app;

    Scanner scanner;
    CommandManager commandManager;
    StorageManager storageManager;
    SaverCSV saver;
    InputReader inputReader;
    AppRunner appRunner;

    private App() {}

    public static App getInstance()
    {
        if (app == null)
            app = new App();
        return app;
    }

    public void setSaver(SaverCSV saver)
    {
        this.saver = saver;
    }

    public void setScanner(Scanner scanner)
    {
        this.scanner = scanner;
    }

    public void setCommandManager(CommandManager commandManager)
    {
        this.commandManager = commandManager;
    }

    public void setStorageManager(StorageManager storageManager)
    {
        this.storageManager = storageManager;
    }

    public void setAppRunner(AppRunner appRunner)
    {
        this.appRunner = appRunner;
    }

    public void setInputReader(InputReader inputReader)
    {
        this.inputReader = inputReader;
    }

    public Scanner getScanner()
    {
        return scanner;
    }

    public SaverCSV getSaver()
    {
        return saver;
    }

    public CommandManager getCommandManager()
    {
        return commandManager;
    }

    public StorageManager getStorageManager()
    {
        return storageManager;
    }

    public AppRunner getAppRunner()
    {
        return appRunner;
    }

    public InputReader getInputReader()
    {
        return inputReader;
    }
}
