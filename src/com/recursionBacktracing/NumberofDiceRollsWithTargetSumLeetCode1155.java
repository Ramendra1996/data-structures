package com.recursionBacktracing;

//dp qustion
public class NumberofDiceRollsWithTargetSumLeetCode1155 {
    static int minRollsToTarget(int n, int k, int target) {
        if (target < 0) {
            return 0;
        }
        if (n == 0 && target == 0) {
            return 1;
        }
        if (n == 0 && target != 0) {
            return 0;
        }
        if (n != 0 && target == 0) {
            return 0;
        }
        int ans = 0;
        for (int i = 1; i <= k; i++) {
            ans += minRollsToTarget(n - 1, k, target - i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 2, k = 6, target = 7;
        int i = minRollsToTarget(n, k, target);
        System.out.println(i);
    }
}
