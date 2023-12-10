package com.stack;

import java.util.Stack;

public class InsertAtBottom {
 /* static   void solve(Stack<Integer> st,int target){
        //basecase
        if(st.isEmpty()){
            st.push(target);
            return;
        }
        int topElement = st.peek();
        st.pop();
        //rec call
        solve(st,target);
        //back tractiking
        st.push(topElement);

    }*/
   static void  getInsertAtBottom(Stack<Integer> st,int target){
     if(st.isEmpty()){
        st.push(target);
        return;
     }
     int topElement = st.peek();
     st.pop();
     //rec call
     getInsertAtBottom(st,target);
     //backtrack
     st.push(topElement);

    }
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);
        st.push(50);
        if(st.isEmpty()){
            System.out.println("stack is empty");
            return;
        }
        int target =st.peek();
        st.pop();
        getInsertAtBottom(st,target);
        while (!st.isEmpty()){
            System.out.print(st.peek()+" ");
            st.pop();
        }
    }
}
