package event;

import java.util.List;

import team.Team;
import team.user.User;
import time.TimeConverter;
import time.Day;
import exception.UserNotAvailable;

public class Event
{
	List<User> users;
	List<Team> teams;
	int representatives;
	int day;
	int startTime, endTime;
	public Event(List<User> users, List<Team> teams, int representatives, String day, String startTime, String endTime)
	{
		this.users = users;
		this.teams = teams;
		this.representatives = representatives;
		this.day = Day.encodeDay(day);
		this.startTime = TimeConverter.convertStringTo24Format(startTime);
		this.endTime = TimeConverter.convertStringTo24Format(endTime);

		try{
		for (User user : users)
		{
			if (!user.isAvailable(this.day,this.startTime,this.endTime))
				throw new UserNotAvailable("User already occupied");
		}
		}catch(Exception e)
		{
			
		}
	}
}