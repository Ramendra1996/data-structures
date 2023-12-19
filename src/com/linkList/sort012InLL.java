package com.linkList;

public class sort012InLL {
    Node head;
  class   Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
     void sort012(Node head){
      int zerCount =0;
      int oneCount =0;
      int twoCount=0;
       Node temp =head;
       while (temp!=null){
           if(temp.data==0){
               zerCount++;
           }
           if(temp.data==1){
              oneCount++;
           }
           if(temp.data==2){
               twoCount++;
           }
           temp=temp.next;
       }
       //step2 fill 0,1,2 int original ll
         temp=head;
           //fill zero
           //fill one
           //fill two
           while (zerCount!=0){
            temp.data=0;
            temp=temp.next;
            zerCount--;
           }
           while (oneCount!=0){
               temp.data=1;
               temp=temp.next;
               oneCount--;
           }
           while (twoCount!=0){
               temp.data=2;
               temp=temp.next;
               twoCount--;
           }
     }

     Node sorted012(Node head){
         if (head == null || head.next == null) {
             return head;
         }
      Node zeroHead = new Node(-1);
      Node zeroTail = zeroHead;
      Node oneHead = new Node(-1);
      Node oneTail = oneHead;
      Node twoHead = new Node(-1);
      Node twoTail = twoHead;
      //travers the original LL
         Node curr = head;
         while (curr!=null){
             if(curr.data==0){
                 //take out the zero wali node
                 Node temp = curr;
                 curr=curr.next;
                 temp.next=null;
                 //append the zero node in zeroHead LL
                 zeroTail.next=temp;
                 zeroTail=temp;
             } else if (curr.data==1) {
                 //take out the one wali node
                 Node temp = curr;
                 curr=curr.next;
                 temp.next=null;
                 //append the one node in zeroHead LL
                 oneTail.next=temp;
                 oneTail=temp;
             } else if (curr.data==2) {
                 //take out the two wali node
                 Node temp = curr;
                 curr=curr.next;
                 temp.next=null;
                 //append the two node in zeroHead LL
                 twoTail.next=temp;
                 twoTail=temp;
             }
         }
         //ab yha pr zero ,one two LL ready h

         //join them
         //remove dummy node
         // modify one bali list
         Node temp =oneHead;
         oneHead=oneHead.next;
         temp.next=null;

         //modify two bali list
         temp = twoHead;
         twoHead=twoHead.next;
         temp.next=null;

         //join list
         if(oneHead!=null){
          //one bali list non empty h
             zeroTail.next=oneHead;
             if(twoHead!=null){
                 oneTail.next=twoHead;
             }
         }else {
              //one bali list is empty
             if(twoHead!=null){
                 zeroTail.next=twoHead;
             }
         }
         //remove zerohead  dummy node
         temp=zeroHead;
         zeroHead=zeroHead.next;
         temp.next=null;
         //return of the modify task
       return zeroHead;
     }

    public  Node getsorted012(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node zeroHead = new Node(-1);
        Node zeroTail = zeroHead;
        Node oneHead = new Node(-1);
        Node oneTail = oneHead;
        Node twoHead = new Node(-1);
        Node twoTail = twoHead;

        Node curr = head;

        while (curr != null) {
            if (curr.data == 0) {
                zeroTail.next = curr;
                zeroTail = curr;
            } else if (curr.data == 1) {
                oneTail.next = curr;
                oneTail = curr;
            } else if (curr.data == 2) {
                twoTail.next = curr;
                twoTail = curr;
            }
            curr = curr.next;
        }

        // Join the lists
        zeroTail.next = oneHead.next;
        oneTail.next = twoHead.next;

        // Set the next of the last node to null to avoid cycles in the list
        twoTail.next = null;

        // Remove dummy nodes
        Node sortedHead = zeroHead.next;

        return sortedHead;
    }
    void print(Node head){
      Node temp = head;
      while (temp!=null){
          System.out.print(temp.data+" ");
          temp=temp.next;
      }
    }
    public static void main(String[] args) {
        sort012InLL list = new sort012InLL();
        list.head = list.new Node(2);
        list.head.next = list.new Node(2);
        list.head.next.next = list.new Node(2);
        list.head.next.next.next = list.new Node(2);
        list.head.next.next.next.next = list.new Node(2);
        list.head.next.next.next.next.next = list.new Node(2);
        list.head.next.next.next.next.next.next = list.new Node(2);
        list.head.next.next.next.next.next.next.next = list.new Node(2);

        System.out.println("phele ll");
        list.print(list.head);
        System.out.println("\nbaad me ll");
         list.sort012(list.head);
         list.print(list.head);
        System.out.println("\n pointer se ll");
        list.sorted012(list.head);
        list.print(list.head);
    }
}
