import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.io.File;

public class Driver
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		String fileName = console.readLine();

		BufferedReader file = new BufferedReader(new FileReader(new File(fileName)));
		while (true)
		{
			String command = file.readLine();
			String[] tokens = command.trim().split(" +");
			switch (tokens[0])
			{
				
			}
		}
	}
}