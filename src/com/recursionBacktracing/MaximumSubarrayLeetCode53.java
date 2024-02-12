package com.recursionBacktracing;

public class MaximumSubarrayLeetCode53 {
    static int maxSubArrayHelper(int nums[], int start, int end){
        if(start== end){
            return nums[start];
        }
        int maxLeftBoarderSum=Integer.MIN_VALUE;
        int maxOfRightBoarderSum=Integer.MIN_VALUE;
        int leftBoarderSum=0;
        int rightBoarderSum=0;
        int mid = start+((end-start)>>1);
        int maxLeftSum=maxSubArrayHelper(nums,start,mid);
        int maxRightSum =maxSubArrayHelper(nums,mid+1,end);

        //max Cross Boarder sum
        for(int i=mid ; i>=start;i--){
         leftBoarderSum+=nums[i];
         if(leftBoarderSum>maxLeftBoarderSum){
             maxLeftBoarderSum=leftBoarderSum;
         }
        }
        for(int i=mid+1;i<=end;i++){
            rightBoarderSum+=nums[i];
            if(rightBoarderSum>maxOfRightBoarderSum){
                maxOfRightBoarderSum=rightBoarderSum;
            }
        }
        int crossBoarderSum =maxLeftBoarderSum+maxOfRightBoarderSum;
        return Math.max(maxLeftBoarderSum ,Math.max(maxOfRightBoarderSum,crossBoarderSum));
    }

    static int maxSubArray1(int[] nums) {
         return maxSubArrayHelper(nums,0,nums.length-1);
    }
    static int maxSubArray(int[] nums) {
        int  maxi = nums[0];
        int sum =0;
        for(int index=0;index<nums.length;index++){
            sum+=nums[index];
            maxi=Math.max(maxi,sum);
            if(sum<0){
                sum=0;
            }
        }
        return maxi;
    }
    public static void main(String[] args) {
        int nums[]={-2,1,-3,4,-1,2,1,-5,4};
        int i = maxSubArray(nums);
        System.out.println(i);
        int i1 = maxSubArray1(nums);
        System.out.println(i1);

    }
}
