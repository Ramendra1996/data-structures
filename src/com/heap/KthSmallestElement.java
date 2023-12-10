package com.heap;

import java.util.Collections;
import java.util.Objects;
import java.util.PriorityQueue;

public class KthSmallestElement {
    public static int getKthSmallestElement(int arr[], int n,int k){
    //create max heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<k;i++){
            pq.add(arr[i]);
        }
        //for remaining element ,push only if they are less than top
        for(int i=k;i<n;i++){
            int element = arr[i];
            if(element<pq.peek()){
               pq.poll();
               pq.add(element);
            }
        }
        int ans = pq.peek();
        return ans;

    }
    public static void main(String[] args) {
        int arr[]={10,5,20,4,15};
        int n =5;
        int k=2;
        int ans = getKthSmallestElement(arr,n,k);

        System.out.println("kth smallest=>"+ans);
    }
}
