package com.jaynarol.codewars.java.codewarsranking;

import java.util.Arrays;
import java.util.List;

/**
 * https://www.codewars.com/kata/codewars-style-ranking-system/java
 * Improve code after seen other solution, Thanks all guys for teach me!!
 */
public class UserBetter {

    public int rank = -8;
    public int progress = 0;
    private List<Integer> ranks = Arrays.asList(-8, -7, -6, -5, -4, -3, -2, -1, 1, 2, 3, 4, 5, 6, 7, 8);
    private List<Integer> pointFix = Arrays.asList(0, 1, 3);

    public void incProgress(int rankPoint) {

        // validate rankPoing
        if (!ranks.contains(rankPoint)) throw new RuntimeException("invalid rankPoint");

        // range calulate
        int diff = ranks.indexOf(rankPoint) - ranks.indexOf(rank);
        diff = (diff < -1) ? -2 : diff;

        // progress increase and rank up
        progress += (diff > 0) ? (10 * diff * diff) : pointFix.get(diff + 2);
        if (progress >= 100) {
            int rankup = Math.floorDiv(progress, 100);
            rank = ranks.get(ranks.indexOf(rank) + rankup);
            progress %= 100;
        }

        // for sure rank and progress not over ceil
        if (rank >= 8) progress = 0;

    }

}
