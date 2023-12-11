package com.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseQueue {
    static void reverseQueue(Queue<Integer> q){
        Stack<Integer>st = new Stack<>();
         //step1 -> all q element insert stack
        while (!q.isEmpty()){
            int element = q.peek();
            q.poll();
            st.push(element);
        }
        //step2-> put all element from stack into queue
        while (!st.isEmpty()){
            int element = st.peek();
            st.pop();
            q.add(element);
        }
    }
    static void  reverseQueueRecursion( Queue<Integer> q){
        if(q.isEmpty()){
            return;
        }
        int element = q.peek();
        q.poll();
        reverseQueueRecursion(q);
        q.add(element);
    }
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(3);
        q.add(6);
        q.add(9);
        q.add(2);
        q.add(8);
        reverseQueue(q);
        while (!q.isEmpty()){
            System.out.print(q.peek()+" ");
            q.poll();
        }
        System.out.println(" ");
        reverseQueueRecursion(q);
        while (!q.isEmpty()){
            System.out.print(q.peek()+" ");
            q.poll();
        }
    }
}
