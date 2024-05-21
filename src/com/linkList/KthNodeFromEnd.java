package com.linkList;

public class KthNodeFromEnd {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node head;

    static int fun(Node head, int postionFromTail) {
        if (head == null) {
            return -1;
        }
        int index = fun(head.next, postionFromTail) + 1;
        if (index == postionFromTail) {
            System.out.println("Node at position " + postionFromTail + " from end is: " + head.data);
        }
        return index;
    }

    static int getNode(Node list, int postionFromTail) {
        return fun(head, postionFromTail);
    }

    public static void main(String[] args) {
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        int positionFromEnd = 2; // Change this to the desired position from the end
        getNode(null, positionFromEnd);
    }
}
