package com.binaryTree;

public class KthAncestorBinaryTree {
    static  int k =2;
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            left= null;
            right= null;
        }
    }

    public  static  boolean kthAncestor(Node root,Node p){
        if (root==null){
            return false;
        }
        if (root==p){
            return true;
        }
        boolean leftAns = kthAncestor(root.left,p);
        boolean rightAns = kthAncestor(root.right,p);

        if (leftAns ||rightAns){
            k--;
            if (k==0){
                System.out.println(root.data);
                return true;
            }
            return true;
        }

        return false;
    }
    public static void main(String[] args) {
         Node root = new Node(2);
         root.left = new Node(3);
         root.left.left = new Node(4);
         root.left.right = new Node(5);
         root.right= new Node(6);
         root.right.left = new Node(7);
         root.right.right= new Node(8);
        boolean b = kthAncestor(root,root.right.right);
        System.out.println(b);
    }
}
