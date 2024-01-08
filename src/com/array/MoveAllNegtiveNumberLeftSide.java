package com.array;

public class MoveAllNegtiveNumberLeftSide {
    void swap(int nums[], int i, int j){
         int temp =nums[i];
         nums[i]=nums[j];
         nums[j]=temp;
    }
    void moveNegtive(int nums[]){
        int low = 0;
        int high = nums.length-1;
        while (low<high){
            if(nums[low]<0){
                low++;
            } else if (nums[high]>0) {
                high--;
            }else {
                swap(nums,low,high);
            }
        }
    }
    public static void main(String[] args) {
        int nums[]={-2,3,4,-6,-5,9};
        MoveAllNegtiveNumberLeftSide move = new MoveAllNegtiveNumberLeftSide();
        move.moveNegtive(nums);
        for(int i:nums){
            System.out.print(i+" ");
        }
    }
}
