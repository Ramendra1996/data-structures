package com.stack;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInStringLeetCode1047 {
    public static String removeDuplicates(String s) {

        Stack<Character> st = new Stack<>();
         for(int i =0;i<s.length();i++){

             if (!st.isEmpty() && st.peek() == s.charAt(i)) {
                 st.pop();
             } else {
                 st.push(s.charAt(i));
             }
         }
        StringBuilder ans = new StringBuilder();
        while (!st.isEmpty()) {
            ans.append(st.pop());
        }
        return ans.reverse().toString();
    }

    public static void main(String[] args) {
        String s = "abbaca";
        String s1 = removeDuplicates(s);
        System.out.println(s1);

    }
}
