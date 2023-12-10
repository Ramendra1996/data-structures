package com.binarySearchTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinarySearchTree {

    static Node root;
    static Scanner scanner = null;

    static class Node {
        int data;
        Node left;
        Node right;

        private Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }


    private static Node insertIntoBST(Node root, int data) {
        if (root == null) {
            //this is the first node we have to create
            root = new Node(data);
            return root;
        }
        if (root.data > data) {
            //insert in left
            root.left = insertIntoBST(root.left, data);
        } else {
            root.right = insertIntoBST(root.right, data);
        }
        return root;
    }


    private static Node takeInput() {
        Node root = null;
        int data = scanner.nextInt();
        while (data != -1) {
            root = insertIntoBST(root, data);
            data = scanner.nextInt();
        }
        return root;
    }


    //level order traversal
    private static void levelOrderTraversal(Node root) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {
            Node tempNode = queue.poll();
            if (tempNode == null) {
                System.out.println();
                if (!queue.isEmpty()) {
                    queue.add(null);
                }
            } else {
                System.out.print(tempNode.data + " ");
                // Enqueue left child
                if (tempNode.left != null) {
                    queue.add(tempNode.left);
                }
                // Enqueue right child
                if (tempNode.right != null) {
                    queue.add(tempNode.right);
                }
            }

        }
    }

    private static void preOrderTraversal(Node root) {
        //NLR
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);

    }

    private static void inOrderTraversal(Node root) {
        //LNR
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.data + " ");
        inOrderTraversal(root.right);
    }

    private static void postOrderTraversal(Node root) {
        //LRN
        if (root == null) {
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data + " ");

    }
    //searching

    private static Node findNodeInBST(Node root, int target) {
        if (root == null) {
            return null;
        }
        if (root.data == target) {
            return root;
        }
        if (target > root.data) {
            //right me search kro
            return findNodeInBST(root.right, target);
        } else {
            return findNodeInBST(root.left, target);
        }

    }
    private static int minValue(Node root){
        Node temp = root;
        if(temp==null){
            return -1;
        }
        while (temp.left!=null){
            temp=temp.left;
        }
        return temp.data;
    }

    private static int maxValue(Node root){
        Node temp =root;
        if(temp==null){
            return -1;
        }
        while (temp.right!=null){
            temp=temp.right;
        }
        return temp.data;
        //recurcivly
        /*while (root.right != null) {
            root = root.right;
        }
        return root.data;*/
    }
    //predecessor and successor

    public static Node inorderSuccess(Node root){
        while (root.left!=null){
            root=root.left;
        }
        return root;
    }

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        System.out.println("Enter the data:");
        root = takeInput();
        System.out.println("print level order traversal");
        levelOrderTraversal(root);
        System.out.println("\n print In order traversal:");
        inOrderTraversal(root);
        System.out.println("\nprint pre order traversal:");
        preOrderTraversal(root);
        System.out.println("\nprint post order traversal");
        postOrderTraversal(root);
        System.out.println("\n element search");
          root=  findNodeInBST(root,15);
        System.out.println(root);
        int minValue = minValue(root);
        System.out.println("\n minimum value=:"+minValue);
        int maxVaue = maxValue(root);
        System.out.println("\n maximum value=:"+maxVaue);




    }
}
//10,20,5,11,17,2,4,6,8,25,15,-1
//searching
// avg TC->0(logn)
//worst TC->0(n)
//insersion
// avg TC->0(log n)
//worst TC->0(n)
//100,50,150,40,60,175,110,-1