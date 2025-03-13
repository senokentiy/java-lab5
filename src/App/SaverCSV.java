package App;

import model.Ticket;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.LinkedList;


public class SaverCSV
{
    private static final String path = "tickets.csv";
    HashSet<Ticket> saved = new HashSet<>();

    public void save() throws IOException
    {
        StorageManager storageManager = App.getInstance().getStorageManager();

        if (!Files.exists(Paths.get(path))) { createCsvFileWithHeaders(); }

        LinkedList<Ticket> tickets = storageManager.getTickets();

        if (!tickets.isEmpty())
        {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true)))
            {
                boolean is_changes = false;
                for (Ticket ticket : tickets)
                {
                    if (saved.contains(ticket)) { continue; }

                    writer.write(ticket.getId() + ",");
                    writer.write(ticket.getName() + ",");
                    writer.write(ticket.getCoordinates().getX() + ",");
                    writer.write(ticket.getCoordinates().getY() + ",");
                    writer.write(ticket.getCreationDate() + ",");
                    writer.write(ticket.getPrice() + ",");
                    writer.write(ticket.getTicketType() + ",");
                    writer.write(ticket.getVenue().getId() + ",");
                    writer.write(ticket.getVenue().getName() + ",");
                    writer.write(ticket.getVenue().getCapacity() + ",");
                    writer.write(ticket.getVenue().getVenueType() + "");
                    writer.newLine();

                    is_changes = true;
                    saved.add(ticket);
                }
                if (!is_changes) {
                    System.out.println("there is nothing to save.");
                } else {
                    System.out.println("data was saved successfully!");
                }
            }
        } else {
            System.out.println("there is nothing to save.");
        }
    }

    private static void createCsvFileWithHeaders() throws IOException
    {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path)))
        {
            writer.write("ticket_id,ticket_name,x,y,creation_date,price,ticket_type,venue_id,venue_name,capacity,venue_type");
            writer.newLine();
            System.out.println("csv file was added.");
        }
    }
}
