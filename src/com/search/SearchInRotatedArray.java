package com.search;

public class SearchInRotatedArray {
    static int getPivotMax(int nums[]){
        int start =0;
        int end = nums.length-1;
        while (start<=end){
            if(start==end){
                return start;
            }
            int mid = start+(end-start)/2;
            if(mid<=end && nums[mid]>nums[mid+1]){
                return mid;
            }
            if(mid>start && nums[mid-1]>nums[mid]){
                return mid-1;
            }
            if(nums[start]>nums[mid]){
                end=mid-1;
            }else {
                start=mid+1;
            }
        }
        return -1;
    }
    static int binarySearch(int nums[], int start, int end, int target){
         while (start<=end){
             int mid = start+(end-start)/2;
             if(nums[mid]==target){
                 return mid;
             } else if (nums[mid]>target) {
                 end=mid-1;
             }else {
                 start=mid+1;
             }
         }
          return -1;
    }
    static int search(int[] nums, int target) {
        int pivotIndex = getPivotMax(nums);
        int ans =0;
        if(target>=nums[0] && target<= nums[pivotIndex]){
             ans = binarySearch(nums,0,pivotIndex,target);
        }else {
            ans = binarySearch(nums,pivotIndex+1,nums.length-1,target);
        }
        return ans;
    }
    public static void main(String[] args) {

        int nums[]={1,3};
        int target =0;
        int search = search(nums, target);
        System.out.println(search);
    }
}
