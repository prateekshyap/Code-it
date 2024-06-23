package match;

import player.Player;
import player.PlayerImpl;

import match.Single;
import match.Series;
import match.Tournament;

class TestTournament {
    public static void main(String[] args) throws Exception {
        TestTournament test = new TestTournament();
        Player[] player = new Player[9];
        for (int i = 0; i < 9; ++i) {
            player[i] = new PlayerImpl(Integer.toString(i),100,10,10);
        }
        test.testCreateTournament(player); // for 9 players
        player = new Player[8];
        for (int i = 0; i < 5; ++i) {
            player[i] = new PlayerImpl(Integer.toString(i),100,10,10);
        }
        test.testCreateTournament(player); // for null player
        for (int i = 5; i < 8; ++i) {
            player[i] = new PlayerImpl(Integer.toString(i),100,10,10);
        }
        Series matches = new Tournament(player);
        test.testPlay(matches);
    }
    void testCreateTournament(Player[] player) {
        try {
        Series matches = new Tournament(player);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    void testPlay(Series matches) {
        matches.play();
        Single[] allMatches = matches.getAllMatches();
        if (allMatches.length != 7) {
            System.out.println("Number of matches in the tournament does not match with the expected value.");
            return;
        }
        String[] leagueWinners = new String[4];
        for (int match = 0; match < 4; ++match) {
            leagueWinners[match] = allMatches[match].getWinner().getName();
        }
        String[] semiWinners = new String[2];
        for (int match = 4; match < 6; ++match) {
            semiWinners[match-4] = allMatches[match].getWinner().getName();
        }
        String tournamentWinner = allMatches[6].getWinner().getName();
        //semi finale winners should be one out of the league winners;
        for (int match = 0; match < 2; ++match) {
            boolean isWinnerInLeague = false;
            for (int league = 0; league < 4; ++league) {
                if (leagueWinners[league] == semiWinners[match]) {
                    isWinnerInLeague = true;
                    break;
                }
            }
            if (!isWinnerInLeague) {
                System.out.println("Wrong winner in Semi finale.");
                return;
            }
        }
        //finale winner should be one out of the semi finale winners
        boolean isWinnerInSemi = false;
        for (int semi = 0; semi < 2; ++semi) {
            if (semiWinners[semi] == tournamentWinner) {
                isWinnerInSemi = true;
                break;
            }
        }
        if (!isWinnerInSemi) {
            System.out.println("Wrong winner in Finale.");
            return;
        }
        System.out.println("Passed.");
    }
}