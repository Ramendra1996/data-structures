package com.queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class FirstNegtiveInteger {
    static void solve(int arr[], int size, int k){
        Queue<Integer>q = new ArrayDeque<>();
        //process first window of size k
        for(int i=0;i<k;i++){
            if(arr[i]<0){
                q.add(i);
            }
        }
        //remaing window ko process krna
        for(int i=k;i<size;i++) {
            //ans find out krna
            if (q.isEmpty()) {
                System.out.println(0);
            } else {
                System.out.print(arr[q.peek()] + " ");
            }
            //out of window element ko remove kr do
            while ((!q.isEmpty()) && (i - q.peek() >= k)) {
                q.poll();
            }
            //check current element for insertion
            if (arr[i] < 0) {
                q.add(i);
            }
        }
            //ans print last window
            if(q.isEmpty()){
                System.out.println(0);
            }else {
                System.out.print(arr[q.peek()]+" ");
            }

    }

    public static void main(String[] args) {
        int arr[]= {12,-1,-7,8,-15,30,16,28};
        int size =8;
        int k=3;

        solve(arr,size,k);
    }

}
