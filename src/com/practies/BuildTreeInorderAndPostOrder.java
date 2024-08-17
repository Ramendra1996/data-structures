package com.practies;

import java.util.LinkedList;
import java.util.Queue;

public class BuildTreeInorderAndPostOrder {
    static  Node root;
    static  int postIndex;
   static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            left= null;
            right = null;
        }
    }
    public  static  int findPostion(int inorder[],int element){
       for (int i=0;i<inorder.length;i++){
           if (inorder[i]==element){
               return i;
           }
       }
       return  -1;
    }

    public static Node buildTree(int postOrder[],int inorder[],int indorStart,int inorderEnd){
        if(postIndex<0 || indorStart>inorderEnd){
            return null;
        }
        int element = postOrder[postIndex--];
        Node root = new Node(element);
        int position = findPostion(inorder,element);
        root.right=buildTree(postOrder,inorder,position+1,inorderEnd);
        root.left = buildTree(postOrder,inorder,indorStart,position-1);
        return  root;
    }

    public  static  void  levelOrderPrint(Node root){
       if (root==null){
           return;
       }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i=0;i<size;i++){
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
        int inorder[]={40,20,10,50,30,60};
        int postOrder[]={40,20,50,60,30,10};
        int inorderStart =0;
        int inorderEnd =inorder.length-1;
        postIndex=postOrder.length-1;
     Node  root= buildTree(postOrder,inorder,inorderStart,inorderEnd);
        levelOrderPrint(root);

    }
}
