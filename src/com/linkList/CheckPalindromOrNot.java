package com.linkList;

public class CheckPalindromOrNot {
    Node head;
    class Node{
        int data;
         Node next;
         Node(int data){
             this.data = data;
             this.next=null;
         }
    }
    boolean checkPalindrom(Node head){
        if(head==null){
            System.out.println("list is empty");
            return true;
        }
        if(head.next==null){
            return true;
        }
        //>1 node list
        //stepA find the middle node
        Node slow = head;
        Node fast =head.next;
        while (fast!=null){
            fast=fast.next;
            if(fast!=null){
                fast=fast.next;
                slow=slow.next;
            }
        }
        //slow pointer is pointing middle node
        //step B reverse linkedlist after middle node
        Node reverseLLHead = reverse(slow.next);
        slow.next=reverseLLHead;
        //stepC start comparisition
        Node temp1 = head;
        Node temp2 = reverseLLHead;
        while (temp2!=null){
            if(temp1.data!= temp2.data){
                return false;
            }else {
                temp1=temp1.next;
                temp2=temp2.next;
            }
        }
        return true;
    }

    Node reverse(Node head){
      Node prev = null;
      Node curr= head;
      Node next = curr.next;
      while (curr!=null){
         next=curr.next;
         curr.next=prev;
         prev=curr;
         curr=next;
      }
      return prev;
    }
    void print(Node head){
        Node temp = head;
        while (temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }
    public static void main(String[] args) {
        CheckPalindromOrNot list = new CheckPalindromOrNot();
        list.head = list.new Node(1);
        list.head.next = list.new Node(2);
        list.head.next.next = list.new Node(3);
        list.head.next.next.next = list.new Node(2);
        list.head.next.next.next.next = list.new Node(1);
        boolean b = list.checkPalindrom(list.head);
        if(b){
            System.out.println("palindrome");
        }else {
            System.out.println("not a palindrome");
        }

    }
}
