package com.binaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BuildBinaryTree {
    static class  Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            left=null;
            right=null;
        }
    }
    public static  Node   buildTree(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the data");
        int data = scan.nextInt();
        if (data==-1){
            return null;
        }
        Node root = new Node(data);
        System.out.println("Enter the left part data=>"+data);
        root.left = buildTree();
        System.out.println("Enter the right part data=>"+data);
        root.right = buildTree();
        return  root;
    }
    public  static  void levelOrderPrint(Node root){
        if (root==null){
            return;
        }
        Queue<Node>queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()){
            Node currNode = queue.remove();
            if (currNode==null){
                System.out.println();
                     if (queue.isEmpty()){
                          break;
                     }else {
                         queue.add(null);
                     }
            }else {
                System.out.print(currNode.data+" ");
                if (currNode.left!=null){
                    queue.add(currNode.left);
                }
                if (currNode.right!=null){
                    queue.add(currNode.right);
                }
            }
        }
    }
    public  static  void inorderPrint(Node root){
        if (root==null){
            return;
        }
        inorderPrint(root.left);
        System.out.print(root.data+" ");
        inorderPrint(root.right);
    }
    public static void main(String[] args) {
        Node root = buildTree();
        System.out.println("print level order: ");
        levelOrderPrint(root);
        inorderPrint(root);
    }
}
