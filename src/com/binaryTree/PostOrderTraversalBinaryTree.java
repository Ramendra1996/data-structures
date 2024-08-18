package com.binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversalBinaryTree {
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
    public  static  void  postorderPrintRec(Node root){
          if (root==null){
              return;
          }
          postorderPrintRec(root.left);
          postorderPrintRec(root.right);
        System.out.print(root.data+" ");
    }
    public static List<Integer> postorderPrintItr(Node root){
        List<Integer> list = new ArrayList<>();
        if (root==null){
            return list;
        }
        Stack<Node> stack = new Stack<>();
        Node lastVisited = null;
        Node currentNode = root;

        while (!stack.isEmpty() || currentNode != null) {
            if (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            } else {
                Node peekNode = stack.peek();
                if (peekNode.right != null && lastVisited != peekNode.right) {
                    currentNode = peekNode.right;
                } else {
                    list.add(peekNode.data);
                    lastVisited = stack.pop();
                }
            }
        }
        return list;

    }
    public static void main(String[] args) {
        Node root = new Node(2);
        root.left = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(6);
        root.right.left = new Node(7);
        root.right.right = new Node(8);
        System.out.println("post order rec method:");
        postorderPrintRec(root);
        System.out.println("\npost order itr method:");
        List<Integer> list = postorderPrintItr(root);
        System.out.println(list);
    }
}
