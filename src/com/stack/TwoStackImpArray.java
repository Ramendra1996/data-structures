package com.stack;

public class TwoStackImpArray {

    int arr[];
     int size;
      int top1;
      int top2;
      TwoStackImpArray(int size){
         arr= new int[size];
         top1=-1;
         top2=size;
      }
      void push1(int data){
           if(top2-top1>1){
                top1++;
                arr[top1]=data;
           }else {
               System.out.println("stack overflow");
           }
      }
      void pop1(){
         if(top1==-1){
             System.out.println("stack under flow");
         }else {
             top1--;
         }
      }
      void  push2(int data){
            if(top2-top1>1){
                top2--;
                arr[top2]=data;
            }else{
                System.out.println("stack overflow");
            }
      }
      void pop2(){
           if(top2==size){
               System.out.println("stack under flow");
           }else{
               top2++;
           }
      }
    public static void main(String[] args) {
        TwoStackImpArray st = new TwoStackImpArray(5);
        st.push1(10);
        st.push1(20);
        st.push2(30);
        st.push2(40);
        st.push1(50);
        st.push1(60);
    }
}
