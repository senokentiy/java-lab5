package exceptions;


public class NoSuchCommandException extends RuntimeException
{
    public NoSuchCommandException(String message)
    {
        super(message);
    }

    @Override
    public String getMessage()
    {
        return "no such command!";
    }
}
