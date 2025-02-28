package App;

import java.util.Scanner;


public class InputReader
{
    public String readInput()
    {
        Scanner scanner = App.getInstance().getScanner();

        return scanner.nextLine().trim();
    }
}



