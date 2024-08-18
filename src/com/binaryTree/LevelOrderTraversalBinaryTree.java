package com.binaryTree;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversalBinaryTree {
    static  class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data= data;
            left = null;
            right= null;
        }
    }
    public  static  void levelOrderPrint(Node root){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()){
            Node currNode = queue.remove();

            if (currNode==null){
                System.out.println();
                 if (queue.isEmpty()){
                      break;
                 }else{
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

    public  static  void  levelOrderPrint1(Node root){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int level = queue.size();
            for (int i=0;i<level;i++){
                Node currNode = queue.remove();
                System.out.print(currNode.data+" ");

                if (currNode.left!=null){
                    queue.add(currNode.left);
                }
                if (currNode.right!=null){
                    queue.add(currNode.right);
                }

            }
            System.out.println();
        }
    }

    public  static List<List<Integer>> levelOrderPrint2(Node root){
        List<List<Integer>>finalList = new ArrayList<>();

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int level = queue.size();
            List<Integer>list = new ArrayList<>();
            for (int i=0;i<level;i++){
                Node currNode = queue.remove();
                list.add(currNode.data);
                if (currNode.left!=null){
                    queue.add(currNode.left);
                }
                if (currNode.right!=null){
                    queue.add(currNode.right);
                }
            }
            finalList.add(list);
            System.out.println();
        }
      return finalList;
    }
    public static void main(String[] args) {
        Node root = new Node(2);
        root.left = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(6);
        root.right.left = new Node(7);
        root.right.right = new Node(8);
        System.out.println("level order print:");
        levelOrderPrint(root);
        System.out.println("\nlevel order print:");
        levelOrderPrint1(root);
        System.out.println("\nlevel order print: ");
        List<List<Integer>> lists = levelOrderPrint2(root);
        System.out.println(lists);
    }
}
