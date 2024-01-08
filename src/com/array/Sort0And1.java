package com.array;

import java.util.Scanner;
public class Sort0And1 {
    void swap(int nums[], int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
   /* void sortArray(int nums[]){
        int nextZero = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
               swap(nums,nextZero,i);
                nextZero += 1;
            }
        }
    }*/

    void sortArray(int nums[]){
        int low =0;
         int high= nums.length-1;

         while (low<high){

             if(nums[low]==0){
                 low++;
             } else if (nums[high]==1) {
                 high--;
             }else {
                 swap(nums,low,high);
             }
         }
    }

    public static void main(String[] args) {
        Sort0And1 s = new Sort0And1();
       /* System.out.println("Enter the size of array:");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int nums[] = new int[n];
        System.out.println("Enter the elements of the array (0 or 1):");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }*/
        int nums[]={0,1,1,0,0,1,0};
        s.sortArray(nums);
        for (int i:nums){
            System.out.print(i+" ");
        }
    }
}
