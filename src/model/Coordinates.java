package model;


public class Coordinates
{
    private Long x; //Значение поля должно быть больше -205, Поле не может быть null
    private int y; //Максимальное значение поля: 143

    public Coordinates() {}

    public Long getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public void setX(Long x)
    {
        if (x <= -205) { throw new IllegalArgumentException(); }
        this.x = x;
    }

    public void setY(int y)
    {
        if (y > 143) { throw new IllegalArgumentException(); }
        this.y = y;
    }
}
