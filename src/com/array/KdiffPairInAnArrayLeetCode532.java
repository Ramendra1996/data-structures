package com.array;

import java.util.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class KdiffPairInAnArrayLeetCode532 {


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

    static  class  Pair{
        int first;
        int second;
        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return first == pair.first && second == pair.second;
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second);
        }
    }

    // TC: O(n log n) method
    public  static  int getKDiff1(int nums [], int k){
        Arrays.sort(nums);
        Set<Pair> set = new HashSet<>();
        int i=0;
         int j = 1;
        while (i<j && j<nums.length){
            int diff = nums[j]- nums[i];

            if(diff== k){
                set.add(new Pair(nums[i],nums[j]));
                i++;
                j++;
            } else if (diff>k) {
                i++;
            }else {
                j++;
            }
        }
        return set.size();
    }


    public static void main(String[] args) {
        int nums[]={1,1,1,1,1};
        int k = 0;
        int diff = getDiff(nums, k);
        System.out.println(diff);
        int kDiff1 = getKDiff1(nums, k);
        System.out.println(kDiff1);
    }
}
