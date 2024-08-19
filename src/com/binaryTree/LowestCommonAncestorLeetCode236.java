package com.binaryTree;

public class LowestCommonAncestorLeetCode236 {
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
    public  static  Node getLowestAncestor(Node root, Node p, Node q){
       if (root==null){
           return null;
       }
       if (root.data==p.data){
           return p;
       }
       if (root.data==q.data){
           return q;
       }
        Node leftAns = getLowestAncestor(root.left,p,q);
        Node rightAns = getLowestAncestor(root.right,p,q);
        if (leftAns==null && rightAns==null){
            return null;
        }
        if (leftAns==null && rightAns!=null){
            return rightAns;
        }
        if (leftAns!=null && rightAns==null){
            return leftAns;
        }
        return root;
    }
    public static void main(String[] args) {
      Node root = new Node(2);
      root.left = new Node(3);
      root.left.left = new Node(4);
      root.left.right= new Node(5);
      root.right = new Node(6);
      root.right.left = new Node(7);
      root.right.right = new Node(8);

        Node lowestAncestor = getLowestAncestor(root, root.left.left, root.right.right);
        System.out.println(lowestAncestor.data);

    }
}
