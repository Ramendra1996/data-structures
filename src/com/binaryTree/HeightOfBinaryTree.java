package com.binaryTree;

public class HeightOfBinaryTree {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data= data;
            left = null;
            right=null;
        }
    }
    public  static  int getHeight(Node root){
        if (root==null){
            return 0;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        return Math.max(leftHeight,rightHeight)+1;
    }

    public static void main(String[] args) {
         Node root = new Node(2);
         root.left = new Node(3);
         root.left.left= new Node(4);
         root.left.right= new Node(5);
         root.right= new Node(6);
         root.right.left = new Node(7);
         root.right.right= new Node(8);
        int height = getHeight(root);
        System.out.println("height=>"+height);

    }
}
