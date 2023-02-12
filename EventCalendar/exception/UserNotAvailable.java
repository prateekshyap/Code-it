package exception;

public class UserNotAvailable extends Exception
{
	UserNotAvailable(String message)
	{
		super(message);
	}
}