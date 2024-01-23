package com.search;

import java.util.Arrays;

public class PrataSpojProblem {
    static boolean isPossible(int cookRank[], int n, int mid) {
        int currentP = 0;
        for (int i = 0; i < cookRank.length; i++) {
            int r = cookRank[i], j = 1;
            int timeTaken = 0;

            while (true) {
                if (timeTaken + j * r <= mid) {
                    currentP++;
                    timeTaken += j * r;
                    j++;
                } else {
                    break;
                }
            }
            if (currentP >= n) {
                return true;
            }
        }
        return false;
    }
    static int getSolve(int cookRank[], int n) {
        int start = 0;
        int heightRank = Arrays.stream(cookRank).max().orElse(0);
        int end = heightRank * (n * (n + 1) / 2);
        int ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isPossible(cookRank, n, mid)) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int cookRank[] = {1, 2, 3, 4};
        int n = 10;
        int solve = getSolve(cookRank, n);
        System.out.println(solve);
    }
}
