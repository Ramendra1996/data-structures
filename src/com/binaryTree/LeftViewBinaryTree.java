package com.binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LeftViewBinaryTree {
    static Node root;
    static Scanner scanner =null;

    private static  class Node{
        int data;
         Node left;
          Node right;
          private Node(int data){
              this.data = data;
              left=null;
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
  //recursive approach
   private static void leftView(Node root ,List<Integer> list,int level){
    if(root==null){
        return;
    }
    if(level==list.size()){
        list.add(root.data);
    }
    //left
       leftView(root.left,list,level+1);
    //right
       leftView(root.right,list,level+1);


   }
  //left view by level order traversal
   private static void leftViewByLevelOrder(Node root){

   }

    public static void main(String[] args) {
      scanner = new Scanner(System.in);
       root=buildTree();
        List<Integer> list = new ArrayList<>();
        int level=0;
        leftView(root,list,level);

        for (int i:list){
            System.out.println(i);
        }

    }
}

//10,20,30,-1,-1,40,60,-1,-1,-1,80,50,-1,70,-1,-1,90,-1,-1