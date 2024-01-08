package com.array;

public class Sort01and2LeetCode75 {

    void swap(int nums[], int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    void sortArray(int nums[]) {
        if (nums.length==0){
            System.out.println("array is empty:");
        }
        int start = 0;
        int mid = 0;
        int end = nums.length - 1;
        while (mid<end){
            if(nums[mid]==0){
                swap(nums,start,mid);
                start++;
                mid++;
            } else if (nums[mid]==1) {
                mid++;
            }else {
                swap(nums,mid,end);
                end--;
            }
        }
    }

    public static void main(String[] args) {
        Sort01and2LeetCode75 s = new Sort01and2LeetCode75();
        int nums[] = {2, 0, 2, 1, 1, 0,0,0,0,1,1,1,2,2,2};
        s.sortArray(nums);

        for (int i :nums){
            System.out.print(i+" ");
        }
    }

}
