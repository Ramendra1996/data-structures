package com.binarySearchTree;

public class LcaInBSTLeetCode235 {
    static Node root;

    class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data= data;
            left=null;
            right=null;
        }
    }
    public Node lowestCommonAncestor(Node root, Node p, Node q) {
        //base case
        if(root==null){
            return null;
        }
        if(p.data<root.data && q.data<root.data){
            return lowestCommonAncestor( root.left, p, q);
        }
        if(p.data>root.data && q.data>root.data){
            return lowestCommonAncestor(root.right,p,q);
        }
        return root;

    }

    public static void main(String[] args) {

    }
}
//Tc->(logn )