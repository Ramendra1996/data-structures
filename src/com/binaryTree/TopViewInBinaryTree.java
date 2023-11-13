package com.binaryTree;

import java.util.*;

public class TopViewInBinaryTree {
    static Node root;

   private static class Node {
        int data;
        Node left;
        Node right;

        private Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    private static Node buildTree() {
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

    private static void topView(Node root) {
        if (root == null) {
            return;
        }
        //create a map for storing horizontal distance->topNode->data
        class QueueNode {
            Node node;
            int hd;

            private QueueNode(Node node, int hd) {
                this.node = node;
                this.hd = hd;
            }
        }
        Queue<QueueNode> queue = new LinkedList<>();
        Map<Integer, Integer> topViewMap = new TreeMap<>();
        queue.add(new QueueNode(root, 0));
        while (!queue.isEmpty()) {
            QueueNode front = queue.poll();
            Node currentNode = front.node;
            int hd = front.hd;
            if (!topViewMap.containsKey(hd)) {
                topViewMap.put(hd, currentNode.data);
            }
            if (currentNode.left != null) {
                queue.add(new QueueNode(currentNode.left, hd - 1));
            }
            if (currentNode.right != null) {
                queue.add(new QueueNode(currentNode.right, hd + 1));
            }
        }
        // Print the top view
        for (int value : topViewMap.values()) {
            System.out.print(value + " ");
        }
        System.out.println();
        for (Map.Entry<Integer, Integer> map : topViewMap.entrySet()) {
            System.out.println(map.getKey() + " " + map.getValue());
        }

    }
    static Scanner scanner = null;
    public static void main(String[] args) {
        scanner = new Scanner(System.in);

       /* Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.left.right.right = new Node(5);
        root.left.right.right.right = new Node(6);*/
        root = buildTree();
        System.out.println("Top View of Binary Tree:");
        topView(root);

    }
}

//10,20,30,-1,-1,40,60,-1,-1,-1,80,50,-1,70,-1,-1,90,-1,-1
