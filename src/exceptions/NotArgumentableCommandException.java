package exceptions;

public class NotArgumentableCommandException extends RuntimeException
{
    public NotArgumentableCommandException()
    {
        super();
    }

    @Override
    public String getMessage()
    {
        return "command has no arguments!";
    }
}
