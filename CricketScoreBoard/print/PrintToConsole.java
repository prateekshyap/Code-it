package print;

import java.util.List;

import team.Team;
import team.player.Player;
import match.Match;

public class PrintToConsole implements PrintScoreBoard
{
	public void print(int overNo, Match match)
	{
		System.out.println("==========================================================");
		System.out.println("              Scoreboard after over: "+overNo);
		System.out.println("==========================================================");

		System.out.println();

		System.out.println("Player Name\t\t\tscore\t4s\t6s\tballs");

		String[] battingOrder = match.getBattingOrder();
		Team team = match.getTeam();
		int totalScore = 0;
		for (String p : battingOrder)
		{
			Player player = team.getPlayerByJerseyNumber(Integer.parseInt(p));
			String name = player.getName();
			int score = player.getScore();
			int fours = player.getFours();
			int sixes = player.getSixes();
			int ballsFaced = player.getBallsFaced();
			totalScore += score;
			boolean isOnField = false;
			if (player == match.getPlayer1() || player == match.getPlayer2())
				isOnField = true;
			System.out.println(name+(isOnField ? "*" : "")+"\t\t\t"+score+"\t"+fours+"\t"+sixes+"\t"+ballsFaced);
		}
		totalScore += team.getTeamScore();
		int totalWickets = team.getTeamWickets();
		System.out.println("Total Score: "+totalScore+"/"+totalWickets);
		System.out.println("Overs: "+overNo);
		System.out.println();
		System.out.println();
	}
	public void printResult(Match match)
	{
		int team1Score = 0, team2Score = 0;
		int team1Wickets = 0, team2Wickets = 0;
		Team team1 = match.getTeam1();
		List<Player> players = team1.getPlayers();
		for (Player player : players)
		{
			int score = player.getScore();
			team1Score += score;
		}
		team1Score += team1.getTeamScore();
		team1Wickets += team1.getTeamWickets();
		Team team2 = match.getTeam2();
		players = team2.getPlayers();
		for (Player player : players)
		{
			int score = player.getScore();
			team2Score += score;
		}
		team2Score += team2.getTeamScore();
		team2Wickets += team2.getTeamWickets();
		if (team1Score > team2Score)
			System.out.println("Team 1 won by "+(team1Score-team2Score)+" runs");
		else
			System.out.println("Team 2 won by "+(team1Wickets-team2Wickets)+" wickets");
	}
}