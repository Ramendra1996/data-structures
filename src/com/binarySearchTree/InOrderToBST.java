package com.binarySearchTree;

public class InOrderToBST {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
    public Node bulidInOrderToBST(int inorder[],int start,int end){
        //base case
        if(start>end){
            return null;
        }
        int mid=(start+end)/2;
        int element = inorder[mid];
        Node root = new Node(element);
        root.left=bulidInOrderToBST(inorder,start,mid-1);
        root.right=bulidInOrderToBST(inorder,mid+1,end);
        return root;
    }
    public static void main(String[] args) {
      int inorder[]={1,2,3,4,5,6,7,8,9};
      int start=0;
      int end = 8;
    }
}
