package team.player;

public interface Player
{
	public String getName();
	public int getJerseyNumber();
	public int getScore();
	public int getFours();
	public int getSixes();
	public int getBallsFaced();
	public void updateScore(int run);
	public void updateBalls();
	public void updateFours();
	public void updateSixes();
}