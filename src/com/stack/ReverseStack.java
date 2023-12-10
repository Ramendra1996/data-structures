package com.stack;

import java.util.Stack;

public class ReverseStack {
    static void insetAtBottom(Stack<Integer>st,int target){
        //basecase
        if(st.isEmpty()){
           st.push(target);
           return;
        }
        int topElement = st.peek();
        st.pop();
        //rec call
        insetAtBottom(st,target);
        st.push(topElement);
    }
    static void getReverse(Stack<Integer>st){

        //baseacse
        if(st.isEmpty()){
            return;
        }
        int target =st.peek();
        st.pop();
        //reverse stack
        getReverse(st);
        //insert at bottom
        insetAtBottom(st,target);

    }
    public static void main(String[] args) {
        Stack<Integer>st = new Stack<>();
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);
        st.push(50);
          getReverse(st);
          while (!st.isEmpty()){
              System.out.print(st.peek()+" ");
              st.pop();
          }
    }
}
