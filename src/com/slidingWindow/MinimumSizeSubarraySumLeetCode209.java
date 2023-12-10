package com.slidingWindow;

public class MinimumSizeSubarraySumLeetCode209 {
    public static int minSubArrayLen(int target, int[] nums) {
        int i=0;
        int j=0;
        int sum=0;
        int len = Integer.MAX_VALUE;
        while(j<nums.length){
            //incclude current element
            sum+=nums[j];
            //mere pass eke window ka sum ready h
            while(sum>=target){
                //minimise -> sum me se desc kro,len bi update kro,i ko aage badana padega
                len =Math.min(len,j-i+1);
                sum-=nums[i];
                i++;
            }
            j++;
        }
        if(len==Integer.MAX_VALUE){
            return 0;
        }else{
            return len;
        }

    }
    public static void main(String[] args) {
        int nums[]={2,3,1,2,4,3};
        int target =7;
        int finalAns = minSubArrayLen(target, nums);
        System.out.println("finalAns=>"+finalAns);
    }
}
