package com.queue;

import java.util.LinkedList;
import java.util.Queue;

public class ImpStackUsingQueueLeetCode225 {
    ImpStackUsingQueueLeetCode225(){

    }

    Queue<Integer> q = new LinkedList<>();
    public void push(int x) {
        q.add(x); // Use add() instead of push() for Queue
        int size = q.size();
        for (int i = 0; i < size - 1; i++) {
            int front = q.remove(); // Use remove() instead of pop() for Queue
            q.add(front);
        }
    }

    public int pop() {
        return q.remove();
    }

    public int top() {
        return q.peek();
    }

    public boolean empty() {
        return q.isEmpty();
    }
    public static void main(String[] args) {
        ImpStackUsingQueueLeetCode225 stack = new ImpStackUsingQueueLeetCode225();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.top());   // returns 2
        System.out.println(stack.pop());   // returns 2
        System.out.println(stack.empty()); // returns false
    }
}
