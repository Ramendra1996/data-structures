package com.queue;

import java.util.Stack;

public class ImplementQueueUsingStackLeetCode232 {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    ImplementQueueUsingStackLeetCode232(){

    }
    public void push(int x) {
        s1.push(x);
    }

    public int pop() {
        int pop=-1;
        if(!s2.isEmpty()){
            pop=s2.peek();
        }else{
            while(!s1.isEmpty()){
                s2.push(s1.peek());
                s1.pop();
            }
            pop= s2.peek();
        }
        s2.pop();
        return pop;

    }

    public int peek() {
        int front =-1;
        if(!s2.isEmpty()){
            front = s2.peek();
        }else{
            while(!s1.isEmpty()){
                s2.push(s1.peek());
                s1.pop();
            }
            front = s2.peek();
        }
        return front;

    }

    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
    public static void main(String[] args) {
        ImplementQueueUsingStackLeetCode232 queue = new ImplementQueueUsingStackLeetCode232();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek());  // returns 1
        System.out.println(queue.pop());   // returns 1
        System.out.println(queue.empty());
    }
}
