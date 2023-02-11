package team.user;

public class User
{
	String userId;
	int teamId;
	int[] start, int[] end;
	public User(String id, int[] start, int[] end)
	{
		this.userId = id;
		this.start = start;
		this.end = end;
		this.teamId = -1;
	}
	public void setTeam(int teamId)
	{
		this.teamId = teamId;
	}
	public int getTeamId()
	{
		return this.teamId;
	}
}