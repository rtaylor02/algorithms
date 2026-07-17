package udemy.scottbarret.javadsa;

import java.util.ArrayList;
import java.util.List;

public class Section6_LL_Interview_Leetcode_Exercise {

    public static class LinkedList {
        private Node head;
        private Node tail;

        public LinkedList(int value) {
            Node newNode = new Node(value);
            this.head = newNode;
            this.tail = newNode;
        }

        public Node getHead() {
            return head;
        }

        public Node getTail() {
            return tail;
        }

        public void printList() {
            Node temp = head;

            while (temp != null) {
                System.out.println(temp.value);
                temp = temp.next;
            }
        }

        public void printAll() {
            if (head == null) {
                System.out.println("head: null");
                System.out.println("tail: null");
            } else {
                System.out.println("head: " + head.value);
                System.out.println("tail: " + tail.value);
            }

            if (head == null) {
                System.out.println("empty");
            } else {
                printList();
            }
        }

        public void makeEmpty() {
            this.head = null;
            this.tail = null;
        }

        public void append(int value) {
            Node newNode = new Node(value);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        public List asList() {
            List<Integer> contents = new ArrayList<>();
            Node temp = head;
            while (temp != null) {
                contents.add(temp.value);
                temp = temp.next;
            }

            return contents;
        }

        public Node findMiddleNode() {
            // Both fast pointer and slow pointer are starting at head
            Node fastPointer = head;
            Node slowPointer = head;

            // Each iteration, fastPointer moves 2 nodes, slowPointer moves 1
            // When fastPointer reaches the end of the list, slowPointer will be at the middle node
            while (fastPointer != null && fastPointer.next != null) {
                slowPointer = slowPointer.next;
                fastPointer = fastPointer.next.next;
            }

            return slowPointer; // Middle node
        }

        public Node findKthNode(int k) {
            Node slowPointer = head;
            Node fastPointer = head;
            int tracker = 0;

            if (k <= 0) {
                return null;
            }

            for (int i = 0; i < k; i++) {
                if (fastPointer == null) {
                    return null;
                }
                fastPointer = fastPointer.next;
            }

            while (fastPointer != null) {
                slowPointer = slowPointer.next;
                fastPointer = fastPointer.next;
                if (fastPointer == null) {

                }
            }

            return slowPointer;
        }

        public static class Node {
            private Node next;
            private int value;

            public Node(int value) {
                this.value = value;
            }

            int getValue() {
                return this.value;
            }

            void setNext(Node next) {
                this.next = next;
            }
        }

        public boolean hasLoop() {
            Node slowPointer = head;
            Node fastPointer = head;

            while (fastPointer != null && fastPointer.next != null) {
                slowPointer = slowPointer.next;
                fastPointer = fastPointer.next.next;
                if (fastPointer == slowPointer) {
                    return true;
                }
            }

            return false;
        }
    }
}
