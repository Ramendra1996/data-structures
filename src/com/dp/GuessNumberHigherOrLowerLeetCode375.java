package com.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GuessNumberHigherOrLowerLeetCode375 {
    static  int bottomUpApproach(int n){
        List<List<Integer>> dp = new ArrayList<>(n+2);
        for (int i = 0; i <=n+1; i++) {
            dp.add(new ArrayList<>(Collections.nCopies( n+ 1, 0)));
        }
        for(int start =n;start>=1;start--){
            for (int end =1;end<=n;end++){
                if(start>=end){
                    continue;
                }
                int ans = Integer.MAX_VALUE;
                for(int i =start;i<=end;i++){
                    ans=Math.min(ans,i+Math.max(dp.get(start).get(i - 1), dp.get(i + 1).get(end)));
                }
                dp.get(start).set(end,ans);
            }
        }
        return dp.get(1).get(n);
    }
    static int topDownApproach(int start , int end , List<List<Integer>>dp){
        if(start>=end){
            return 0;
        }
        if(dp.get(start).get(end)!=-1){
            return dp.get(start).get(end);
        }
        int ans = Integer.MAX_VALUE;
        for (int i = start;i<=end;i++){
            ans = Math.min(ans,i+Math.max(topDownApproach(start,i-1,dp),topDownApproach(i+1,end,dp)));
        }
        dp.get(start).set(end,ans);

       return dp.get(start).get(end);
    }
    static int solveRecursion(int start, int end) {
        if(start>=end){
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = start;i<=end;i++){
            ans = Math.min(ans,i+Math.max(solveRecursion(start,i-1),solveRecursion(i+1,end)));
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 10;
        int ans = solveRecursion(1, n);
        System.out.println(ans);

        List<List<Integer>> dp = new ArrayList<>(n+1);
        for (int i = 0; i <=n; i++) {
            dp.add(new ArrayList<>(Collections.nCopies( n+ 1, -1)));
        }
        System.out.println(topDownApproach(1,n,dp));
        System.out.println(bottomUpApproach(n));
    }
}
