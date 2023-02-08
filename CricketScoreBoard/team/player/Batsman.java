package team.player;

public class Batsman implements Player
{
	private String playerName;
	private int jerseyNumber;
	private int age;

	public Batsman(String name, int jersey, int age)
	{
		this.playerName = name;
		this.jerseyNumber = jersey;
		this.age = age;
	}

	public String getPlayerName()
	{
		return this.playerName;
	}

	public int getJerseyNumber()
	{
		return this.jerseyNumber;
	}
}