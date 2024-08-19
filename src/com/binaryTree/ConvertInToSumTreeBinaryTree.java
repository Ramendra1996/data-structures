package com.binaryTree;

public class ConvertInToSumTreeBinaryTree {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data= data;
            left= null;
            right = null;
        }
    }
    public  static  int getCountSum(Node root){
        if (root==null){
            return 0;
        }
        int leftSum = getCountSum(root.left);
        int rightSum = getCountSum(root.right);
        return  (root.data+leftSum+rightSum);
    }
    public static void main(String[] args) {
        Node root = new Node(2);
        root.left= new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(6);
        root.right.left = new Node(7);
        root.right.right= new Node(8);
        int countSum = getCountSum(root);
        System.out.println("countSum=="+countSum);


    }
}
