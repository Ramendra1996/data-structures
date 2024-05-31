package com.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagramsLeetCode49 {
    public static int[] hash(String str) {
        int[] hash = new int[256];
        for (int i = 0; i < str.length(); i++) {
            hash[str.charAt(i)]++;
        }
        return hash;
    }
    static List<List<String>> groupAnagrams1(String[] strs) {
        HashMap<String, List<String>> mp = new HashMap<>();
        for (String str : strs) {
            int[] charFrequency = hash(str);
            // Convert the character frequency array to a string to be used as a key
            String key = Arrays.toString(charFrequency);

            // Check if the key is already present in the map
            if (mp.containsKey(key)) {
                // If it is, add the original string to the corresponding list
                mp.get(key).add(str);
            } else {
                // If it's not, create a new list, add the original string, and put it in the map
                List<String> newList = new ArrayList<>();
                newList.add(str);
                mp.put(key, newList);
            }
        }
        // Convert the values of the map to a list of lists
        return new ArrayList<>(mp.values()); //the overall time complexity is O(N * K).
        //sc 0(nk) +map size
    }
    static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>>mp = new HashMap<>();
        for(String str:strs){
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);

            // Check if the sorted string is already a key in the map
            if (mp.containsKey(sortedStr)) {
                // If it is, add the original string to the corresponding list
                mp.get(sortedStr).add(str);
            } else {
                // If it's not, create a new list, add the original string, and put it in the map
                List<String> newList = new ArrayList<>();
                newList.add(str);
                mp.put(sortedStr, newList);
            }
        }
        // Convert the values of the map to a list of lists
        return new ArrayList<>(mp.values());
    }
    public static void main(String[] args) {
        String strs[]={"eat","tea","tan","ate","nat","bat"};
        List<List<String>> result = groupAnagrams(strs);
        // Print the result
        for (List<String> group : result) {
            System.out.println(group);
        }

        List<List<String>> lists = groupAnagrams1(strs);
        System.out.println(lists);
    }
}
//TC->0(nk log k)
//SC_>0(NK)
