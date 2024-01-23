package com.string;

public class IsomorphicStringsLeetCode205 {
    static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int hash[] = new int[256];//mapping of each char of language 's' to language 't'
        boolean isTcharMapped[] = new boolean[256];//store if t[i] char already mapped s[i]

        for (int i = 0; i < s.length(); i++) {
            if (hash[s.charAt(i)] == 0 && isTcharMapped[t.charAt(i)] == false) {
                hash[s.charAt(i)] = t.charAt(i);
                isTcharMapped[t.charAt(i)] = true;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (hash[s.charAt(i)] != t.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "egg";
        String t = "add";
        boolean isomorphic = isIsomorphic(s, t);
        System.out.println(isomorphic);
    }
}
