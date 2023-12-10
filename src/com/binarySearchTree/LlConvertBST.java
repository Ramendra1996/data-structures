package com.binarySearchTree;

public class LlConvertBST {

    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data= data;
            left=null;
            right=null;
        }
    }

    public static Node sortedLlConvertBST(Node head, int n){
        //base case
        if(n<=0||head==null){
            return null;
        }
        Node leftSubTree=sortedLlConvertBST(head,n-1-n/2);
        Node root = head;
        root.left=leftSubTree;
        head=head.right;
        root.right=sortedLlConvertBST(head,n/2);
        return root;
    }

    public static void main(String[] args) {

    }
}
