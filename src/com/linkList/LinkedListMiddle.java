package com.linkList;

public class LinkedListMiddle {
    Node head;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    Node getMiddle(){
        if(head==null){
            System.out.println("list is empty");
            return head;
        }
        if(head.next==null){
            return head;
        }
        //ll have >1 node
        Node slow = head;
     //   Node fast = head;
        //or
        Node fast = head;

        while (slow!=null && fast!=null){
            fast=fast.next;
            if(fast!=null){
                fast = fast.next;
                slow=slow.next;
            }
        }
        return slow;
    }

    public void print() {
        if (head == null) {
            System.out.println("list is empty");
            return;
        }
        Node currNode = head;
        while (currNode != null) {
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }
        //   System.out.println("NULL");
    }

    public static void main(String[] args) {
        LinkedListMiddle ll = new LinkedListMiddle();
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(4);
        ll.addFirst(5);
        ll.addFirst(6);
        ll.addFirst(7);
        ll.addFirst(8);
        ll.print();
        System.out.println(" ");
        Node middle = ll.getMiddle();
        System.out.println("middle Node=>"+middle.data);
    }
}
