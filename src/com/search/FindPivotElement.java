package com.search;

public class FindPivotElement {

    //aager hme minimum number ko pivot maane
    static int getPivotMini(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] >= nums[0]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    static int getPivotMax(int nums[]){
        int start =0;
        int end = nums.length-1;
        while (start<=end){
            if(start==end){
                return start;
            }
            int mid = start+(end-start)/2;
            if(mid+1<=end && nums[mid]>nums[mid+1]){
                return mid;
            }
            if(mid-1>=start && nums[mid-1]>nums[mid]){
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
    public static void main(String[] args) {
      int nums[]={9,10,2,4,6,8};
        int pivotMini = getPivotMini(nums);
        System.out.println("pivotIndex=>"+pivotMini);
        System.out.println("pivotElment=>"+nums[pivotMini]);
        int pivotMax = getPivotMax(nums);
        System.out.println("pivotIndex=>"+pivotMax);
        System.out.println("pivotElement=>"+nums[pivotMax]);

    }
}
