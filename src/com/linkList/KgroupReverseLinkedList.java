package com.linkList;

public class KgroupReverseLinkedList {
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

    //imp question
    Node reverseKNodes(Node head, int k) {
        if (head == null) {
            System.out.println("LL is empty");
            return null;
        }

        int len = findLength(head);
        if (k > len) {
            // System.out.println("Enter valid value for k ");
            return head;
        }

        // Step A: reverse first k nodes of LL
        Node prev = null;
        Node curr = head;
        Node forward = curr.next;
        int count = 0;

        while (count < k) {
            forward = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forward;
            count++;
        }

        // Step B: recursive call
        if (forward != null) {
            // we still have nodes left to reverse
            Node recursionKaAns = reverseKNodes(forward, k);
            head.next = recursionKaAns;
        }

        // Step C: return head of the modified LL
        return prev;
    }


    public void print(Node head) {
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

    public int findLength(Node head) {
        int len = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            len++;
        }
        return len;
    }

    public static void main(String[] args) {
        KgroupReverseLinkedList ll = new KgroupReverseLinkedList();
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(4);
        ll.addFirst(5);
        ll.addFirst(6);
        ll.addFirst(7);
        ll.addFirst(8);
        System.out.println(ll.findLength(ll.head));
        ll.head = ll.reverseKNodes(ll.head, 2);
        ll.print(ll.head);
    }
}
