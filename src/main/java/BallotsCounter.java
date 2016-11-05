import java.util.*;

/**
 * https://www.codewars.com/kata/who-won-the-election/java
 */
public class BallotsCounter {

    public static String getWinnerOld(final List<String> listOfBallots) {
        Map<String, Integer> cadidates = new HashMap<>();
        for (String listOfBallot : listOfBallots) {
            cadidates.put(listOfBallot, cadidates.getOrDefault(listOfBallot, 0) + 1);
        }

        String winner = "";
        for (Map.Entry<String, Integer> cadidate : cadidates.entrySet()) {
            if (cadidate.getValue() > cadidates.getOrDefault(winner, 0)) {
                winner = cadidate.getKey();
            }
        }

        return listOfBallots.size() / 2 < cadidates.get(winner) ? winner : null;
    }


    /**
     * Better solution, Thanks @MindWanderer for teach me!
     */
    public static String getWinner(final List<String> listOfBallots) {
        HashSet<String> cadidates = new HashSet<>(listOfBallots);
        for (String cadidate : cadidates) {
            if (Collections.frequency(listOfBallots, cadidate) > listOfBallots.size() / 2) return cadidate;
        }

        return null;
    }
}