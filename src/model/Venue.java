package model;


public class Venue
{
    private static Long id = 0L; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Integer capacity; //Поле не может быть null, Значение поля должно быть больше 0
    private VenueType venueType; //Поле не может быть null

    public Venue()
    {
        id = newID();
    }

    private static long newID()
    {
        return ++id;
    }

    public long getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public Integer getCapacity()
    {
        return capacity;
    }

    public VenueType getVenueType()
    {
        return venueType;
    }

    public void setName(String name)
    {
        if (name.isEmpty()) { throw new IllegalArgumentException(); }
        this.name = name;
    }

    public void setCapacity(int capacity)
    {
        if (capacity < 0) { throw new IllegalArgumentException(); }
        this.capacity = capacity;
    }

    public void setVenueTypeByNum(int num)
    {
        if (num > 2 || num < 0) { throw new IllegalArgumentException(); }

        switch (num)
        {
            case 0 -> this.venueType = VenueType.BAR;
            case 1 -> this.venueType = VenueType.LOFT;
            case 2 -> this.venueType = VenueType.MALL;
        }
    }
}
