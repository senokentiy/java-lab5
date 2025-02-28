package model;


public class Ticket
{
    private Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.util.Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Long price; //Поле может быть null, Значение поля должно быть больше 0
    private TicketType ticketType; //Поле может быть null
    private Venue venue; //Поле не может быть null

    public Ticket(String name, Coordinates coordinates, Long price, TicketType ticketType, Venue venue)
    {
        this.id = 1L;                // generate
        this.coordinates = coordinates;
        this.price = price;
        this.ticketType = ticketType;
        this.venue = venue;
    }

    public Ticket() {}

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Long getPrice()
    {
        return price;
    }

    public void setPrice(Long price)
    {
        this.price = price;
    }

    public void setTicketTypeByNum(int num)
    {
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

