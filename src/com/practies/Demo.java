package com.practies;

import java.util.*;

public class Demo {
    static Node root;
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            left = null;
            right= null;
        }
    }
     public  static  void  leftView(Node root , List<Integer> list, int level){
        if (root==null){
            return;
        }
         if(level==list.size()){
             list.add(root.data);
         }
         leftView(root.left,list,level+1);
         leftView(root.right,list, level+1);

     }

     public  static  void rightView(Node root ,List<Integer>list , int level){

        if (root==null){
            return;
        }
        if (level==list.size()){
            list.add(root.data);
        }
        rightView(root.right,list,level+1);
        rightView(root.left,list,level+1);
     }

     public  static  void  topView(Node root){

        if (root==null){
            return;
        }
       class  QueueNode{
            Node node;
            int hd;
            QueueNode(Node node , int hd){
                this.node = node;
                this.hd = hd;
            }
         }
          Queue<QueueNode> queue = new LinkedList<>();
          Map<Integer,Integer> map = new HashMap<>();
           queue.add(new QueueNode(root,0));
           while (!queue.isEmpty()){
               QueueNode front = queue.poll();
               Node currNode = front.node;
               int hd = front.hd;

               if(!map.containsKey(hd)){
                   map.put(hd, currNode.data);
               }

               if (currNode.left!=null){
                    queue.add(new QueueNode(currNode.left,hd-1));
               }
               if (currNode.right!=null){
                   queue.add(new QueueNode(currNode.right,hd+1));
               }
           }
           for (int val:map.values()){
               System.out.print(val+" ");
           }
     }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.left.left = new Node(40);
        root.left.right= new Node(50);
        root.right = new Node(30);
        root.right.left = new Node(60);
        root.right.right = new Node(70);
      //  List<Integer>list = new ArrayList<>();
       /* leftView(root,list,0);
        System.out.println(list);*/
      /*  rightView(root,list,0);
        System.out.println(list);*/
        topView(root);

    }
}
