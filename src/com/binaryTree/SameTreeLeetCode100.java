package com.binaryTree;

public class SameTreeLeetCode100 {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data= data;
            left = null;
            right= null;
        }
    }
    public  static  boolean isSameTree(Node p ,Node q){
        if (p==null && q==null){
            return true;
        }
        if (p==null || q==null){
            return false;
        }
      return true;
    }
    public static void main(String[] args) {

        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);

        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);

    }
}
