package com.binaryTree;

import java.util.*;
public class BinaryTree {
    static Node root;
    static class Node {
        int data;
        Node left;
        Node right;
        public Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
    public static Node buildTree() {
        Node root = null;
        System.out.println("Enter data:");
        int data = scanner.nextInt();
        if (data == -1) {
            return null;
        }
        root = new Node(data);
        System.out.println("Enter data for left part=>" + data);
        root.left = buildTree();
        System.out.println("Enter data for right part=>" + data);
        root.right = buildTree();
        return root;
    }

    //level order traversal

    public static void  levelOrderTraversal(Node root){
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node tempNode = queue.poll();
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
    static Scanner scanner = null;
    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        root=buildTree();
        levelOrderTraversal(root);
    }
}
