package com.stack;

import java.util.Stack;

public class SortStack {

    static void insertSort(Stack<Integer>st , int target){
        if(st.isEmpty()){
            st.push(target);
            return;
        }
        //basecase
        if(st.peek()>=target){
            st.push(target);
            return;
        }
        int topElement = st.peek();
        st.pop();
        insertSort(st, target);
        //back track
        st.push(topElement);
    }
    static void sortStack(Stack<Integer>st){
        if(st.isEmpty()){
            return;
        }
        int topElement= st.peek();
        st.pop();
        sortStack(st);
        insertSort(st,topElement);
    }
    public static void main(String[] args) {
        Stack<Integer>st = new Stack<>();
        st.push(6);
        st.push(3);
        st.push(1);
        st.push(8);
        st.push(10);
        st.push(9);
        sortStack(st);
        while (!st.isEmpty()){
            System.out.print(st.peek()+" ");
            st.pop();
        }


    }
}
