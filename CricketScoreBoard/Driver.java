import team.*;
import team.player.*;

public class Driver
{
	public static void main(String[] args) // throws IOException
	{
		Batsman p1 = new Batsman("MS Dhoni",7,40);
		System.out.println(p1.getJerseyNumber());
	}
}