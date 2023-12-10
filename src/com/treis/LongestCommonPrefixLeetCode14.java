package com.treis;

public class LongestCommonPrefixLeetCode14 {
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
            char ch = strs[0].charAt(i);
            boolean match = true;
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || ch != strs[j].charAt(i)) {
                    match = false;
                    break;
                }
            }
            if (!match) {
                break;
            } else {
                ans.append(ch);
            }
        }
        return ans.toString();
    }
  //TC->0(nm)
    public static void main(String[] args) {
        String[] inputStrings = {"flower", "flow", "flight"};
        String result = longestCommonPrefix(inputStrings);
        System.out.println("Longest Common Prefix: " + result);
    }
}
