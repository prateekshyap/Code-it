package team;

import java.util.List;
import java.util.ArrayList;

import team.user.User;

public class Team
{
	List<User> users;
	public Team(List<User> userIds)
	{
		this.users = userIds;
	}
}