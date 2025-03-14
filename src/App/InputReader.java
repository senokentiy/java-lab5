package App;

import java.util.Scanner;


public class InputReader
{
    public String readInput()
    {
        Scanner scanner = App.getInstance().getScanner();

        System.out.print(">  ");
        return scanner.nextLine().trim();
    }
}



