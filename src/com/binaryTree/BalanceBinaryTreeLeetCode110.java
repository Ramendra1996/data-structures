package com.binaryTree;

public class BalanceBinaryTreeLeetCode110 {
    static  class  Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data= data;
            left = null;
            right = null;
        }
    }
    static class Pair{
        int hd;
        boolean flag;
        Pair(int hd, boolean flag){
            this.hd = hd;
            this.flag= flag;
        }
    }

    public  static  int getHeight(Node root){
        if (root==null){
            return 0;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return  Math.max(leftHeight,rightHeight)+1;
    }
    public  static  boolean  isBalance(Node root){
        if (root==null){
            return true;
        }
        int leftHeight =  getHeight(root.left);
        int rightHeight = getHeight(root.right);
        int diff = Math.abs(leftHeight-rightHeight);
        boolean ans = false;
        if (diff<=1){
            ans = true;
        }
        boolean leftAns =isBalance(root.left);
        boolean rightAns = isBalance(root.right);
        return (ans && leftAns && rightAns);
    }

    public  static  Pair isBalanced(Node root){
        if (root==null){
            return new Pair(0,true);
        }
        Pair left = isBalanced(root.left);
        Pair right= isBalanced(root.right);
        int leftHeight = left.hd;
        int rightHeight = right.hd;
        boolean leftFlag = left.flag;
        boolean rightFlag = right.flag;
        boolean isCurrentBalanced = Math.abs(leftHeight - rightHeight) <= 1;
        boolean ans = (leftFlag) && (rightFlag) && isCurrentBalanced;
        int maxHeight = Math.max(rightHeight,leftHeight)+1;
        return  new Pair(maxHeight,ans);
    }


    public static void main(String[] args) {
      Node root = new Node(2);
      root.left = new Node(3);
      root.left.left = new Node(4);
      root.left.right= new Node(5);
      root.right= new Node(6);
      root.right.left = new Node(7);
      root.right.right = new Node(8);
        boolean balance = isBalance(root);
        System.out.println(balance);
        Pair balanced = isBalanced(root);
        System.out.println(balanced.flag);
    }
}
