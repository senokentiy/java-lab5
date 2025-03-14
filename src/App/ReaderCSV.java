package App;

import model.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashSet;


public class ReaderCSV
{
    private static final String path = "tickets.csv";

    public void readCSV()
    {
        StorageManager storageManager = App.getInstance().getStorageManager();

        try (BufferedReader reader = new BufferedReader(new FileReader(path)))
        {
            reader.readLine();      // skip header
            String line;
            long lineNum = 1;
            long id;

            while ((line = reader.readLine()) != null)
            {
                lineNum++;
                String[] fields = line.split(",");

                try {
                    storageManager.addTicket(new Ticket(fields[1],
                            new Coordinates(Integer.parseInt(fields[2]),
                                    Integer.parseInt(fields[3])), LocalDate.parse(fields[4]),
                            Integer.parseInt(fields[5]), TicketType.valueOf(fields[6]),
                            new Venue(fields[8],
                                    Integer.parseInt(fields[9]), VenueType.valueOf(fields[10]))));
                } catch (NumberFormatException | NullPointerException e) {
                    System.out.println("file data corrupted! check line " + lineNum + ".");
                    System.exit(1);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("file '" + path + "' not found!");
            SaverCSV.createFileWithHeaders();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
