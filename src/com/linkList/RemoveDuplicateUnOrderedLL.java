package com.linkList;

public class RemoveDuplicateUnOrderedLL {
    Node head;
  class   Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            next = null;
        }
    }
     void print(Node head){
      Node temp = head;
      while (temp!=null){
          System.out.print(temp.data+" ");
          temp=temp.next;
      }
     }

    public static void main(String[] args) {

    }
}
