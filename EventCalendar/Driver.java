import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.io.File;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import team.Team;
import team.user.User;
import event.Event;
import time.TimeConverter;
import event.Event;
import exception.UserNotAvailable;
import exception.TeamNotAvailable;
import exception.WorkingHourExceeded;

public class Driver
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

		String fileName = console.readLine();
		BufferedReader file = new BufferedReader(new FileReader(new File(fileName)));

		// create users
		int noOfUsers = Integer.parseInt(file.readLine());
		Map<String,User> users = new HashMap<>();
		for (int i = 0; i < noOfUsers; ++i)
		{
			String[] userData = file.readLine().trim().split(",");
			users.put(userData[0],new User(userData));
		}

		//create teams
		int noOfTeams = Integer.parseInt(file.readLine());
		Map<String,Team> teams = new HashMap<>();
		for (int team = 0; team < noOfTeams; ++team)
		{
			String[] teamData = file.readLine().trim().split(",");
			List<User> userList = new ArrayList<>();
			for (int i = 1; i < teamData.length; ++i)
				userList.add(users.get(teamData[i]));
			teams.put(teamData[0],new Team(teamData[0],userList));
		}

		//create events
		int noOfEvents = Integer.parseInt(file.readLine());
		int eventId = 0;
		Map<Integer,Event> events = new HashMap<>();
		for (; eventId < noOfEvents; ++eventId)
		{
			String[] eventUsers = file.readLine().trim().split(",");
			List<User> userList = new ArrayList<>();
			for (String userId : eventUsers)
				userList.add(users.get(userId));
			String[] eventTeams = file.readLine().trim().split(",");
			List<Team> teamList = new ArrayList<>();
			for (String teamId : eventTeams)
				teamList.add(teams.get(teamId));
			int representatives = Integer.parseInt(file.readLine());
			String day = file.readLine();
			String startTime = file.readLine();
			String endTime = file.readLine();
			try{
			events.put(eventId,new Event(userList,teamList,representatives,day,startTime,endTime));
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
	}
}