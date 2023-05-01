package exception;

public class UserNotAvailable extends Exception
{
	public UserNotAvailable(String message)
	{
		super(message);
	}
}