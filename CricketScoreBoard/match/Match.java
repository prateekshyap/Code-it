package match;

import team.Team;
import team.player.Player;

public interface Match
{
	public void firstInnings(String[] playerDetails, String order);
	public void secondInnings(String[] playerDetails, String order);
	public void addOver(int overNo, String[] status);
	public String[] getBattingOrder();
	public Team getTeam();
	public Team getTeam1();
	public Team getTeam2();
	public Player getPlayer1();
	public Player getPlayer2();
	public void printResult();
}