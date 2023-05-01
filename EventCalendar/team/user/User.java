package team.user;

import java.util.Map;
import java.util.HashMap;
// import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;

import time.TimeConverter;

public class User
{
	String userId;
	int teamId;
	int start, end;
	Map<Integer,List<int[]>> eventMap;
	public User(String[] data)
	{
		this.userId = data[0];
		this.start = TimeConverter.convertStringTo24Format(data[1]);
		this.end = TimeConverter.convertStringTo24Format(data[2]);
		this.teamId = -1;
		this.eventMap = new HashMap<>();
	}
	public void setTeam(int teamId)
	{
		this.teamId = teamId;
	}
	public int getTeamId()
	{
		return this.teamId;
	}
	public void addEvent(int day, int start, int end)
	{
		if (!eventMap.containsKey(day))
			eventMap.put(day,new ArrayList<int[]>());
		eventMap.get(day).add(new int[]{start,end});
	}
	public boolean isAvailable(int day, int start, int end)
	{
		boolean available = true;
		for (int[] interval : eventMap.get(day))
		{
			
		}
		return available;
	}
}