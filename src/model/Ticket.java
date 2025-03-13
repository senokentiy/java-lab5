package model;

import java.time.LocalDate;


public class Ticket
{
    private static Long id = 0L; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private LocalDate creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Long price; //Поле может быть null, Значение поля должно быть больше 0
    private TicketType ticketType; //Поле может быть null
    private Venue venue; //Поле не может быть null

    public Ticket()
    {
        id = newID();
        this.creationDate = LocalDate.now();
    }

    private static Long newID()
    {
        return ++id;
    }

    public Long getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public Coordinates getCoordinates()
    {
        return coordinates;
    }

    public LocalDate getCreationDate()
    {
        return creationDate;
    }

    public Long getPrice()
    {
        return price;
    }

    public TicketType getTicketType()
    {
        return ticketType;
    }

    public Venue getVenue()
    {
        return venue;
    }

    public void setName(String name)
    {
        if (name.isEmpty()) { throw new IllegalArgumentException(); }
        this.name = name;
    }

    public void setPrice(Long price)
    {
        if (price < 0) { throw new IllegalArgumentException(); }
        this.price = price;
    }

    public void setTicketTypeByNum(int num)
    {
        if (num > 2 || num < 0) { throw new IllegalArgumentException(); }

        switch (num)
        {
            case 0 -> this.ticketType = TicketType.USUAL;
            case 1 -> this.ticketType = TicketType.BUDGETARY;
            case 2 -> this.ticketType = TicketType.CHEAP;
        }
    }

    public void setCoordinates(Coordinates coordinates)
    {
        this.coordinates = coordinates;
    }

    public void setVenue(Venue venue)
    {
        this.venue = venue;
    }
}

