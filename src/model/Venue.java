package model;


public class Venue
{
    private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Integer capacity; //Поле не может быть null, Значение поля должно быть больше 0
    private VenueType venueType; //Поле не может быть null

    public Venue(String name, Integer capacity, int venueTypeNum)
    {
        this.id = 1L;                // generate
        this.name = name;
        this.capacity = capacity;
        setVenueTypeByNum(venueTypeNum);
    }

    public Venue() {}

    public void setName(String name)
    {
        this.name = name;
    }

    public void setCapacity(int capacity)
    {
        this.capacity = capacity;
    }

    public void setVenueTypeByNum(int num)
    {
        switch (num)
        {
            case 0 -> this.venueType = VenueType.BAR;
            case 1 -> this.venueType = VenueType.LOFT;
            case 2 -> this.venueType = VenueType.MALL;
        }
    }
}
