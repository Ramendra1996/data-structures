package com.stack;

import java.util.Stack;

public class MinimumBracketReversal {

    public static  int countRev(String s){
        //if odd size string then impossible to make pair
        if(s.length()%2!=0){
            return -1;
        }
        int ans =0;
        Stack<Character>st = new Stack<>();
        for (int i=0;i<s.length();i++){
            if(s.charAt(i)=='{'){
                st.push(s.charAt(i));
            }
            else if (!st.empty() && st.peek()=='{'){
                 st.pop();
            }else {
              st.push(s.charAt(i));
            }
        }
        //if stack is not empty  let's count reversal
        while (!st.empty()){
         char a = st.pop();
         char b = st.pop();
         if(a==b){
             ans+=1;
         }else {
             ans+=2;
         }
        }
       return  ans;
    }
    public static void main(String[] args) {
        String s = "}{{}}{{{";
        int i = countRev(s);
        System.out.println(i);
    }
}
