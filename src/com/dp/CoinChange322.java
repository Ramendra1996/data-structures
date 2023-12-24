package com.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CoinChange322 {

    static  int bottomUpApproach(int[] coins, int amount){
        List<Integer>dp = new ArrayList<>(Collections.nCopies(amount+1,Integer.MAX_VALUE));
        dp.set(0,0);
        for (int i=1;i<=amount;i++){
            for (int j=0;j<coins.length;j++){
                if(i-coins[j]>=0 &&dp.get(i-coins[j])!=Integer.MAX_VALUE){
                  int ans =dp.get(i-coins[j]);
                  dp.set(i,Math.min(dp.get(i),1+ans));
                }
            }
        }
        return dp.get(amount);
    }

    static  int solveTopDownApproach(int[] coins, int amount,List<Integer>dp){
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return Integer.MAX_VALUE;
        }
        if(dp.get(amount)!=-1){
            return dp.get(amount);
        }
        int mini = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int ans = solveTopDownApproach(coins, amount - coins[i],dp);
            if (ans != Integer.MAX_VALUE) {
                mini = Math.min(mini, 1+ans);
            }
        }
        dp.set(amount,mini);
        return mini;

    }
    static int solveRecursion(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return Integer.MAX_VALUE;
        }
        int mini = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int ans = solveRecursion(coins, amount - coins[i]);
            if (ans != Integer.MAX_VALUE) {
                mini = Math.min(mini, 1+ans);
            }
        }
        return mini;
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        List<Integer>dp = new ArrayList<>(Collections.nCopies(amount+1,-1));
      //  int ans = solveRecursion(coins, amount);
       // int ans = solveTopDownApproach(coins,amount,dp);
        int ans =bottomUpApproach(coins,amount);

        if(ans ==Integer.MAX_VALUE){
            System.out.println("-1");
        }else {
            System.out.println("miniCoins=>"+ans);
        }
    }
}
