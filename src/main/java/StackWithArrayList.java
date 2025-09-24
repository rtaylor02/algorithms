import java.util.ArrayList;
import java.util.NoSuchElementException;

/*
The implementation of stack using ArrayList
 */
public class StackWithArrayList {
    static class Stack<T> {
        private ArrayList<T> list = new ArrayList<>();

        int size() {
            return list.size();
        }

        boolean isEmpty() {
            return list.isEmpty();
        }

        T push(T element) {
            list.add(element);
            return element;
        }

        T pop() {
            return list.isEmpty() ? null : list.remove(list.size() - 1);
        }

        T peek() {
            return list.isEmpty() ? null : list.get(list.size() - 1);
        }

        void printStack() {
            System.out.printf("Size: %d%n", list.size());
            System.out.println("Stack:");
            if (list.isEmpty()) {
                System.out.println("\tEmpty");
            } else {
                for (int i = list.size() - 1; i >= 0; i--) {
                    System.out.println("\t" + list.get(i));
                }
            }
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        stack.printStack();

        System.out.println("===========");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
