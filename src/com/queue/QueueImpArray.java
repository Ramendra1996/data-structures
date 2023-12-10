package com.queue;

public class QueueImpArray {
    int arr[];
     int size;
     int front;
     int rear;
     QueueImpArray(int size){
         this.size=size;
         arr= new int[size];
         front=0;
          rear=0;
     }

     void push(int data){
         if(rear==size){
             System.out.println("queue is full");
         }else {
             arr[rear]=data;
             rear++;
         }
     }

     void pop(){
         if(front==rear){
             System.out.println("queue is empty");
         }else {
             arr[front]=-1;
             front++;
             if(front==rear){
                front=0;
                rear=0;
             }
         }
     }
     int getFront(){
         if(front==rear){
             System.out.println("queue is empty");
             return -1;
         }else{
             return arr[front];
         }
     }
     boolean isEmpty(){
         if(front==rear){
             return true;
         }else{
             return false;
         }
     }
     int getSize(){
         return rear-front;
     }
    public static void main(String[] args) {
        QueueImpArray q = new QueueImpArray(10);
        q.push(10);
        q.push(9);
        q.push(8);
        q.push(7);
        q.push(6);
        q.push(5);
        q.push(4);
        q.push(3);
        q.push(2);
        q.push(1);
        System.out.println("size="+q.getSize());
    }
}
