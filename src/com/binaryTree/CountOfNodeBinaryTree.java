package com.binaryTree;

public class CountOfNodeBinaryTree {
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
    public  static  int getCountNode(Node root){
        if (root==null){
            return 0;
        }
        int leftCount = getCountNode(root.left);
        int rightCount = getCountNode(root.right);
        return leftCount+rightCount+1;
    }

    public static void main(String[] args) {
       Node root = new Node(2);
       root.left= new Node(3);
       root.left.left = new Node(4);
       root.left.right = new Node(5);
       root.right = new Node(6);
       root.right.left = new Node(7);
       root.right.right = new Node(8);
        int countNode = getCountNode(root);
        System.out.println("countNode=>"+countNode);

    }
}
