package com.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class BuildBinaryTreeUsingPreOrInorder {
    static Node root;
    static int preIndex = 0;

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

    // Find the root element position
    private static int findPosition(int inOrder[], int size, int element) {
        for (int i = 0; i < size; i++) {
            if (inOrder[i] == element) {
                return i;
            }
        }
        return -1;
    }

    // Build tree
    private static Node buildTreeFromPreOrderInOrder(int inOrder[], int preOrder[], int size, int inorderStart, int inorderEnd) {
        if (preIndex >= size || inorderStart > inorderEnd) {
            return null;
        }
        int element = preOrder[preIndex++];
        Node root = new Node(element);
        int position = findPosition(inOrder, size, element);
        root.left = buildTreeFromPreOrderInOrder(inOrder, preOrder, size, inorderStart, position - 1);
        root.right = buildTreeFromPreOrderInOrder(inOrder, preOrder, size, position + 1, inorderEnd);
        return root;
    }

    // Print level order traversal
    private static void levelOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                Node tempNode = queue.poll();
                System.out.print(tempNode.data + " ");
                if (tempNode.left != null) {
                    queue.add(tempNode.left);
                }
                if (tempNode.right != null) {
                    queue.add(tempNode.right);
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int inOrder[] = {40, 20, 50, 10, 60, 30, 70};
        int preOrder[] = {10, 20, 40, 50, 30, 60, 70};
        int size = 7;
        int inorderStart = 0;
        int inorderEnd = size - 1;
        root = buildTreeFromPreOrderInOrder(inOrder, preOrder, size, inorderStart, inorderEnd);
        levelOrderTraversal(root);
    }
}
