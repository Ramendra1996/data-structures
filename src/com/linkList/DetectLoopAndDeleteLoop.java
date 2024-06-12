package com.linkList;

/** flowed cycle detection algo
 */
public class DetectLoopAndDeleteLoop {
    Node head;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Boolean checkNode(Node head) {
        if (head == null) {
            System.out.println("list is empty");
            return false;
        }
        Node slow = head;
        Node fast = head;
        Node prev = null;
        while (fast != null) {
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
                slow = slow.next;
            }
            if (slow == fast) {
                //loop present
                // Loop detected, now remove the loop
                //  removeLoop(head, slow, prev);
                //    System.out.println(slow.data);
                return true;
            }
        }
        //fast null ho gya
        return false;
    }
  /*  void removeLoop(Node head, Node loopNode, Node prev) {
        Node ptr1 = head;
        Node ptr2 = loopNode;

        // Move one pointer to the head of the linked list
        while (ptr1 != ptr2) {
            ptr1 = ptr1.next;
            prev = ptr2;
            ptr2 = ptr2.next;
        }

        // Set the next of the loop node to null
        prev.next = null;
    }*/
    //starting point of loop

    Node startingPoint(Node head) {
        if (head == null) {
            System.out.println("list is empty");
            return null;
        }
        Node slow = head;
        Node fast = head;
        while (fast != null) {
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
                slow = slow.next;
            }
            if (slow == fast) {
                slow = head;
                break;
            }
        }
        //fast null ho gya
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    Node removeLoop(Node head) {
        if (head == null) {
            System.out.println("list is empty");
            return null;
        }
        Node slow = head;
        Node fast = head;
        while (fast != null) {
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
                slow = slow.next;
            }
            if (slow == fast) {
                slow = head;
                break;
            }
        }
        //fast null ho gya
        Node prev = fast;
        while (slow != fast) {
            prev=fast;
            slow = slow.next;
            fast = fast.next;
        }
        prev.next=null;
        return slow;
    }

    public static void main(String[] args) {
        DetectLoopAndDeleteLoop list = new DetectLoopAndDeleteLoop();

        list.head = list.new Node(1);
        list.head.next = list.new Node(2);
        list.head.next.next = list.new Node(3);
        list.head.next.next.next = list.new Node(4);
        list.head.next.next.next.next = list.head.next;
        Boolean check = list.checkNode(list.head);
        if (check) {
            System.out.println("loop present");
        } else {
            System.out.println("loop not present");
        }
        list.head = list.startingPoint(list.head);

        System.out.println(list.head.data);

    }
}
