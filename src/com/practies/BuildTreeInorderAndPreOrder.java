package com.practies;


import java.util.LinkedList;
import java.util.Queue;

public class BuildTreeInorderAndPreOrder {

    static  Node root;
    static  int preIndex =0;

    static class Node{
        int data ;
        Node left;
        Node right;
        Node(int data){
            this.data= data;
            left= null;
            right = null;
        }
    }
    public  static  int findPosition(int inorder[], int element){
        for (int i=0;i<inorder.length;i++){
            if (inorder[i]==element){
                return i;
            }
        }
        return -1;
    }
    public  static   Node buildTree(int preOrder[],int inOrder[], int inorderStart,int inorderEnd){
        if (preIndex>preOrder.length || inorderStart>inorderEnd){
            return  null;
        }
        int element = preOrder[preIndex++];
        Node root = new Node(element);
        int position=findPosition(inOrder,element);
        root.left=buildTree(preOrder,inOrder,inorderStart,position-1);
        root.right= buildTree(preOrder,inOrder,position+1,inorderEnd);
        return  root;
    }
    public  static  void  levelOrderPrint(Node root){
        if(root==null){
            return;
        }
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
    public static void main(String[] args) {
        int inOrder[] = {40, 20, 50, 10, 60, 30, 70};
        int preOrder[] = {10, 20, 40, 50, 30, 60, 70};
        int inorderStart=0;
        int inorderEnd =inOrder.length-1;
         root= buildTree(preOrder,inOrder,inorderStart,inorderEnd);
         levelOrderPrint(root);

    }
}
