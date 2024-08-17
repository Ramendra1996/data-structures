package com.stack;

import java.util.Stack;

public class MiddleElementInStack {
     static  void printMiddleElemet(Stack<Integer> st ,int size){

         if (st.size()==0){
             System.out.println("There is no element in stack");
         }
        //basecase
         if(st.size()==size/2+1){
             System.out.println(st.peek());
             return;
         }
          st.pop();
         //rc call
         printMiddleElemet(st, size);

     }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);
        st.push(50);
        st.push(60);
        st.push(70);

        printMiddleElemet(st,st.size());



    }
}
