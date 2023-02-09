package team;

import java.util.List;
import java.util.Queue;

import java.util.ArrayList;
import java.util.LinkedList;

import team.player.Player;
import team.player.Member;

public class Team
{
	public static final int NO_OF_PLAYERS = 11;
	private List<Player> players;
	private int teamScore;
	private int teamWickets;
	public Team(String[] playerDetails)
	{
		this.players = new ArrayList<Player>();

		//throw an exception here if bat+bowl != 11
		for (String player : playerDetails)
		{
			String[] tokens = player.split(",");
			players.add(new Member(tokens[0],Integer.parseInt(tokens[1]),Integer.parseInt(tokens[2])));
			//throw an exception for else block
		}

		this.teamScore = this.teamWickets = 0;
	}
	public List<Player> getPlayers()
	{
		return this.players;
	}
	public Player getPlayerByJerseyNumber(int jerseyNumber)
	{
		for (Player player : players)
		{
			if (player.getJerseyNumber() == jerseyNumber)
				return player;
		}
		return null;
	}
	public void updateWickets()
	{
		++this.teamWickets;
	}
	public void updateTeamScore()
	{
		++this.teamScore;
	}
	public int getTeamScore()
	{
		return this.teamScore;
	}
	public int getTeamWickets()
	{
		return this.teamWickets;
	}
}