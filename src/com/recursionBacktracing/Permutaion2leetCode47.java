package com.recursionBacktracing;

import java.util.*;

public class Permutaion2leetCode47 {

    static void swap(int nums[], int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    static void permuteUniqueHelper(int[] nums, List<List<Integer>> ans, int start) {
        // Base case
        if (start == nums.length) {
            // Create a new list to store the permutation
            List<Integer> permutation = new ArrayList<>();
            for (int num : nums) {
                permutation.add(num);
            }
            ans.add(permutation);
            return;
        }
        // Use a set to avoid duplicate swaps
        Set<Integer> swapped = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if (swapped.add(nums[i])) {
                swap(nums, i, start);
                permuteUniqueHelper(nums, ans, start + 1);
                swap(nums, i, start);
            }
        }
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        permuteUniqueHelper(nums, ans, 0);
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        List<List<Integer>> result = permuteUnique(nums);
        System.out.println(result);
    }

}
//    static void swap(int nums[], int i, int j) {
//        int temp = nums[i];
//        nums[i] = nums[j];
//        nums[j] = temp;
//    }
//
//    static void permuteUniqueHelper(int[] nums, List<List<Integer>> ans, int start, Map<Integer, Boolean> swapped) {
//        // Base case
//        if (start == nums.length) {
//            // Create a new list to store the permutation
//            List<Integer> permutation = new ArrayList<>();
//            for (int num : nums) {
//                permutation.add(num);
//            }
//            ans.add(permutation);
//            return;
//        }
//        for (int i = start; i < nums.length; i++) {
//            if (!swapped.getOrDefault(nums[i], false)) {
//                swap(nums, i, start);
//                swapped.put(nums[start], true);
//                permuteUniqueHelper(nums, ans, start + 1, swapped);
//                swap(nums, i, start);
//                swapped.put(nums[start], false);
//            }
//        }
//    }
//
//    public static List<List<Integer>> permuteUnique(int[] nums) {
//        List<List<Integer>> ans = new ArrayList<>();
//        Map<Integer, Boolean> swapped = new HashMap<>();
//        permuteUniqueHelper(nums, ans, 0, swapped);
//        return ans;
//    }
//
//    public static void main(String[] args) {
//        int[] nums = {1, 1, 2};
//        List<List<Integer>> result = permuteUnique(nums);
//        System.out.println(result);
//    }
//}