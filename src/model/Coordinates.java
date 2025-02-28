package model;


public class Coordinates
{
    private Long x; //Значение поля должно быть больше -205, Поле не может быть null
    private int y; //Максимальное значение поля: 143

    public Coordinates(Long x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public Coordinates() {}

    public Long getX()
    {
        return x;
    }

    public void setX(Long x)
    {
        this.x = x;
    }

    public int getY()
    {
        return y;
    }

    public void setY(int y)
    {
        this.y = y;
    }
}
