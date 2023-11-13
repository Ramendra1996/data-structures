package com.binaryTree;

import java.util.Scanner;

public class BoundaryTraversalInBinaryTree {
    static Node root;
    static Scanner scanner = null;

    static class Node{
        int data;
         Node left;
          Node right;
          private Node(int data){
              this.data = data;
               left= null;
               right=null;
          }
    }
    private static Node buildTree(){
        Node root =null;
        System.out.println("Enter data:");
        int data = scanner.nextInt();
        if(data==-1){
            return null;
        }
        root = new Node(data);
        System.out.println("Enter data for left part=>"+data);
        root.left =buildTree();
        System.out.println("Enter data for right part=>"+data);
        root.right = buildTree();
        return root;
    }
    private static void printLeftBoundary(Node root){
        //if root is null then go back
        if(root==null){
            return;
        }
        //if root node is leaf then go back
        if(root.left==null && root.right==null){
           return;
        }
        System.out.println(root.data);
        if (root.left!=null){
            printLeftBoundary(root.left);
        }else {
            printLeftBoundary(root.right);
        }
    }
    private static void printLeafBoundary(Node root){
     if (root==null){
         return;
     }
     if (root.left==null && root.right==null){
         System.out.println(root.data);
     }
     printLeafBoundary(root.left);
     printLeafBoundary(root.right);
    }

    private static void printRightBoundary(Node root){
        //base case
        if (root==null){
            return;
        }
        if (root.left==null && root.right==null){
            return;
        }
        if(root.right!=null){
            printRightBoundary(root.right);
        }else{
            printRightBoundary(root.left);
        }
        System.out.println(root.data);
    }

    private static void boundaryTraversal(Node root){
        if (root==null){
            return;
        }
        System.out.println(root.data);
        //A
        printLeftBoundary(root.left);
        printLeafBoundary(root);
        printRightBoundary(root.right);
    }

    public static void main(String[] args) {
        scanner=new Scanner(System.in);
        root = buildTree();
        boundaryTraversal(root);

    }
}

//10,20,30,-1,-1,40,60,-1,-1,-1,80,50,-1,70,-1,-1,90,-1,-1