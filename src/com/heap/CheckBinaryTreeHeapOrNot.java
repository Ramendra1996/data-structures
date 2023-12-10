package com.heap;

public class CheckBinaryTreeHeapOrNot {

    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            left=null;
            right=null;
        }
    }
    static class Pair{
        boolean b;
        int n;
        Pair(boolean b,int n){
            this.b=b;
            this.n=n;
        }
    }

    static  Pair solve(Node root){
        if(root==null){
            Pair p = new Pair(true,Integer.MIN_VALUE);
            return p;
        }
        if(root.left==null && root.right==null){
            Pair p = new Pair(true,root.data);
            return p;
        }
        Pair leftAns = solve(root.left);
        Pair  rightAns=solve(root.right);
        if(leftAns.b==true && rightAns.b==true &&root.data>leftAns.n && root.data> rightAns.n){
            return  new Pair(true,root.data);
        }else{
            return new Pair(false, root.data);
        }
    }
    public static void main(String[] args) {

    }
}
