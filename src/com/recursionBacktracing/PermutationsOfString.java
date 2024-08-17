package com.recursionBacktracing;

import java.util.HashSet;
import java.util.Set;

public class PermutationsOfString {

    public static String swap(String str, int i, int j) {
        char[] ch = str.toCharArray();
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
        return String.valueOf(ch);
    }

    public static void getPrintPermutations(String str, int i, Set<String>set) {
        if (i >= str.length() ) {
            set.add(str);
            return;
        }
            for (int j = i; j < str.length(); j++) {
                str = swap(str, i, j);
                getPrintPermutations(str, i + 1,set);
                str = swap(str, i, j); // Backtrack to the original string
            }

    }

    public static void main(String[] args) {
        String str = "abc";
        int i = 0;
        Set<String> set = new HashSet<>();
        getPrintPermutations(str, i,set);
        System.out.println(set);
    }

}

//TC->0(n! )
//SC->0(n)