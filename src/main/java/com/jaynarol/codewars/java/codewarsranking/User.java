package com.jaynarol.codewars.java.codewarsranking;

/**
 * https://www.codewars.com/kata/codewars-style-ranking-system/java
 * Original before submit kata
 */
public class User {

    public int rank = -8;
    public int progress = 0;
    private int[] pointFix = new int[]{0, 1, 3};

    public void incProgress(int rankPoint) {

        // validate rankPoing
        if (rankPoint < -8 || rankPoint > 8 || rankPoint == 0) {
            throw new java.lang.RuntimeException();
        }

        // range calulate
        int diff = rankPoint - rank;
        diff += (rank * rankPoint < 0) ? (diff > 0 ? -1 : 1) : 0;
        diff = (diff < -1) ? -2 : diff;

        // progress increase and rank up
        progress += (diff > 0) ? (10 * diff * diff) : pointFix[diff + 2];
        if (progress >= 100) {
            int rankup = Math.floorDiv(progress, 100);
            rank += rankup + (rank * (rank + rankup) <= 0 ? 1 : 0);
            progress %= 100;
        }

        // for sure rank and progress not over ceil
        if (rank >= 8) {
            rank = 8;
            progress = 0;
        }

    }

}
