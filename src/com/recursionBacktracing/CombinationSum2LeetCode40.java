package com.recursionBacktracing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2LeetCode40 {
    static void combinationSumHelper(int[] candidates, int target, List<Integer> v, List<List<Integer>> ans, int index) {

        //base case
        if (target == 0) {
            ans.add(new ArrayList<>(v));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {

            if(i>index && candidates[i]==candidates[i-1]){
                continue;
            }
            v.add(candidates[i]);
            combinationSumHelper(candidates, target - candidates[i], v, ans, i+1);
            v.remove(v.size() - 1);
        }

    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> v = new ArrayList<>();
        combinationSumHelper(candidates, target, v, ans, 0);
        return ans;
    }

    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;

        Arrays.sort(candidates);
        List<List<Integer>> lists = combinationSum(candidates, target);
        System.out.println(lists);


    }
}
