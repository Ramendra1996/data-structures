package com.linkList;

public class ImpLinkedList {
    Node head;
    private int size;
    ImpLinkedList(){
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
    //add first and last
    public  void addFirst(int data){
       Node newNode = new Node(data);
        if(head==null){
             head= newNode;
             return;
        }
        newNode.next=head;
        head=newNode;
    }
     public void addLast(int data){
         Node newNode = new Node(data);
         if(head==null){
             head= newNode;
             return;
         }
         Node currNode = head;
         while (currNode.next!=null){
             currNode = currNode.next;
         }
         currNode.next=newNode;
     }
     //inset add position
    public void addInPosition(int position, int data){
        if(head==null){
            Node newNode = new Node(data);
            head=newNode;
            return;
        }
        if(position==0){
            addFirst(data);
            return;
        }
      //  int len = getSize();
        int len = findLength();
        if(position>=len){
            addLast(data);
            return;
        }
        //step1 find the position
         int i=1;
         Node prev= head;
         while (i<position){
             prev=prev.next;
             i++;
         }
         Node currNode = prev.next;
         //step2
        Node newNode = new Node(data);
        //step3
        newNode.next=currNode;
        //step4
        prev.next=newNode;
    }
    //insert AtValue
    void  insertAtValue(){

    }
     //delete first
    public  void deleteFirst(){
      if(head==null){
          System.out.println("list is empty");
          return;
      }
      size--;
      head =head.next;
    }
    //delete last
    public void deleteLast(){
        if(head==null){
            System.out.println("list is empty");
            return;
        }
        size--;
        if(head.next==null){
            head=null;
            return;
        }
        Node secondLast = head;
        Node lastNode = head.next;//head.next==null to lastNode bi null h
        while (lastNode.next!=null){//
            lastNode=lastNode.next;
            secondLast=secondLast.next;
        }
        secondLast.next=null;
    }
    //delete middle
    public void deleteMiddle(int position){
        int i=1;
        Node prev = head;
        while (i<position-1){
            prev=prev.next;
            i++;
        }
        Node curr = prev.next;
        prev.next=curr.next;
        curr.next=null;
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
         System.out.println("NULL");
     }
     public int getSize(){
         return size;
     }
     public int findLength(){
        int len =0;
        Node temp= head;
        while (temp!=null){
        temp=temp.next;
        len++;
        }
        return len;
     }
    public static void main(String[] args) {
        ImpLinkedList list = new ImpLinkedList();
        list.addFirst(4);
        list.addFirst(5);
        list.addLast(6);
        list.addInPosition(3,79);
        list.deleteMiddle(3);
        System.out.println(list.findLength());
        list.print();
    }
}
