package com.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberOfDiceRollWithTargetSumLeetCode1155 {

  static   long MOD =1000000007;

  static int spaceOptimization(int n , int k , int target){
     List<Long>prev = new ArrayList<>(Collections.nCopies(target+1,0L));
     List<Long>curr = new ArrayList<>(Collections.nCopies(target+1,0L));
     prev.set(0,1L);
      for(int index =1;index <=n;index++){
          for (int t=1;t<=target;t++){
              long ans =0;
              for (int i=1;i<=k;i++){
                  if (t - i >= 0) {
                      ans = (ans%MOD +prev.get(t-i)%MOD)%MOD;

                  }
              }
            curr.set(t,ans);
          }
          prev= new ArrayList<>(curr);
      }
      return Math.toIntExact(prev.get(target));
  }
  static  int bottomUpApproach(int n , int k , int target){
      List<List<Long>> dp = new ArrayList<>(n+1);
      for (int i = 0; i <= n; i++) {
          dp.add(new ArrayList<>(Collections.nCopies(target + 1, 0L)));
      }
      dp.get(0).set(0,1L);

      for(int index =1;index <=n;index++){
          for (int t=1;t<=target;t++){
              long ans =0;
              for (int i=1;i<=k;i++){
                  if (t - i >= 0) {
                      ans = (ans%MOD +bottomUpApproach(n - 1, k, t - i)%MOD)%MOD;

                  }
              }
              dp.get(index).set(t, ans);
          }
      }
      return Math.toIntExact(dp.get(n).get(target));
  }
    static int topDownApproach(int n , int k , int target,List<List<Long>> dp ){
        if(n<0){
            return 0;
        }
        if(n==0 && target==0){
            return 1;
        }
        if(n==0 && target!=0){
            return 0;
        }
        if(n!=0 && target==0){
            return 0;
        }
        if(dp.get(n).get(target)!=-1){
             return Math.toIntExact(dp.get(n).get(target));
        }
        long ans =0;
        for (int i=1;i<=k;i++){
            if (target - i >= 0) {
                ans = (ans%MOD +topDownApproach(n - 1, k, target - i, dp)%MOD)%MOD;
            }
        }
        dp.get(n).set(target,ans);
        return Math.toIntExact(dp.get(n).get(target));
    }

    static int solveRecursion(int n, int k, int target){
        if(n<0){
            return 0;
        }
        if(n==0 && target==0){
            return 1;
        }
        if(n==0 && target!=0){
            return 0;
        }
        if(n!=0 && target==0){
            return 0;
        }
        int ans =0;
         for (int i=1;i<=k;i++){
            ans = ans+solveRecursion(n-1,k,target-i);
         }
       return ans;
    }
    public static void main(String[] args) {
        int n =2;
         int k =6;
         int target =7;

        System.out.println(solveRecursion(n,k,target));
        List<List<Long>> dp = new ArrayList<>(n+1);
        for (int i = 0; i <= n; i++) {
            dp.add(new ArrayList<>(Collections.nCopies(target + 1, -1L)));
        }
        System.out.println(topDownApproach(n,k,target,dp));

        System.out.println(bottomUpApproach(n,k,target));
        System.out.println(spaceOptimization(n,k,target));
    }

}
