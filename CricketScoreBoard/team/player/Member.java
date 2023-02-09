package team.player;

public class Member implements Player
{
	private String playerName;
	private int jerseyNumber;
	private int age;
	private int score;
	private int ballsFaced;
	private int fours;
	private int sixes;

	public Member(String name, int jersey, int age)
	{
		this.playerName = name;
		this.jerseyNumber = jersey;
		this.age = age;
		this.score = this.ballsFaced = this.fours = this.sixes = 0;
	}

	public String getName()
	{
		return this.playerName;
	}

	public int getJerseyNumber()
	{
		return this.jerseyNumber;
	}

	public void updateScore(int run)
	{
		this.score += run;
		updateBalls();
	}

	public void updateBalls()
	{
		++this.ballsFaced;
	}

	public void updateFours()
	{
		++this.fours;
	}

	public void updateSixes()
	{
		++this.sixes;
	}
	public int getScore()
	{
		return this.score;
	}

	public int getFours()
	{
		return this.fours;
	}

	public int getSixes()
	{
		return this.sixes;
	}

	public int getBallsFaced()
	{
		return this.ballsFaced;
	}
}