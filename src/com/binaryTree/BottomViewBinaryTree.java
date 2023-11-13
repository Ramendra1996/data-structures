package com.binaryTree;

import java.util.*;

public class BottomViewBinaryTree {
    static Node root;
    static Scanner  scanner = null;

    public  static class   Node {
        int data;
         Node left;
          Node right;
          Node( int data){
              this.data = data;
              left = null;
               right = null;
          }

    }

   private  static Node buildTree(){
    Node root = null;
       System.out.println("Enter data:");
       int data = scanner.nextInt();
       if (data==-1){
           return null;
       }
       root = new Node(data);
       System.out.println("Enter data for left part=>" + data);
       root.left = buildTree();
       System.out.println("Enter data for right part=>" + data);
       root.right = buildTree();
       return root;
   }

   private static  void bottomView(Node root){
        if(root ==null){
            return;
        }
        class QueueNode{
            Node node;
            int hd;
            private QueueNode(Node node, int hd){
                this.node=node;
                this.hd = hd;
            }
      }
       Queue<QueueNode>queue = new LinkedList<>();
       Map<Integer,Integer>bottomViewMap = new TreeMap<>();
       queue.add(new QueueNode(root,0));
       while (!queue.isEmpty()){
           QueueNode front = queue.poll();
           Node currentNode = front.node;
           int hd = front.hd;
           bottomViewMap.put(hd,currentNode.data);
           if(currentNode.left!=null){
               queue.add(new QueueNode(currentNode.left,hd-1));
           }
           if(currentNode.right!=null){
               queue.add(new QueueNode(currentNode.right,hd+1));
           }
       }
       for (Map.Entry<Integer,Integer>map:bottomViewMap.entrySet()){
           System.out.println(map.getKey()+" "+map.getValue());
       }
   }
    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        root=buildTree();
        System.out.println("Bottom View of Binary Tree:");
          bottomView(root);
    }
}

//10,20,30,-1,-1,40,60,-1,-1,-1,80,50,-1,70,-1,-1,90,-1,-1
