package udemy.scottbarret.javadsa;

public class Section6_LL_Interview_Leetcode_Exercise extends Section5_LinkedList_Coding_Exercises {
    public static class LinkedList extends Section5_LinkedList_Coding_Exercises.LinkedList {
        public LinkedList(int value) {
            super(value);
        }

        public LinkedList(int... values) {
            super(values);
        }

        public LinkedList partitionList(int partitionValue) {
            // Dummy LinkedList to allow partitioning to happen
            LinkedList dummy1_lessThan = new LinkedList(0);
            LinkedList dummy2_greaterThanOrEqualTo = new LinkedList(0);

            // Pointers for all LinkedList
            Node pointer_original = this.getHead();
            Node pointer1_lessThan = dummy1_lessThan.getHead();
            Node pointer2_greaterThanOrEqualTo = dummy2_greaterThanOrEqualTo.getHead();

            // Traverse and assign accordingly
            while (pointer_original != null) {
                if (pointer_original.getValue() < partitionValue) {
                    pointer1_lessThan.setNext(pointer_original);
                    pointer1_lessThan = pointer_original;
                } else if (pointer_original.getValue() >= partitionValue) {
                    pointer2_greaterThanOrEqualTo.setNext(pointer_original);
                    pointer2_greaterThanOrEqualTo = pointer_original;
                }
                pointer_original = pointer_original.getNext();
            }

            pointer1_lessThan.setNext(dummy2_greaterThanOrEqualTo.getHead().getNext()); // Link the 2 partitioned LinkedList
            dummy2_greaterThanOrEqualTo = null;
            pointer2_greaterThanOrEqualTo.setNext(null);
            this.setHead(dummy1_lessThan.getHead().getNext());
            dummy1_lessThan = null;

            return this;
        }
    }
}
