package com.queue;

public class DoublyEndedQueue {

    int arr[];
    int size;
    int front;
    int rear;

    DoublyEndedQueue(int size) {
        this.size = size;
        arr = new int[size];
        front = -1;
        rear = -1;
    }
    void pushRear(int data){
        if(front==0 && rear==size-1||(rear==(front-1)%(size-1))){
            System.out.println("queue is full can't insert");
            return;
        }else if (front==-1){
            front=rear=0;
            arr[rear]=data;
        } else if (rear==size-1 && front!=0) {
            rear=0;
            arr[rear]=data;
        }else {
            rear++;
            arr[rear]=data;
        }
    }
     void pushFront(int data){
         if(front==0 && rear==size-1){
             System.out.println("queue is full can't insert");
             return;
         }else if (front==-1){
             front=rear=0;
             arr[front]=data;
         } else if (front==0 && rear!=size-1) {
             front=size-1;
             arr[front]=data;
         }else {
             front--;
             arr[front]=data;
         }
     }
     void popFront(){
         if(front==-1){
             System.out.println("queue is empty");
             return;
         } else if (front==rear) {
             arr[front]=-1;
             front=-1;
             rear=-1;
         } else if (front==size-1) {
             front=0;
         }else {
             front++;
         }
     }

     void popRear(){
         if(front==-1){
             System.out.println("queue is empty");
         } else if (front==rear) {
             arr[front]=-1;
             front=-1;
             rear=-1;
         } else if (rear==0) {
             arr[rear]=-1;
             rear=size-1;
         }else {
             arr[rear]=-1;
             rear--;
         }
     }

    public static void main(String[] args) {

    }
}
