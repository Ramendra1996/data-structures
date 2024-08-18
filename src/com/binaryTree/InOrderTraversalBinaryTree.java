package com.binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTraversalBinaryTree {
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

    public static void inOrderPrintRec(Node root) {
        if (root == null) {
            return;
        }
        inOrderPrintRec(root.left);
        System.out.print(root.data + " ");
        inOrderPrintRec(root.right);
    }

    public static List<Integer> inorderPrintItr(Node root) {
      List<Integer> list = new ArrayList<>();
      if (root==null){
          return list;
      }
      Stack<Node> st = new Stack<>();
      while (root!=null || !st.isEmpty()){

          while (root!=null){
            st.push(root);
            root = root.left;
          }
           root = st.pop();
           list.add(root.data);
          root= root.right;
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
        System.out.println("inorder print rec method");
        inOrderPrintRec(root);
        System.out.println("\ninorder print itr method:");
        List<Integer> list = inorderPrintItr(root);
        System.out.println(list);

    }
}
