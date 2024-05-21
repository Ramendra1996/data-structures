package com.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class NextGreaterNodeInLinkedListLeetCode1019 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public static int[] nextLargerNodes(ListNode head) {
        if (head == null) return new int[0];

        // Step 1: Convert ListNode to array
        int size = 0;
        ListNode current = head;
        while (current != null) {
            size++;
            current = current.next;
        }

        int[] result = new int[size];
        int[] listValues = new int[size];
        current = head;
        for (int i = 0; i < size; i++) {
            listValues[i] = current.val;
            current = current.next;
        }

        // Step 2: Find next larger nodes using a stack
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < size; i++) {
            while (!stack.isEmpty() && listValues[stack.peek()] < listValues[i]) {
                result[stack.pop()] = listValues[i];
            }
            stack.push(i);
        }

        return result;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(7);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(5);
        int[] nextLarger = nextLargerNodes(head);
        for (int num : nextLarger) {
            System.out.print(num + " ");
        }
    }
}
