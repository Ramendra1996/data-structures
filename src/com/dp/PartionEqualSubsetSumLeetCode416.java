package com.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PartionEqualSubsetSumLeetCode416 {
    static boolean solveUsingTabulationSO(int[] nums, int target) {
        int n = nums.length;

        int[] curr = new int[target + 1];
        int[] next = new int[target + 1];

        Arrays.fill(curr, 0);
        Arrays.fill(next, 0);

        curr[0] = 1;
        next[0] = 1;

        for (int index = n - 1; index >= 0; index--) {
            for (int t = 1; t <= target; t++) {
                boolean include = false;
                if (t - nums[index] >= 0)
                    include = (next[t - nums[index]] == 1);

                boolean exclude = (next[t] == 1);

                curr[t] = (include || exclude) ? 1 : 0;
            }
            System.arraycopy(curr, 0, next, 0, target + 1);
        }

        return (next[target] == 1);
    }
    static boolean spaceOptimization(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if ((sum & 1) != 0) {
            return false;
        }
        int target = sum / 2;

        List<Boolean> curr = new ArrayList<>(Collections.nCopies(target + 1, false));
        List<Boolean> next = new ArrayList<>(Collections.nCopies(target + 1, false));

        curr.set(0, true);
        next.set(0, true);

        for (int index = n - 1; index >= 0; index--) {
            for (int t = 1; t <= target; t++) {
                boolean include = false;
                if (t - nums[index] >= 0)
                    include = next.get(t - nums[index]);

                boolean exclude = next.get(t);

                curr.set(t, include || exclude);
            }
            // shift
            next = new ArrayList<>(curr);
        }

        return next.get(target);
    }
    static boolean bottomUpApproach(int[]nums){
        int n = nums.length;
        int sum =0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if((sum &1) !=0){
            return false;
        }
        int target = sum/2;
        List<List<Boolean>> dp = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            dp.add(new ArrayList<>(Collections.nCopies(target + 1, false)));
        }

        for (int i = 0; i <= n; i++) {
            dp.get(i).set(0, true);
        }

        for (int index = n - 1; index >= 0; index--) {
            for (int t = 1; t <= target; t++) {
                boolean include = false;
                if (t - nums[index] >= 0) {
                    include = dp.get(index + 1).get(t - nums[index]);
                }

                boolean exclude = dp.get(index + 1).get(t);
                dp.get(index).set(t, include || exclude);
            }
        }

        return dp.get(0).get(target);
    }
    static boolean topDownApproach(int index,int[]nums, int target,List<List<Boolean>>dp){
        int n = nums.length;
        if(index>=n){
            return false;
        }
        if(target<0){
            return false;
        }
        if(target==0){
            return true;
        }
        if(dp.get(index).get(target)){
            return dp.get(index).get(target);
        }
        boolean include = topDownApproach(index+1,nums,target-nums[index],dp);
        boolean exclude = topDownApproach(index+1,nums,target,dp);
        dp.get(index).set(target,(include||exclude));

        return dp.get(index).get(target);
    }

    static boolean solveRecursion(int index,int[]nums,int target){
        //basecase
        int n = nums.length;
        if(index>=n){
            return false;
        }
        if(target<0){
            return false;
        }
        if(target==0){
            return true;
        }
        boolean include =solveRecursion(index+1,nums,target-nums[index]);
        boolean exclude = solveRecursion(index+1,nums,target);

        return (include || exclude);

    }
    public static boolean canPartition(int[] nums) {
    int sum =0;
    for(int i=0;i<nums.length;i++){
        sum+=nums[i];
    }
    //yha galti hoti h
    if((sum &1)!=0){
        return false;
    }
    int target = sum/2;
    int index =0;
      boolean ans = solveRecursion(index,nums,target);
      return ans;
    }
    public static void main(String[] args) {
      int nums[]={1,5,11,5};
      int n = nums.length;
  /*    //  System.out.println(canPartition(nums));

        int sum =0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        //yha galti hoti h
        if((sum &1)!=0){
            System.out.println("false");
            return;
        }
        int target = sum/2;
        List<List<Boolean>> dp = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            dp.add(new ArrayList<>(Collections.nCopies( target+ 1, false)));
        }
        int index=0;*/
    //    System.out.println(topDownApproach(index,nums,target,dp));
     //   System.out.println(bottomUpApproach(nums));
        System.out.println(spaceOptimization(nums));
        int target =11;
        System.out.println(solveUsingTabulationSO(nums,target));
    }
}
