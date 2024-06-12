package com.linkList;

public class RemoveDuplicateFromSortedLL {
    Node head;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    /*    void removeDuplicate(Node head){
            if(head==null){
                System.out.println("ll is empty");
                return;
            }
            if(head.next==null){
                System.out.println("single node in ll");
                return;
            }
            //>1 node in ll
            Node curr = head;
            while (curr!=null){
                if((curr.next!=null)&& (curr.data==curr.next.data)){
                    curr.next=curr.next.next;
                }else {
                    curr = curr.next;
                }
            }
        }*/
    void removeDuplicate(Node head) {
        if (head == null) {
            System.out.println("ll is empty");
            return;
        }
        if (head.next == null) {
            System.out.println("single node in ll");
            return;
        }
        // >1 node in ll
        Node curr = head;
        while (curr != null && curr.next != null) {
            if (curr.data == curr.next.data) {
                    curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
    }

    void print(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        RemoveDuplicateFromSortedLL list = new RemoveDuplicateFromSortedLL();
        list.head = list.new Node(1);
        list.head.next = list.new Node(2);
        list.head.next.next = list.new Node(2);
        list.head.next.next.next = list.new Node(3);
        list.head.next.next.next.next = list.new Node(4);
        list.head.next.next.next.next.next = list.new Node(4);
        System.out.println("phele ll");
        list.print(list.head);
        System.out.println("\nbaad me ll");
        list.removeDuplicate(list.head);
        list.print(list.head);
    }
}
