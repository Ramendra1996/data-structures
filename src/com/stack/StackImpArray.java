package com.stack;

public class StackImpArray {
    int arr[];
     int top;
     int size;
     StackImpArray(int size){
         arr= new int[size];
         this.size=size;
         top=-1;
     }
     //function
      boolean isEmpty(){
         if(top==-1){
             return true;
         }else {
             return false;
         }
      }
      boolean isFull(){
         if(top>=size-1){
              return true;
         }else {
           return false;
         }
      }
      void  push(int data){
         if(!isFull()){
             top++;
             arr[top]=data;
         }else {
             System.out.println("stack overflow");
         }
      }
      void pop(){
         if(!isEmpty()){
             top--;
         }else {
             System.out.println("stack underflow");
         }
      }
       int stackSize(){
          return top+1;
       }
       int peek(){
         if(!isEmpty()){
             return arr[top];
         }else {
             System.out.println("stack underflow");
             return 0;
         }
       }

    public static void main(String[] args) {
         StackImpArray st = new StackImpArray(5);
         st.push(10);
         st.push(20);
         st.push(30);
         st.push(40);
         st.push(50);
        int size = st.stackSize();
        System.out.println("size=="+size);
       //  st.push(6);
         while (!st.isEmpty()){
             System.out.println(st.peek());
             st.pop();
         }
        int size1 = st.stackSize();
        System.out.println("size=="+size1);

    }

}
  /*    void push(int data){
        if(size-top>1){
            //space available
            //insert data
            top++;
            arr[top]=data;
        }else {
            //space not available
            System.out.println("stack over flow");
        }
     }
     void pop(){
        if(top==-1){
            //stack is empty
            System.out.println("stack underflow");
        }else {
            //stack not empty
            top--;
        }
     }
      int getTop(){
           if(top==-1){
               System.out.println("There is no element in stack:");
               return -1;
           }else {
               return arr[top];

           }
      }
      //return of valid element present in stack
      int getSize(){
         return top;
      }
      boolean isEmpty(){
         if(top==-1){
             return true;
         }else {
             return false;
         }
      }*/
