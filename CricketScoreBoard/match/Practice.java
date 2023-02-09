package match;

import team.Team;
import team.player.Player;
import team.player.Member;
import print.PrintScoreBoard;
import print.PrintToConsole;

public class Practice implements Match
{
	private int NO_OF_OVERS;
	private Team team1, team2;
	private Team currentInnings;
	private Player player1, player2;
	private Player turn;
	private int currentPlayerIndex;
	private PrintScoreBoard scoreBoard;
	private String[] battingOrder;
	public Practice(int overs)
	{
		this.NO_OF_OVERS = overs;
		this.scoreBoard = new PrintToConsole();
	}
	public void firstInnings(String[] playerDetails, String order)
	{
		this.currentPlayerIndex = 0;
		this.team1 = new Team(playerDetails);
		this.currentInnings = team1;
		String[] tokens = order.split(",");
		this.battingOrder = tokens;
		this.player1 = currentInnings.getPlayerByJerseyNumber(Integer.parseInt(battingOrder[currentPlayerIndex++]));
		this.player2 = currentInnings.getPlayerByJerseyNumber(Integer.parseInt(battingOrder[currentPlayerIndex++]));
		this.turn = player1;
	}
	public void secondInnings(String[] playerDetails, String order)
	{
		this.currentPlayerIndex = 0;
		this.team2 = new Team(playerDetails);
		this.currentInnings = team2;
		String[] tokens = order.split(",");
		this.battingOrder = tokens;
		this.player1 = currentInnings.getPlayerByJerseyNumber(Integer.parseInt(battingOrder[currentPlayerIndex++]));
		this.player2 = currentInnings.getPlayerByJerseyNumber(Integer.parseInt(battingOrder[currentPlayerIndex++]));
		this.turn = player1;
	}
	public void addOver(int overNo, String[] status)
	{
		if (overNo > 1)
		{
			if (turn == player1)
				turn = player2;
			else turn = player1;
		}
		for (String bowl : status)
		{
			switch(bowl)
			{
				case "1":
				case "3":
				case "5":
					turn.updateScore(Integer.parseInt(bowl));
					if (turn == player1)
						turn = player2;
					else turn = player1;
					break;

				case "2":
					turn.updateScore(Integer.parseInt(bowl));
					break;

				case "4":
					turn.updateScore(Integer.parseInt(bowl));
					turn.updateFours();
					break;

				case "6":
					turn.updateScore(Integer.parseInt(bowl));
					turn.updateSixes();
					break;

				case "W":
					if (currentPlayerIndex == 11)
						return;
					turn.updateBalls();
					if (turn == player1)
					{
						player1 = currentInnings.getPlayerByJerseyNumber(Integer.parseInt(battingOrder[currentPlayerIndex++]));
						turn = player1;
					}
					else
					{
						player2 = currentInnings.getPlayerByJerseyNumber(Integer.parseInt(battingOrder[currentPlayerIndex++]));
						turn = player2;
					}
					currentInnings.updateWickets();
					break;

				case "Wd":
				case "N":
					currentInnings.updateTeamScore();
					break;

				default:
					System.out.println("New Status: "+bowl);
			}
		}
		scoreBoard.print(overNo,this);
	}
	public String[] getBattingOrder()
	{
		return this.battingOrder;
	}
	public Team getTeam()
	{
		return this.currentInnings;
	}
	public Team getTeam1()
	{
		return this.team1;
	}
	public Team getTeam2()
	{
		return this.team2;
	}
	public Player getPlayer1()
	{
		return this.player1;
	}
	public Player getPlayer2()
	{
		return this.player2;
	}
	public void printResult()
	{
		scoreBoard.printResult(this);
	}
}