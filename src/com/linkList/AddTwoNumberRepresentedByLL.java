package com.linkList;

public class AddTwoNumberRepresentedByLL {
    Node head;
    class  Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next= null;
        }
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
    Node solve(Node head1, Node head2){
        if (head1==null){
            return head2;
        }
        if (head2==null){
            return head1;
        }
        //step1 reverse both linked list
           head1 = reverse(head1);
           head2=reverse(head2);
        //step2  add both linked list
        Node ansHead = null;
        Node ansTail = null;
        int carry =0;
        while (head1!=null && head2!=null){
          int sum = carry + head1.data+head2.data;
          int digit = sum%10;
          carry=sum/10;
          Node newNode = new Node(digit);
          if(ansHead==null){
              //first node insert kr rahe ho
              ansHead =newNode;
              ansTail=newNode;
          }else {
              ansTail.next=newNode;
              ansTail=ansTail.next;
          }
          head1=head1.next;
          head2=head2.next;
        }
        while (head1!=null){
            int sum = carry+head1.data;
            int digit =sum%10;
            carry=sum/10;
            Node newNode = new Node(digit);
            ansTail.next=newNode;
            ansTail=newNode;
            head1=head1.next;

        }
        while (head2!=null){
            int sum = carry+head2.data;
            int digit =sum%10;
            carry=sum/10;
            Node newNode = new Node(digit);
            ansTail.next=newNode;
            ansTail=newNode;
            head2=head2.next;

        }
        //handle carry ko alag se
        while (carry!=0){
            int sum = carry;
            int digit = sum%10;
            carry=sum/10;
            Node newNode = new Node(digit);
            ansTail.next=newNode;
            ansTail = newNode;
        }
        //step3 reverse the ans bali linked list
        ansHead=reverse(ansHead);
        return ansHead;
    }
     void print(Node head){
        Node temp = head;
        while (temp!=null){
            System.out.print(temp.data+" ");
            temp= temp.next;
        }
     }
    public static void main(String[] args) {
        AddTwoNumberRepresentedByLL list = new AddTwoNumberRepresentedByLL();
           Node head1 = list.new Node(2);
           Node second1 = list.new Node(4);
           head1.next = second1;

           Node head2 = list.new Node(2);
           Node second2 = list.new Node(3);
           Node third2 =list.new Node(4);
           head2.next =second2;
           second2.next=third2;

        Node solve = list.solve(head1, head2);
        list.print(solve);

    }
}
