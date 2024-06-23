package print;

import player.Player;

import match.Single;

public interface ScorePrinter{
    public void printScoreToConsole(Single match);
    public void printScoreToFile();
}