package com.dp;

import java.util.Arrays;

public class RussianDollEnvelopes {
  /*  public static int maxEnvelopes(int[][] envelopes) {
        // Sort the envelopes based on width in ascending order
        Arrays.sort(envelopes, (a, b) -> a[0] - b[0]);

        int n = envelopes.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int maxEnvelopes = 1;

        // Dynamic Programming to find the maximum number of nested envelopes
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[i][1] > envelopes[j][1] && envelopes[i][0] > envelopes[j][0]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxEnvelopes = Math.max(maxEnvelopes, dp[i]);
        }

        return maxEnvelopes;
    }*/
    public static void main(String[] args) {
        int [][] envelopes={{5,4},{6,4},{6,7},{2,3}};
    }
}
