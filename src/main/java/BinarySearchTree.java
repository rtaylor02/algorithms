public class BinarySearchTree {
    private Node root;

    public class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;;
        }
    }

    public Node getRoot() {
        return this.root;
    }

    public boolean insert(int value) {
        Node newNode = new Node(value);
        if (this.root == null) {
            root = newNode;
            return true;
        } else {
            Node temp = root;
            while (true) {
                if (newNode.value < temp.value) {
                    if (temp.left == null) {
                        temp.left = newNode;
                        return true;
                    } else {
                        temp = temp.left;
                    }
                } else if (newNode.value > temp.value) {
                    if (temp.right == null) {
                        temp.right = newNode;
                        return true;
                    } else {
                        temp = temp.right;
                    }
                } else {
                    return false;
                }
            }
        }
    }

    public boolean contains(int value) {
        if (this.root != null) {
            Node temp = root;
            while (temp != null) {
                if (value < temp.value) {
                    temp = temp.left;
                } else if (value > temp.value) {
                    temp = temp.right;
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(10);
        System.out.printf("Root: %d%n", binarySearchTree.getRoot().value);
        //System.out.printf("Left: %d%n", binarySearchTree.getRoot().left.value);
        //System.out.printf("Right: %d%n", binarySearchTree.getRoot().right.value);
        System.out.println("=============");
        binarySearchTree.insert(17);
        System.out.printf("Root: %d%n", binarySearchTree.getRoot().value);
        //System.out.printf("Left: %d%n", binarySearchTree.getRoot().left.value);
        //System.out.printf("Right: %d%n", binarySearchTree.getRoot().right.value);
        System.out.println("=============");
        binarySearchTree.insert(1);
        binarySearchTree.insert(18);
        System.out.printf("Root: %d%n", binarySearchTree.getRoot().value);
        System.out.printf("Left: %d%n", binarySearchTree.getRoot().left.value);
        System.out.printf("Right: %d%n", binarySearchTree.getRoot().right.value);
        System.out.println("=============");

        System.out.printf("Contains 10: %b%n", binarySearchTree.contains(10));
        System.out.printf("Contains 1: %b%n", binarySearchTree.contains(1));
        System.out.printf("Contains 17: %b%n", binarySearchTree.contains(17));
        System.out.printf("Contains 100: %b%n", binarySearchTree.contains(100));
        System.out.printf("Contains 18: %b%n", binarySearchTree.contains(18));
        System.out.printf("Contains 0: %b%n", binarySearchTree.contains(0));
    }
}
