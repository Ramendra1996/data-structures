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
        RemoveDuplicateUnOrderedLL list = new RemoveDuplicateUnOrderedLL();
        list.head = list.new Node(4);
        list.head.next = list.new Node(2);
        list.head.next.next = list.new Node(1);
        list.head.next.next.next = list.new Node(4);
        list.head.next.next.next.next = list.new Node(2);
        list.head.next.next.next.next.next = list.new Node(7);


    }
}

/**
 * write a code approach
 * 1->nestedLoop
 * 2->map
 * 3->sort
 */