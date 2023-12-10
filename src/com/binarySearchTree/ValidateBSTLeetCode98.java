package com.binarySearchTree;

import java.util.Scanner;

public class ValidateBSTLeetCode98 {
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
    static boolean solve(Node root,long lowerBound, long uperBound){
        if(root==null){
            return true;
        }
        if(root.data>lowerBound && root.data<uperBound){
            boolean leftAns = solve(root.left,lowerBound,root.data);
            boolean rightAns=solve(root.right,root.data,uperBound);

            return leftAns && rightAns;
        }else{
            return false;
        }

    }
    public static boolean isValidBST(Node root) {
        long lowerBound = Long.MIN_VALUE;
        long uperBound= Long.MAX_VALUE;
        boolean ans =solve(root,lowerBound,uperBound);
        return ans;
    }

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        System.out.println("Enter the data:");
        root = takeInput();
        if (isValidBST(root)){
            System.out.println("validate");
        }else {
            System.out.println("not Validate");
        }
    }
}
