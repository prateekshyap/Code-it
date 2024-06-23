import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;

import player.Player;
import player.PlayerImpl;

import match.Match;
import match.Single;
import match.Series;
import match.Knockout;
import match.Tournament;

import print.ScorePrinter;
import print.ScorePrinterKnockout;
import print.ScoreBoardPrinter;
import print.ScoreBoardPrinterKnockout;

public class Arena
{
	public static void main(String[] args) throws Exception
	{
        //printing the initial message
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("                           Magical Arena");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println();
        System.out.println("Create a text file with the following format:");
        System.out.println("    1. The first row contains the total number of players.");
        System.out.println("    2. Each subsequent row contains a player’s name, health\n       , strength, and attack, separated by commas.");
        System.out.println();
        System.out.println("Example:");
        System.out.println();
        System.out.println("2");
        System.out.println("A,50,5,10");
        System.out.println("B,100,10,5");
        System.out.println();
        System.out.println("Enter the input file name:");

        //reading the file name and opening in read mode
		BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
		String fileName = consoleReader.readLine();
		BufferedReader fileReader = new BufferedReader(new FileReader(new File(fileName)));

        //creating players
        //map/json/database implementations are optimal
        int playerCount = Integer.parseInt(fileReader.readLine());
        String[] playerName = new String[playerCount];
        Player[] player = new Player[playerCount];
        for (int playerIndex = 0; playerIndex < playerCount; ++playerIndex) {
            String[] tokens = fileReader.readLine().trim().split("[,]+");
            playerName[playerIndex] = tokens[0];
            //name, health, strength, attack
            player[playerIndex] = new PlayerImpl(tokens[0],Integer.parseInt(tokens[1]),Integer.parseInt(tokens[2]),Integer.parseInt(tokens[3]));
        }
        fileReader.close();

        //printing message
        System.out.println();
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Create a text file with the following format:");
        System.out.println("     1. First line: Match type (Knockout or Tournament).");
        System.out.println("     2. Second line: Number of matches.");
        System.out.println("     3. Next lines: Player names for each match, separated by commas.");
        System.out.println("For tournaments, total number of players should be exactly 8.");
        System.out.println("You cannot mix different types of matches in one file.");
        System.out.println("You can only enter the player names whose details are already available in "+fileName+".");
        System.out.println();
        System.out.println("Example:");
        System.out.println();
        System.out.println("Tournament");
        System.out.println("2");
        System.out.println("A,B,C,D,G,H,J,K");
        System.out.println("B,C,D,H,J,K,M,P");
        System.out.println();
        System.out.println("Enter the input file name:");
        
        //reading the file name and opening in read mode
		fileName = consoleReader.readLine();
		fileReader = new BufferedReader(new FileReader(new File(fileName)));

        String matchType = fileReader.readLine();
        int matchCount = Integer.parseInt(fileReader.readLine());
        switch(matchType) {
            case "Knockout":
                //create matches
                Single[] match = new Single[matchCount];
                for (int matchIndex = 0; matchIndex < matchCount; ++matchIndex) {
                    String[] tokens = fileReader.readLine().trim().split("[,]+");
                    Player player1 = null, player2 = null;
                    for (int playerIndex = 0; playerIndex < playerCount; ++playerIndex) {
                        if (playerName[playerIndex].equals(tokens[0])) {
                            player1 = player[playerIndex];
                        }
                        if (playerName[playerIndex].equals(tokens[1])) {
                            player2 = player[playerIndex];
                        }
                    }
                    match[matchIndex] = new Knockout(player1, player2);
                }
                //start matches
                for (int matchIndex = 0; matchIndex < matchCount; ++matchIndex) {
                    match[matchIndex].play();
                    ScorePrinter scorePrinter = new ScorePrinterKnockout();
                    scorePrinter.printScoreToConsole(match[matchIndex]);
                    System.out.println("Do you want to print the complete score table? (Y/N)");
                    String inputString = consoleReader.readLine();
                    if (inputString.equals("y") || inputString.equals("Y")) {
                        ScoreBoardPrinter scoreBoardPrinter = new ScoreBoardPrinterKnockout();
                        scoreBoardPrinter.printScoreBoardToConsole(match[matchIndex]);
                    }
                }
            break;
            case "Tournament":
                //create matches
                Series[] series = new Series[matchCount];
                for (int seriesIndex = 0; seriesIndex < matchCount; ++seriesIndex) {
                    String[] tokens = fileReader.readLine().trim().split("[,]+");
                    Player[] tournamentPlayer = new Player[8];
                    for (int playerIndex = 0; playerIndex < playerCount; ++playerIndex) {
                        for (int tokenIndex = 0; tokenIndex < 8; ++tokenIndex) {
                            if (playerName[playerIndex].equals(tokens[tokenIndex])) {
                                tournamentPlayer[tokenIndex] = player[playerIndex];
                                continue;
                            }
                        }
                    }
                    series[seriesIndex] = new Tournament(tournamentPlayer);
                }
                //start matches
                for (int seriesIndex = 0; seriesIndex < matchCount; ++seriesIndex) {
                    series[seriesIndex].play();
                    Single[] matches = series[seriesIndex].getAllMatches();
                    ScorePrinter scorePrinter = new ScorePrinterKnockout();
                    for (int m = 0; m < matches.length; ++m) {
                        scorePrinter.printScoreToConsole(matches[m]);
                    }
                    System.out.println("Do you want to print the complete score table? (Y/N)");
                    String inputString = consoleReader.readLine();
                    if (inputString.equals("y") || inputString.equals("Y")) {
                        ScoreBoardPrinter scoreBoardPrinter = new ScoreBoardPrinterKnockout();
                        for (int m = 0; m < matches.length; ++m) {
                            scoreBoardPrinter.printScoreBoardToConsole(matches[m]);
                        }
                    }
                }
            break;
            default:
                System.out.println("Invalid input");
        }
	}
}