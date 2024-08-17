package com.queue;


/// question  ko sahi krna h

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseFirstKelement {
    static void reverseK(Queue<Integer> q, int k){
        //stepA-> k element -> stack
        Stack<Integer>st = new Stack<>();
        int count =0;
        if(k <= 0 || k > q.size())
            return ;
        while (!q.isEmpty() && q.size()-k!=0){
             int temp =q.peek();
             q.poll();
             st.push(temp);
             count++;
             if(count==k){
                 break;
             }
        }
        //stepB-> stack -<q me bapass
        while (!st.isEmpty()){
            int temp =st.peek();
            st.pop();
            q.add(temp);
        }
        //step3-> push n-k  element from q front to back
        count=0;
        while (!q.isEmpty()){
            int temp = q.peek();
            q.poll();
            q.add(temp);
            count++;
            if(count==q.size()-k){
                break;
            }
        }


    }
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(3);
        q.add(6);
        q.add(9);
        q.add(2);
        q.add(8);
        reverseK(q,3);
        while (!q.isEmpty()){
            System.out.print(q.peek()+" ");
            q.poll();
        }
    }
}
