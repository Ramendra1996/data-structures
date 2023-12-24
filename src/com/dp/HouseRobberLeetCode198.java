package com.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HouseRobberLeetCode198 {

    static  int spaceOptimization(int nums[], int n){
        int prev2=0;
         int prev1=nums[0];
         int curr =0;
         for(int i=1;i<=n;i++){
             int temp=0;
             if(i-2>=0){
                 temp = prev2;
             }
             int include = temp +nums[i];
             int exclude = prev1;
             curr=Math.max(include,exclude);
             prev2=prev1;
             prev1=curr;
         }
         return prev1;
    }

    static int bottomUpApproach(int nums[],int n){
        List<Integer>dp = new ArrayList<>(Collections.nCopies(n+1,0));
        dp.set(0,nums[0]);
        for(int i=1;i<=n;i++){


           //  int include = dp.get(i-2)+nums[i];
        //    int include =(i >= 2 ? dp.get(i - 2) : 0) + nums[i - 1];
            int temp =0;
            if(i>=2){
                temp = dp.get(i-2);
            }
              int  include = temp+nums[i];

             int exclude = dp.get(i-1);
             dp.set(i, Math.max(include,exclude));
        }
     return dp.get(n);
    }

    static int topDownApproach(int nums[],int n,List<Integer>dp){
        if(n<0){
            return 0;
        }
        if(n==0){
            return nums[0];
        }
        if(dp.get(n)!=-1){
            return dp.get(n);
        }
        //include
        int include = topDownApproach(nums,n-2,dp)+nums[n];
        //exclude
        int exclude =topDownApproach(nums,n-1,dp);

        dp.set(n,Math.max(include,exclude));
        return dp.get(n);

    }
    //n represent  the index of current house
    static int solveByRecursion(int nums[], int n){
     if(n<0){
         return 0;
     }
     if(n==0){
         return nums[0];
     }
     //include
        int include = solveByRecursion(nums,n-2)+nums[n];
     //exclude
       int exclude =solveByRecursion(nums,n-1);

       return Math.max(include,exclude);
    }
    public static void main(String[] args) {
        int [] nums ={1};
        int n = nums.length-1;
        System.out.println(solveByRecursion(nums,n));
        List<Integer>dp = new ArrayList<>(Collections.nCopies(n+1,-1));
        System.out.println(topDownApproach(nums,n,dp));
        System.out.println(bottomUpApproach(nums,n));
        System.out.println(spaceOptimization(nums,n));
    }
}
