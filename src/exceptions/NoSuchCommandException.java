package exceptions;


public class NoSuchCommandException extends NullPointerException
{
    public NoSuchCommandException()
    {
        super();
    }

    @Override
    public String getMessage()
    {
        return "no such command!";
    }
}
