package com.recursionBacktracing;

public class PermutationsOfString {

    public static String swap(String str, int i, int j) {
        char[] ch = str.toCharArray();
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
        return String.valueOf(ch);
    }

    public static void getPrintPermutations(String str, int i) {
        if (i >= str.length() ) {
            System.out.println(str);
        }
            for (int j = i; j < str.length(); j++) {
                str = swap(str, i, j);
                getPrintPermutations(str, i + 1);
                str = swap(str, i, j); // Backtrack to the original string
            }

    }

    public static void main(String[] args) {
        String str = "abc";
        int i = 0;
        getPrintPermutations(str, i);
    }

}

//TC->0(n! )
//SC->0(n)