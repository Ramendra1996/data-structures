package com.heap;

import java.util.PriorityQueue;

public class KthGreatestElement {
    public static int getKthGreatest(int arr[], int n,int k){
        PriorityQueue<Integer>pq = new PriorityQueue<>();
        for(int i=0;i<k;i++){
            pq.add(arr[i]);
        }
        for(int i=k ;i<n;i++){
            int element =arr[i];
            if(element>pq.peek()){
                pq.poll();
                pq.add(element);
            }
        }
          int ans= pq.peek();
        return ans;
    }
    public static void main(String[] args) {
        int arr[]={10,5,20,4,15};
        int n =5;
        int k=2;
        int kthGreatest = getKthGreatest(arr, n, k);
        System.out.println(kthGreatest);
    }
}
