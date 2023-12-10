package com.greedy;

import java.util.PriorityQueue;

public class MInCostOfRopes {



    public static void main(String[] args) {
        int arr[]={4,3,2,6};
        int n =4;

        PriorityQueue<Integer>pq = new PriorityQueue<>();
        for(int i=0;i<n;i++){
            pq.add(arr[i]);
        }
        int cost =0;
        while (pq.size()!=1){
            int first = pq.poll();
            int second =pq.poll();
            cost+=first+second;
            int newLength = first+second;
            pq.add(newLength);
        }
        System.out.println("cost=>"+cost);

    }
}
