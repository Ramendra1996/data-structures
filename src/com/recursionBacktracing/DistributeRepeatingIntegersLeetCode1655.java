package com.recursionBacktracing;

import java.util.*;

import static java.util.Collections.reverse;

public class DistributeRepeatingIntegersLeetCode1655 {
    private static void reverseArray(int[] arr) {
        int i = 0, j = arr.length - 1;
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

   static boolean canDistributeHelper(List<Integer> counts, int[] quantity, int start){
        //base case
        if (start == quantity.length) return true; // All quantities have been distributed
        if (counts.isEmpty()) return false; // No more available integers to distribute
        for(int i =0;i<counts.size();i++){
            if(counts.get(i)>=quantity[start]){
                int originalCount = counts.get(i);
                counts.set(i, originalCount - quantity[start]);
                if (canDistributeHelper(counts, quantity, start + 1)) return true; // Recur for next quantity
                counts.set(i, originalCount); // Backtrack
            }
        }
     return false;
    }
    public static boolean canDistribute(int[] nums, int[] quantity) {
     Map<Integer,Integer> countMap = new HashMap<>();
       for(int num:nums){
           countMap.put(num,countMap.getOrDefault(num,0)+1);
       }
        List<Integer> counts = new ArrayList<>();
        for(int value:countMap.values()){
         counts.add(value);
        }
        // Sort the quantities and counts arrays in descending order
        Arrays.sort(quantity);
        reverseArray(quantity);

        counts.sort(Comparator.reverseOrder());
        return canDistributeHelper(counts,quantity,0);
    }
    public static void main(String[] args) {
       int [] nums = {1,2,3,4};
       int [] quantity = {2};

        boolean b = canDistribute(nums, quantity);
        System.out.println(b);
    }
}
