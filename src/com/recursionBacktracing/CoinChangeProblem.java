package com.recursionBacktracing;

public class CoinChangeProblem {
    public static int solve(int arr[], int target) {
        if (target == 0) {
            return 0;
        }
        if (target < 0) {
            return Integer.MAX_VALUE; // Return -1 to indicate that it's not possible to reach the target.
        }
        int mini = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int ans = solve(arr, target - arr[i]);
            if (ans != Integer.MAX_VALUE) {
                /**
                 *  her baar check kro ans me 1 kyu add kiya gya h
                 */
                mini = Math.min(ans + 1, mini); // Add 1 to the count.
            }
        }
        return  mini; // Return -1 if the target is not achievable.
    }

    public static void main(String[] args) {
        int arr[] = {1, 2};
        int target = 5;
        int finalAns = solve(arr, target);
        System.out.println("ans=" + finalAns);
    }
}
