package com.queue;

public class CircularQueueImpArray {
       int arr[];
       int size;
       int front ;
        int rear;
        CircularQueueImpArray(int size){
            this.size=size;
            arr= new int[size];
            front=-1;
            rear=-1;
        }
        void push(int data){
            //queue full

            //single element case-> first element
            //circular nature
            //normal flow
            // TODo: add one more condition in the queue  full is block
            // rear =(front-1)%(size-1); condtion
            if((front==0 && rear==size-1)){
                System.out.println("queue is full can't insert");
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
        void pop(){
            //empty check
            //single element
            //circular nature
            //normal flow
            if(front==-1){
                System.out.println("queue is empty");
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
    public static void main(String[] args) {

    }
}
