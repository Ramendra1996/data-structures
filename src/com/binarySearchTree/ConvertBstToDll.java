package com.binarySearchTree;

public class ConvertBstToDll {

    static class  Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            right=null;
            left=null;
        }
    }

    public  static  void covert(Node root,Node head){
      if(root==null){
          return;
      }
      //rightsubtree into LL
        covert(root.right,head);
      //atach root node
        root.right=head;
        if(head!=null){
            head.left=root;
        }
        //update head
        head=root;
        //left subtree
        covert(root.left,head);
    }

    public static void main(String[] args) {

    }
}
