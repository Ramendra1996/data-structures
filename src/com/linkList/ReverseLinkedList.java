package com.linkList;

public class ReverseLinkedList {
    static Node head;
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


    public void  reverseIterator(){

        if(head==null ||head.next==null){
            System.out.println("list is empty");
            return;
        }

        Node prevNode = head;
        Node currNode = head.next;
        while (currNode!=null){
            Node nextNode = currNode.next;
            currNode.next=prevNode;
            //update
            prevNode = currNode;
            currNode = nextNode;
        }
        head.next=null;
        head = prevNode;
    }

    public Node  reverseRec(Node head){
        // Base case: if head is null or only one node, return head
        if (head == null || head.next == null) {
            return head;
        }

        // Recursively reverse the rest of the list
        Node newHead = reverseRec(head.next);

        // Set the next node's next pointer to point back to the current node
        head.next.next = head;

        // Set the current node's next pointer to null
        head.next = null;

        // Return the new head of the reversed list
        return newHead;


    }
    public static void main(String[] args) {
        ReverseLinkedList rl = new ReverseLinkedList();
        rl.addFirst(2);
        rl.addFirst(3);
        rl.addFirst(4);
        rl.addFirst(5);
        head = rl.recursiveByLoop();
        rl.print(head);

    }
}
