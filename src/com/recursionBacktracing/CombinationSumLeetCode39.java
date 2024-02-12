package com.recursionBacktracing;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumLeetCode39 {
 static void    combinationSumHelper( int[]candidates,int target,List<Integer> v,List<List<Integer>>ans,int start){

    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>>ans = new ArrayList<>();
        List<Integer> v = new ArrayList<>();
        combinationSumHelper(candidates,target,v,ans,0);

        return ans;
    }
    public static void main(String[] args) {
     int []candidates = {2,3,6,7};
        int target = 7;
    }
}
