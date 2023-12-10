package com.stack;

import java.util.Stack;

public class LongestValidParenthesesLeetCode32 {
    public static int longestValidParentheses(String str) {
        Stack<Integer>st = new Stack<>();
           st.push(-1);
           int maxi =0;
         for (int i =0;i<str.length();i++){
             char ch = str.charAt(i);

             if(ch=='('){
                 st.push(i);
             }else {
                 st.pop();
                 if(st.isEmpty()){
                     st.push(i);
                 }else {
                    int length=i-st.peek();
                     maxi=Math.max(maxi,length);
                 }
             }
         }

        return maxi;
    }
    public static void main(String[] args) {
        String str = ")()())";
        int length = longestValidParentheses(str);
        System.out.println(length);
    }
}
