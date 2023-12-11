package com.queue;

import java.util.LinkedList;
import java.util.Queue;

public class InterLeaveFirstAndSecondHalf {

    static void  interLeave(Queue<Integer> q){
        //step A:
        int n= q.size();
        int k=n/2;
        int count =0;
        if(q.isEmpty()){
            return;
        }
        Queue<Integer> q2 = new LinkedList<>();
       while (!q.isEmpty()){
           int temp = q.peek();
           q.poll();
           q2.add(temp);
           count++;
           if(count==k){
               break;
           }
       }
       //step2interLeaving start kro
        while (!q.isEmpty() && !q2.isEmpty()){
            int first =q2.peek();
            q2.poll();
            q.add(first);
            int second =q.peek();
            q.poll();
            q.add(second);
        }
        //odd bala case
        if((n &1)!=0){
            int element =q.peek();
            q.poll();
            q.add(element);
        }
    }
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);

        interLeave(q);
        while (!q.isEmpty()){
            System.out.print(q.peek()+" ");
            q.poll();
        }
    }

}
