package com.binaryTree;

import java.util.LinkedList;
import java.util.Queue;
public class BuildBinaryTreePostOrInorder {
    static Node root;
    static int size =6;
    static int postIndex = size-1;
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
    //find position
    private static int findPosition(int inOrder[],int size,int element){
        for (int i=0;i<size;i++){
            if(inOrder[i]==element){
                return i;
            }
        }
        return -1;
    }
    //build tree using postorder and Inorder
    private static Node buildTreePostOrderAndInorder(int inOrder[],int postOrder[],int size,int inorderStart,int inorderEnd){

        if(postIndex<0 ||inorderStart>inorderEnd){
            return null;
        }
        int element = postOrder[postIndex--];
        Node root = new Node(element);
        int position = findPosition(inOrder,size,element);
        root.right=buildTreePostOrderAndInorder(inOrder,postOrder,size,position+1,inorderEnd);
        root.left=buildTreePostOrderAndInorder(inOrder,postOrder,size,inorderStart,position-1);
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
        int inorder[]={40,20,10,50,30,60};
        int postOrder[]={40,20,50,60,30,10};
        int inorderStart=0;
        int inorderEnd=size-1;
        root=buildTreePostOrderAndInorder(inorder,postOrder,size,inorderStart,inorderEnd);
        levelOrderTraversal(root);
    }
}


