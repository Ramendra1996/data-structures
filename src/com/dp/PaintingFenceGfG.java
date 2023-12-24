package com.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PaintingFenceGfG {

    static long spaceOptimization(int n, int k){
     int prev2=k;
     int prev1=(k+(k*(k-1)));

     for(int i=3;i<=n;i++){
         int curr =(prev1+prev2)*(k-1);
         prev2=prev1;
         prev1=curr;
     }
     return prev1;
    }

    static  int bottomUpApproach(int n , int k){
        List<Integer>dp = new ArrayList<>(Collections.nCopies(n+1,0));
        dp.set(1,k);
        dp.set(2,(k+k*(k-1)));
        for(int i=3;i<=n;i++){
            dp.set(i,(dp.get(i-1)+dp.get(i-2))*(k-1));
        }
        return dp.get(n);
    }

    static int topDownApproach(int n , int k, List<Integer>dp){
        if (n == 1) {
            return k;
        }
        if (n == 2) {
            return (k + k * (k - 1));
        }
        if(dp.get(n)!=-1){
            return dp.get(n);
        }
         dp.set(n,(topDownApproach(n - 2, k,dp) + topDownApproach(n - 1, k,dp)) * (k - 1));
        return dp.get(n);

    }

    static int solveRecursion(int n, int k) {
        if (n == 1) {
            return k;
        }
        if (n == 2) {
            return (k + k * (k - 1));
        }
        int ans = (solveRecursion(n - 2, k) + solveRecursion(n - 1, k)) * (k - 1);
        return ans;
    }

    public static void main(String[] args) {
        int n = 4;
        int k = 3;
        System.out.println(solveRecursion(n,k));
        List<Integer>dp = new ArrayList<>(Collections.nCopies(n+1,-1));
        System.out.println(topDownApproach(n,k,dp));
        System.out.println(bottomUpApproach(n,k));
        System.out.println(spaceOptimization(n,k));

    }
}
