package App;

import model.Ticket;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.LinkedList;


public class SaverCSV
{
    private static final String path = "tickets.csv";
    private final StorageManager storageManager = App.getInstance().getStorageManager();
    private final LinkedList<Ticket> tickets = storageManager.getTickets();
    private final HashSet<Long> saved = new HashSet<>();

    public void save()
    {
        if (!Files.exists(Paths.get(path))) { createCsvFileWithHeaders(); }

        if (!tickets.isEmpty())
        {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true)))
            {
                boolean is_changes = false;
                for (Ticket ticket : tickets)
                {
                    if (saved.contains(ticket.getID())) { continue; }

                    writer.write(ticket.getID() + ",");
                    writer.write(ticket.getName() + ",");
                    writer.write(ticket.getCoordinates().getX() + ",");
                    writer.write(ticket.getCoordinates().getY() + ",");
                    writer.write(ticket.getCreationDate() + ",");
                    writer.write(ticket.getPrice() + ",");
                    writer.write(ticket.getTicketType() + ",");
                    writer.write(ticket.getVenue().getID() + ",");
                    writer.write(ticket.getVenue().getName() + ",");
                    writer.write(ticket.getVenue().getCapacity() + ",");
                    writer.write(ticket.getVenue().getVenueType() + "");
                    writer.newLine();

                    is_changes = true;
                    saved.add(ticket.getID());
                }
                if (!is_changes) {
                    System.out.println("there is nothing to save.");
                } else {
                    System.out.println("data was saved successfully!");
                }
            } catch (FileNotFoundException e) {
                System.out.println("file '" + path + "' not found!");
            }
            catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("there is nothing to save.");
        }
    }

    private static void createCsvFileWithHeaders()
    {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path)))
        {
            writer.write("ticket_id,ticket_name,x,y,creation_date,price,ticket_type,venue_id,venue_name,capacity,venue_type");
            writer.newLine();
            System.out.println("csv file was added.");
        } catch (FileNotFoundException e) {
            System.out.println("file '" + path + "' not found!");
            System.exit(1);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public HashSet<Long> getSavedTickets()
    {
        return saved;
    }
}
