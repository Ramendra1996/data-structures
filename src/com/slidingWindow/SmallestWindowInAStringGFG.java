package com.slidingWindow;

import java.util.HashMap;
import java.util.Map;
import java.util.SimpleTimeZone;

public class SmallestWindowInAStringGFG {
    public static String smallestWindow(String s, String p) {
        int len1 = s.length();
        int len2 = p.length();
        int ansIndex = -1;
        int start = 0;
        int ansLen = Integer.MAX_VALUE;
        if (len1 < len2) {
            return "";
        }
        Map<Character, Integer> strMap = new HashMap<>();
        Map<Character, Integer> ptrMap = new HashMap<>();
        // to keep track of all char of p string
        for (int i = 0; i < len2; i++) {
            char ch = p.charAt(i);
            ptrMap.put(ch, ptrMap.getOrDefault(ch, 0) + 1);
        }
        int count = 0;
        for (int i = 0; i < len1; i++) {
            char ch = s.charAt(i);
            strMap.put(ch, strMap.getOrDefault(ch, 0) + 1);
            // valid char-> jo tumhare pattern me bhi ho
            // Check if the current character is present in ptrMap and its count in strMap is equal to or greater than in ptrMap
            if (ptrMap.containsKey(ch) && strMap.get(ch) <= ptrMap.get(ch)) {
                count++;
            }
            // If all characters in ptrMap are found in strMap
            if (count == len2) {
                // Try to minimize the window by moving the start index
                while (!ptrMap.containsKey(s.charAt(start)) || strMap.get(s.charAt(start)) > ptrMap.get(s.charAt(start))) {
                    if (strMap.containsKey(s.charAt(start))) {
                        strMap.put(s.charAt(start), strMap.get(s.charAt(start)) - 1);
                    }
                    start++;
                }

                // Update the minimum window size
                int windowSize = i - start + 1;
                if (windowSize < ansLen) {
                    ansLen = windowSize;
                    ansIndex = start;
                }
            }
        }

        // If no window found
        if (ansIndex == -1) {
            return "";
        }

        return s.substring(ansIndex, ansIndex + ansLen);
    }

    public static void main(String[] args) {
        String s = "zoomlazapzo";
        String p=  "oza";

        System.out.println(smallestWindow(s,p));
    }
}
