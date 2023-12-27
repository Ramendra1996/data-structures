package com.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LongestCommonSubsequenceLeetCode300 {
    private static  int binarySearch(List<Integer> ans, int target) {
        int low = 0, high = ans.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (ans.get(mid) == target) {
                return mid;
            } else if (ans.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

    static int solveOptimal(int []nums){
        List<Integer>ans= new ArrayList<>();
        if(nums.length==0){
            return 0;
        }
        ans.add(nums[0]);
        for (int i=0;i<nums.length;i++){
            if(nums[i]>ans.get(ans.size()-1)){
                //include
                ans.add(nums[i]);
            }else {
                //overwrite
                 //find index of just bada number
                int index = binarySearch(ans,nums[i]);
                ans.set(index, nums[i]);
            }
        }
        return ans.size();
    }

    static int spaceOptimization(int []nums){
     int n = nums.length;
     List<Integer>currRow =new ArrayList<>(Collections.nCopies(n+1,0));
     List<Integer>nextRow =new ArrayList<>(Collections.nCopies(n+1,0));

        for ( int curr =n-1;curr>=0;curr--){
            for ( int prev=curr-1;prev>=-1;prev--){
                //include
                int include =0;
                if(prev==-1 || nums[curr]>nums[prev]){
                    include=1+nextRow.get(curr+1);
                }
                //exclude
                int exclude =0+nextRow.get(prev+1);
                int ans = Math.max(include,exclude);
                   currRow.set(prev+1,ans);
            }
            //shift
            nextRow = new ArrayList<>(currRow);
        }
        return nextRow.get(0);

    }
    static int bottomUpApproach(int []nums, int curr, int prev){
        int n = nums.length;
        if (curr>=nums.length){
            return 0;
        }
        List<List<Integer>>dp = new ArrayList<>(n+1);
        for (int i=0;i<=n;i++){
            dp.add(new ArrayList<>(Collections.nCopies(n+1,0)));
        }
        for (curr =n-1;curr>=0;curr--){
            for (prev=curr-1;prev>=-1;prev--){
                //include
                int include =0;
                if(prev==-1 || nums[curr]>nums[prev]){
                    include=1+dp.get(curr+1).get(curr+1);
                }
                //exclude
                int exclude =0+dp.get(curr+1).get(prev+1);
                int ans = Math.max(include,exclude);
                dp.get(curr).set(prev+1,ans);

            }
        }
        return dp.get(0).get(0);
    }

    static int topDownApproach(int []nums, int curr, int prev,List<List<Integer>>dp){
        if (curr>=nums.length){
            return 0;
        }
        if(dp.get(curr).get(prev+1)!=-1){
            return dp.get(curr).get(prev+1);
        }
        //include
        int include =0;
        if(prev==-1 || nums[curr]>nums[prev]){
            include=1+topDownApproach(nums,curr+1,curr,dp);
        }
        //exclude
        int exclude =0+topDownApproach(nums,curr+1,prev,dp);
        int ans = Math.max(include,exclude);
        dp.get(curr).set(prev+1,ans);
        return dp.get(curr).get(prev+1);
    }
    static int solveRecursion(int []nums, int curr, int prev){
        if (curr>=nums.length){
            return 0;
        }
        //include
        int include =0;
        if(prev==-1 || nums[curr]>nums[prev]){
            include=1+solveRecursion(nums,curr+1,curr);
        }
        //exclude
        int exclude =0+solveRecursion(nums,curr+1,prev);

        int ans = Math.max(include,exclude);

        return ans;

    }
    public static void main(String[] args) {
        int nums []= {10,9,2,5,3,7,101,18};
        int n = nums.length;
        int curr =0;
         int prev=-1;
        System.out.println(solveRecursion(nums,curr,prev));
        List<List<Integer>>dp = new ArrayList<>(n+1);
        for (int i=0;i<=n;i++){
            dp.add(new ArrayList<>(Collections.nCopies(n+1,-1)));
        }
        System.out.println(topDownApproach(nums,curr,prev,dp));

        System.out.println(bottomUpApproach(nums,curr,prev));
        System.out.println(spaceOptimization(nums));
        System.out.println(solveOptimal(nums));
    }
}
