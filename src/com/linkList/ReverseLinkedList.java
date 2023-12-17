package com.linkList;

public class ReverseLinkedList {
    Node head;
    private int size;
    ReverseLinkedList(){
        this.size=0;
    }
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next=null;
            size++;
        }
    }

    public  void addFirst(int data){
        Node newNode = new Node(data);
        if(head==null){
            head= newNode;
            return;
        }
        newNode.next=head;
        head=newNode;
    }

    public  void print(){
        if(head==null){
            System.out.println("list is empty");
            return;
        }
        Node currNode = head;
        while (currNode!=null){
            System.out.print(currNode.data+" ");
            currNode=currNode.next;
        }
     //   System.out.println("NULL");
    }

    Node recursiveByLoop(){
         Node prev=null;
         Node curr = head;
         while (curr!=null){
             Node temp = curr.next;
             curr.next=prev;
             prev=curr;
             curr=temp;
         }
         return prev;
    }
    public static void main(String[] args) {
        ReverseLinkedList rl = new ReverseLinkedList();
        rl.addFirst(2);
        rl.addFirst(3);
        rl.addFirst(4);
        rl.addFirst(5);
        rl.recursiveByLoop();
        rl.print();
    }
}
