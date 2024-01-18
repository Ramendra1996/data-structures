package com.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class KdiffPairInAnArrayLeetCode532 {

   static class Pair{
        private int first;
         private int second;

         Pair(int first, int second){
             this.first= first;
              this.second= second;
         }
         Pair(){

         }
    }
   // brute force method
    static int getDiff(int nums[], int k){
        int count =0;
        for(int i=0;i<nums.length;i++){
            for (int j=i+1;j< nums.length;j++){
                if(Math.abs(nums[j]-nums[i])==k){
                count++;
                }
            }
        }
        return count;
    }

    // TC: O(n log n) method
    static int getDiff1(int nums[], int k) {
        Arrays.sort(nums);
        Set<Pair> ans = new HashSet<>();
        int i = 0;
        int j = 1;
        while (i < nums.length && j < nums.length) {
            Pair p = new Pair(nums[i], nums[j]);
            if (nums[j] - nums[i] == k) {
                ans.add(p);
                i++;
                j++;
            } else if (nums[j] - nums[i] > k) {
                i++;
            } else {
                j++;
            }
            if (i == j) {
                j++;
            }
        }
        return ans.size();
    }

    public static void main(String[] args) {
        int nums[]={1,1,1,1,1};
        int k = 0;
        int diff = getDiff(nums, k);
        System.out.println(diff);
        int diff1 = getDiff1(nums, k);
        System.out.println(diff1);
    }
}
