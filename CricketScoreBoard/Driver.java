import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;

import team.Team;
import team.player.Player;
import team.player.Member;
import match.Match;
import match.Practice;

public class Driver
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		int overs = Integer.parseInt(console.readLine());

		Match match = new Practice(overs);

		String fileName = console.readLine();
		BufferedReader file = new BufferedReader(new FileReader(new File(fileName)));

		String[] playerDetails = new String[11];
		for (int i = 0; i < 11; ++i)
			playerDetails[i] = file.readLine();
		String battingOrder = file.readLine();

		match.firstInnings(playerDetails,battingOrder);
		for (int over = 1; over <= overs; ++over)
		{
			int balls = Integer.parseInt(file.readLine());
			String[] status = new String[balls];
			for (int ball = 1; ball <= balls; ++ball)
				status[ball-1] = file.readLine();
			match.addOver(over,status);
		}
		file.close();
		
		fileName = console.readLine();
		file = new BufferedReader(new FileReader(new File(fileName)));

		playerDetails = new String[11];
		for (int i = 0; i < 11; ++i)
			playerDetails[i] = file.readLine();
		battingOrder = file.readLine();

		match.secondInnings(playerDetails,battingOrder);
		for (int over = 1; over <= overs; ++over)
		{
			int balls = Integer.parseInt(file.readLine());
			String[] status = new String[balls];
			for (int ball = 1; ball <= balls; ++ball)
				status[ball-1] = file.readLine();
			match.addOver(over,status);
		}

		match.printResult();
		file.close();
	}
}