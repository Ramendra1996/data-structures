package com.linkList;

public class DoublyLinkedList {
    Node head;
    Node tail;

    class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }

    }
    void print(){
        Node temp = head;
        while (temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }
    int getLength(){
        int len =0;
        Node temp = head;
        while (temp!=null){
            temp= temp.next;
            len++;
        }
        return len;
    }

    void insertAtHead(int data){
        if(head==null){
            Node newNode = new Node(data);
            head= newNode;
            tail= newNode;
        }else {
            Node newNode = new Node(data);
            newNode.next= head;
            head.prev = newNode;
            head= newNode;
        }
    }
    void insertAtTail(int data){

        if(head==null){
            Node newNode = new Node(data);
            head= newNode;
            tail= newNode;
        }else {
        Node newNode  = new Node(data);
        tail.next=newNode;
        newNode.prev = tail;
        tail= newNode;
        }
    }
    void insertAtPosition(int position, int data){
       if(head==null){
           Node newNode = new Node(data);
           head= newNode;
           tail= newNode;
       }else {
           if(position==1){
               insertAtHead(data);
               return;
           }
           int len = getLength();
           if (position>len){
               insertAtTail(data);
               return;
           }
           //insert at middle
           int i=1;
           Node prevNode = head;
           while (i<position-1){
                prevNode=prevNode.next;
                i++;
           }
           Node currNode = prevNode.next;
           //create a node
           Node newNode = new Node(data);
           //step3
           prevNode.next= newNode;
           newNode.prev=prevNode;
           currNode.prev=newNode;
           newNode.next=currNode;
       }
    }

    void deleteFromPosition(int position){
        if(head==null){
            System.out.println("list is empty");
            return;
        }
        if(head.next==null){
            //single node
            Node temp= head;
            head=null;
            tail= null;
            return;
        }
        if(position>getLength()){
            System.out.println("please enter valid position");
            return;
        }
        if(position==1){
            //want to delete the first node
            Node temp = head;
            head=head.next;
            head.prev=null;
            temp.next= null;
            return;
        }
        int len = getLength();
        if(position==len){
            //delete last node
            Node temp = tail;
            tail= tail.prev;
            temp.prev = null;
            tail.next=null;
            return;
        }
        //delete middle
        //step1 find left,curr,right
        int i=1;
        Node left =head;
        while (i<position-1){
            left=left.next;
            i++;
        }
        Node currNode = left.next;
        Node right =currNode.next;
        //step2
        left.next=right;
        //step3
        right.prev =left;
        //step4
        currNode.next=null;
        currNode.prev=null;
        return;
    }
    public static void main(String[] args) {
        DoublyLinkedList dd = new DoublyLinkedList();
        dd.insertAtHead(2);
        dd.insertAtHead(3);
        dd.insertAtHead(4);
        dd.insertAtTail(5);
        dd.insertAtPosition(2,10);
        dd.deleteFromPosition(5);
        dd.print();
    }
}
