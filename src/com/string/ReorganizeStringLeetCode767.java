package com.string;

public class ReorganizeStringLeetCode767 {
    static String reorganizeString(String s) {

        int[] hash = new int[26];
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i) - 'a']++;
        }

        // Find the most frequent char
        char most_freq_char = ' ';
        int max_freq = Integer.MIN_VALUE;
        for (int i = 0; i < 26; i++) {
            if (hash[i] > max_freq) {
                max_freq = hash[i];
                most_freq_char = (char) (i + 'a');
            }
        }

        // Check if reorganization is possible
        if (max_freq > (s.length() + 1) / 2) {
            return "";
        }
       /* if(max_freq!=0){
            return "";
        }
*/
        // Reorganize the string
        char[] result = new char[s.length()];
        int index = 0;

        // Place the most frequent char at even indices
        while (hash[most_freq_char - 'a'] > 0) {
            result[index] = most_freq_char;
            index += 2;
            hash[most_freq_char - 'a']--;
        }

        // Place the rest of the chars
        for (int i = 0; i < 26; i++) {
            while (hash[i] > 0) {
                if (index >= s.length()) {
                    index = 1;
                }
                result[index] = (char) (i + 'a');
                index += 2;
                hash[i]--;
            }
        }
        return new String(result);
    }
    public static void main(String[] args) {
        String s = "aab";
        System.out.println(reorganizeString(s));
    }
}
