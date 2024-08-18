package com.binaryTree;

import java.util.*;

public class PreOrderTraversalBinaryTree {
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

    public static void preorderPrintRec(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorderPrintRec(root.left);
        preorderPrintRec(root.right);
    }

    public  static List<Integer> preorderPrintItr(Node root){
        List<Integer> list = new ArrayList<>();
           if (root==null){
               return list;
           }
        Stack<Node> st = new Stack<>();
           st.push(root);
           while (!st.isEmpty()){
                root = st.pop();
                list.add(root.data);
                if (root.right!=null){
                    st.push(root.right);
                }
                if(root.left!=null){
                    st.push(root.left);
                }
           }
        return  list;
    }

    public static void main(String[] args) {
        Node root = new Node(2);
        root.left = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(6);
        root.right.left = new Node(7);
        root.right.right = new Node(8);
        System.out.println("preorder rec method: ");
        preorderPrintRec(root);
        System.out.println("\npreorder itr method: ");
        List<Integer> list = preorderPrintItr(root);
        System.out.println(list);


    }
}
