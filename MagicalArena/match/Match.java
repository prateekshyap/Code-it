package match;

import player.Player;

public interface Match {
    public Player[] getPlayers();
    public void play();
    public Player getWinner();
}