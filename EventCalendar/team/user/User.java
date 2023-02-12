package team.user;

import time.TimeConverter;

public class User
{
	String userId;
	int teamId;
	int[] start, end;
	public User(String[] data)
	{
		this.userId = data[0];
		this.start = TimeConverter.convertStringTo24Format(data[1]);
		this.end = TimeConverter.convertStringTo24Format(data[2]);
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