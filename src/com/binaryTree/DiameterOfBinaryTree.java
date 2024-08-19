package com.binaryTree;

import javax.imageio.ImageTranscoder;

public class DiameterOfBinaryTree {
    static  class  Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            left = null;
            right= null;
        }
    }
    static class Pair{
        int hd;
        int dia;
        Pair(int hd,int dia){
            this.hd = hd;
            this.dia=dia;
        }
    }
     public  static  int getHeight(Node root){
         if (root==null){
             return 0;
         }
         int leftHeight = getHeight(root.left);
         int rightHeight = getHeight(root.right);
         return Math.max(leftHeight,rightHeight)+1;
     }

     public  static  int getDiameter(Node root){
        if (root==null){
            return 0;
        }
        int dia1 = getDiameter(root.left);
        int dia2 = getDiameter(root.right);
        int dia3 = getHeight(root.left) +getHeight(root.right) +1;
        return Math.max(dia3,Math.max(dia1,dia2));
     }

     public static  Pair getDiameter1(Node root){
        if (root==null){
            return new Pair(0,0);
        }
         Pair leftPair = getDiameter1(root.left);
         Pair rightPair = getDiameter1(root.right);
         int maxHeight  = Math.max(leftPair.hd,rightPair.hd)+1;
         int leftDia= leftPair.dia;
         int rightDia = rightPair.dia;
         int  rootDia= leftPair.hd + rightPair.hd +1;
         int finalDia = Math.max(rootDia,Math.max(leftDia,rightDia));
         return  new Pair(maxHeight,finalDia);

     }
    public static void main(String[] args) {
        Node root = new Node(2);
        root.left= new Node(3);
        root.left.left= new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(6);
        root.right.left= new Node(7);
        root.right.right= new Node(8);
        int height = getHeight(root);
        System.out.println(height);
        int diameter = getDiameter(root);
        System.out.println("diameter=>"+diameter);
        Pair ans = getDiameter1(root);
        System.out.println("diameter=>"+ans.dia);
        System.out.println("maxHeight=>"+ans.hd);
    }
}
