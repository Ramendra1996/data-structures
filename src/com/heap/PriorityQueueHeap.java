package com.heap;

import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQueueHeap {
    public static void main(String[] args) {
        //min heap print krne ke liye
        PriorityQueue pq = new PriorityQueue<>();
        //max heap print krne kr liye
        PriorityQueue priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        priorityQueue.add(3);
        priorityQueue.add(6);
        priorityQueue.add(9);
        priorityQueue.add(4);
        priorityQueue.add(8);

        System.out.println(priorityQueue.peek());
        priorityQueue.poll();
        System.out.println(priorityQueue.peek());
    }
}
