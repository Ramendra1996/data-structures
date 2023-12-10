package com.heap;
import java.util.Comparator;
import java.util.PriorityQueue;



class Node {
    char data;
    int count;

    Node(char data, int count) {
        this.data = data;
        this.count = count;
    }
}

class Compare implements Comparator<Node> {
    @Override
    public int compare(Node a, Node b) {
        return Integer.compare(b.count, a.count); // Fix the comparison to sort by count in descending order
    }
}

class Solution {
    public static String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Node> maxHeap = new PriorityQueue<>(new Compare());

        if(a>0){
            Node temp= new Node('a',a);
            maxHeap.add(temp);
        }
        if(b>0){
            Node temp = new Node('b',b);
            maxHeap.add(temp);
        }
        if(c>0){
            Node temp = new Node('c',c);
            maxHeap.add(temp);
        }

        StringBuilder ans = new StringBuilder();
        while(maxHeap.size()>1){
            Node first = maxHeap.poll();
            Node second = maxHeap.poll();

            if(first.count>=2){
                ans.append(first.data);
                ans.append(first.data);
                first.count-=2;
            }else{
                ans.append(first.data);
                first.count--;
            }
            if(second.count>=2 && second.count>=first.count){
                ans.append(second.data);
                ans.append(second.data);
                second.count-=2;
            }else{
                ans.append(second.data);
                second.count--;
            }

            if(first.count>0){
                maxHeap.add(first);
            }
            if(second.count>0){
                maxHeap.add(second);
            }
            if(!maxHeap.isEmpty()){
                Node temp = maxHeap.poll();
                if(temp.count>=2){
                    ans.append(temp.data);
                    ans.append(temp.data);
                    temp.count-=2;
                }else{
                    ans.append(temp.data);
                    temp.count--;
                }
            }
        }
        return ans.toString();

    }


    public static void main(String[] args) {
        int a = 0;
        int b = 0;
        int c = 2;
        String s = longestDiverseString(a, b, c);
        System.out.println("string=" + s);
    }
}
