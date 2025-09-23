public class Queue {
    private Node first;
    private Node last;
    int length;

    public Queue(int value) {
        first = new Node(value);
        last = first;
        length = 1;
    }

    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public void enqueue(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
            newNode = null;
        }
        length++;
    }

    Node dequeue() {
        if (length == 0) {
            return null;
        } else if (length == 1) {
            Node temp = first;
            first = last = null;
            length = 0;

            return temp;
        } else {
            Node temp = first;
            first = first.next;
            temp.next = null;
            length--;

            return temp;
        }
    }

    Node getFirst() {
        return first;
    }

    Node getLast() {
        return last;
    }

    public int getLength() {
        return length;
    }

    public void printList() {
        Node temp = first;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void printAll() {
        if (length == 0) {
            System.out.println("First: null");
            System.out.println("Last: null");
        } else {
            System.out.println("First: " + first.value);
            System.out.println("Last: " + last.value);
        }

        System.out.println("Length: " + length);
        System.out.println("\nQueue: ");
        if (length == 0) {
            System.out.println("\tEmpty");
        } else {
            printList();
        }
    }

    public static void main(String[] args) {
        Queue queue = new Queue(10);

        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);

        //queue.dequeue();
        //queue.dequeue();
        //queue.dequeue();
        //queue.dequeue();

        queue.printAll();
    }
}
