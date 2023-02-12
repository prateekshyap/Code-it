package team;

import java.util.List;
import java.util.ArrayList;

import team.user.User;

public class Team
{
	String teamId;
	List<User> users;
	public Team(String teamId, List<User> users)
	{
		this.teamId = teamId;
		this.users = users;
	}
}