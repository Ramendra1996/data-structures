package com.stack;

import java.util.Stack;

public class VaildParenthesisLeetCode20 {
    static boolean isValid(String str){
        Stack<Character> st = new Stack<>();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            //opening bracket
            if(ch=='('||ch=='[' ||ch=='{'){
               st.push(ch);
            } else {
                //closing bracket
                if(!st.isEmpty()){
                   char topCh = st.peek();
                   if(ch==')' && topCh=='('){
                       //matching bracket
                       st.pop();
                   }
                   else if (ch=='}' && topCh=='{'){
                       st.pop();
                   }
                 else  if(ch==']' && topCh=='['){
                       st.pop();
                   }else {
                     //racket not matching
                       return false;
                   }
                }else{
                    return false;
                }
            }

        }
        if(st.isEmpty()){
            return true;
        }else {
            return false;
        }
    }
    public static void main(String[] args) {
        String str ="({[]})";
        if(isValid(str)){
            System.out.println("true");
        }else {
            System.out.println("false");
        }
    }
}
