package leetcode;

import org.w3c.dom.NodeList;

import java.util.Objects;

public class _206_ReversedLinkedList {
    public ListNode reverseLinkedList(ListNode head) {
        ListNode current = head;
        ListNode next = head;
        ListNode previous = null;

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        return previous;
    }

    public static class LinkedList {
        ListNode head;
        ListNode tail;

        public LinkedList(int value) {
            head = new ListNode(value);
            tail = head;
        }

        public LinkedList(int... values) {
            this(values[0]);
            for (int i = 1; i < values.length; i++) {
                insert(values[i]);
            }
        }

        public void insert(int value) {
            ListNode newNode = new ListNode(value);
            newNode.next = head;
            head = newNode;
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
