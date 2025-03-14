package model;


public class Coordinates
{
    private long x; //Значение поля должно быть больше -205, Поле не может быть null
    private int y; //Максимальное значение поля: 143

    public Coordinates(long x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public Coordinates() {}

    public long getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public void setX(long x)
    {
        if (x <= -205) { throw new IllegalArgumentException(); }
        this.x = x;
    }

    public void setY(int y)
    {
        if (y > 143) { throw new IllegalArgumentException(); }
        this.y = y;
    }

    @Override
    public String toString()
    {
        return "{x=" + x +
                ", y=" + y +
                '}';
    }
}
