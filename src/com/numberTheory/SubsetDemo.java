package com.numberTheory;

import java.util.ArrayList;
import java.util.List;

public class SubsetDemo {
    public  static List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;

        int subsetCount = (1<<n); // is equal to 2^n
        List<List<Integer>> subsets = new ArrayList<>();
        for (int mask =0 ;mask<subsetCount;++mask){
            List<Integer>subset = new ArrayList<>();
            for(int i=0;i<n;i++){
                if((mask &(1<<i))!=0){
                    subset.add(nums[i]);
                }
            }
            subsets.add(subset);
        }
          return subsets;
    }

    public static void main(String[] args) {
       int nums[] = {2,4,5};
        List<List<Integer>> subsets = subsets(nums);
        System.out.println(subsets);
    }
}

//TC=>0(n*2^n)
