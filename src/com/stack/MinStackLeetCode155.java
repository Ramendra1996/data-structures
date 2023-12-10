package com.stack;

import java.io.Flushable;
import java.util.ArrayList;
import java.util.List;

public class MinStackLeetCode155 {
    static class Pair{
        private int first;
        private int second;
        Pair(int first, int second){
            this.first=first;
            this.second = second;
        }
    }
    List<Pair>list = new ArrayList<>();

   /* public MinStack() {

    }*/

    public void push(int val) {
        if(list.isEmpty()){
            list.add(new Pair(val,val));
        }else{
          Pair p = list.get(list.size()-1);
          list.add(new Pair(val,Math.min(val,p.second)));
        }
    }

    public void pop() {
        if (!list.isEmpty()) {
            list.remove(list.size() - 1);
        }
    }

    public int top() {
        Pair pair = list.get(list.size() - 1);
        return pair.first;
    }

    public int getMin() {
        Pair pair=list.get(list.size() - 1);
        return pair.second;
    }
    public static void main(String[] args) {
        MinStackLeetCode155 minStack = new MinStackLeetCode155();
        minStack.push(3);
        minStack.push(5);
        minStack.push(7);
        minStack.push(1);
        minStack.push(9);
        System.out.println("Top: " + minStack.top());
        System.out.println("Min: " + minStack.getMin());
        minStack.pop();
        System.out.println("Top: " + minStack.top());
        System.out.println("Min: " + minStack.getMin());
    }
}
