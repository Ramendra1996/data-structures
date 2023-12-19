package com.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FibonacciNumberLeetCode509 {

    static int spaceOptSolve(int n){
       int prev2 =0;
       if(n==0){
           return prev2;
       }

       int prev1=1;
        if (n==1){
            return prev1;
        }
        int curr = 0;
       for(int i=2;i<=n;i++){
           curr =prev1+prev2;
           prev2=prev1;
           prev1=curr;
       }
       return curr;
    }

    static int bottomUpSolve(int n){
        //step1 create dpArray
        List<Integer> dp = new ArrayList<>(Collections.nCopies(n + 1, -1));
        // step2 observe base case in above solution
        dp.set(0,0);
        if(n==0){
            return dp.get(0);
        }
        dp.set(1,1);
        if(n==1){
            return dp.get(1);
        }
        //step 3

        for(int i=2;i<=n;i++){
            dp.set(i,dp.get(i-1)+dp.get(i-2));
        }
       return dp.get(n);
    }

    //recursion +memoization
    static int topDownSolve(int n, List<Integer> dp) {
         if(n==0 || n==1){
             return n;
         }
         //step3 check if ans is exits
         if(dp.get(n)!=-1){
           return dp.get(n);
         }
             // step2 replace  ans in dp
        dp.set(n,topDownSolve(n-1,dp) + topDownSolve(n-2,dp));
         return dp.get(n);
    }

    static int recursive(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return recursive(n - 1) + recursive(n - 2);
    }

    static int fib(int n) {

        // int ans = fib(n-1)+fib(n-2);
        //  return ans;
        // step1 create dp array
      /*  List<Integer> dp = new ArrayList<>(Collections.nCopies(n + 1, -1));
        int ans = topDownSolve(n, dp);
        return ans;*/
        return bottomUpSolve(n);
    }

    public static void main(String[] args) {

        int n = 8;
        System.out.println(fib(n));
    }
}
