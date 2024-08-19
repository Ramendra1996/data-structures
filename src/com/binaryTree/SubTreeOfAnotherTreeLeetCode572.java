package com.binaryTree;

public class SubTreeOfAnotherTreeLeetCode572 {
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
    public  static boolean isIdentical(Node root, Node subTree){
        if (root==null && subTree==null){
            return true;
        }
        if (root==null || subTree==null){
            return false;
        }
        if (root.data== subTree.data){
            return  isIdentical(root.left,subTree.left) && isIdentical(root.right,subTree.right);
        }else {
            return false;
        }

    }

    public static boolean isSubTree(Node root ,Node subTree){
        if (subTree==null){
            return true;
        }
        if (root==null){
            return  false;
        }

            if (isIdentical(root,subTree)) {
                return true;
            }

        return isSubTree(root.left,subTree)||isSubTree(root.right,subTree);
    }

    public static void main(String[] args) {
        Node root = new Node(2);
        root.left = new Node(4);
        root.left.left = new Node(1);
        root.left.right = new Node(2);

        Node subRoot = new Node(4);
        subRoot.left = new Node(1);
        subRoot.right= new Node(2);

        boolean subTree = isSubTree(root, subRoot);
        System.out.println(subTree);

    }
}
