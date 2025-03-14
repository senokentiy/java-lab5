package misc;


public class ConsoleCleaner
{
    public static void clean()
    {
        System.out.print("\033[H\033[2J\033[3J");
        System.out.flush();
    }

    private ConsoleCleaner() {}
}
