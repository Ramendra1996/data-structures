package com.linkList;

public class LinkListImp {
    static Node head;
    static Node tail;
    static  class Node{
        int data;
         Node next;
         Node(int data){
             this.data= data;
             this.next= null;
         }
         Node(){
             this.data=0;
             this.next=null;
         }
    }
    static Node insertAtHead(Node head, int data){
       Node newNode = new Node(data);
       newNode.next=head;
       head=newNode;
        if (tail == null) {
            tail = head; // If the list was empty, then tail should also point to the new head
        }
       return head;
    }
    static Node insertAtTail(Node tail,int data){
       Node newNode = new Node(data);
        if (tail != null) {
            tail.next = newNode;
        }
        tail = newNode;
        if (head == null) {
            head = tail; // If the list was empty, then head should also point to the new tail
        }
        return tail;
    }
   static void print(Node head){
      Node temp = head;
       while (temp != null) {
           System.out.print(temp.data + " ");
           temp = temp.next;
       }
       System.out.println();
    }
    public static void main(String[] args) {
     /* Node first = new Node(10);
      Node second = new Node(20);
      Node third = new Node(30);
      Node fourth = new Node(40);
      Node fifth= new Node(50);
      first.next=second;
      second.next=third;
      third.next=fourth;
      fourth.next=fifth;*/
       // Node head = null;
       // Node tail=null;
        head = insertAtHead(head, 20);
        head=insertAtHead(head,30);
        head=insertAtHead(head,40);
        head=insertAtHead(head,50);
        tail= insertAtTail(tail, 60 );
        print(head);
    }

}
