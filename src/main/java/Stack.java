public class Stack {
    private int height; // Keeps track of the number of nodes in the stack
    private Node top; // Points to the top node of the stack

    // Create a Node class to represent individual nodes in the stack
    private static class Node {
        int value; // Value of the node
        Node next; // Reference to the next node in the stack

        // Constructor to create a new node with the given value
        private Node(int value) {
            this.value = value;
        }
    }

    // Constructor to create a new stack with the given value as the top element
    public Stack(int value) {
        top = new Node(value); // Create a new node with the given value and set it as the top of the stack
        height = 1; // Set the initial height of the stack to 1
    }

    public int getHeight() {
        return height;
    }

    public Node getTop() {
        return top;
    }

    public void push(int value) {
        Stack.Node newNode = new Stack.Node(value);
        newNode.next = top;
        top = newNode;
        height++;
    }

    public Node pop() {
        if (height == 0) {
            return null;
        } else {
            Node temp = top;
            top = top.next;
            temp.next = null;
            height--;

            return temp;
        }
    }

    public void printStack() {
        Node temp = top;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void printAll() {
        if (height == 0) {
            System.out.println("Top: null");
        } else {
            System.out.println("Top: " + top.value);
        }
        System.out.println("Height: " + height);
        System.out.println("\nStack: ");
        if (height == 0) {
            System.out.println("Empty");
        } else {
            printStack();
        }
    }

    public void makeEmpty() {
        top = null;
        height = 0;
    }

    public static void main(String[] args) {
        Stack stack = new Stack(10);
        stack.push(3);
        stack.push(5);
        stack.push(7);
        //stack.printStack();
        stack.printAll();

        System.out.println("==============");

        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.printAll();
    }
}
