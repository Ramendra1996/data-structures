package com.string;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumberLeetCode179 {
    static String largestNumber(int[] nums) {
        // Convert integers to strings for custom sorting
        String[] numStrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numStrs[i] = String.valueOf(nums[i]);
        }

        // Custom comparator to sort strings in descending order

        Arrays.sort(numStrs, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String order1 = s1 + s2;
                String order2 = s2 + s1;
                // Compare in reverse order to get the largest number
                return order2.compareTo(order1);
            }
        });

        // Handle the case where the array contains only zeros
        if (numStrs[0].equals("0")) {
            return "0";
        }

        // Concatenate the sorted strings to form the largest number
        StringBuilder result = new StringBuilder();
        for (String numStr : numStrs) {
            result.append(numStr);
        }

        return result.toString();
    }
    public static void main(String[] args) {
      int  nums[] = {10,2};
        String s = largestNumber(nums);
        System.out.println(s);

    }
}
