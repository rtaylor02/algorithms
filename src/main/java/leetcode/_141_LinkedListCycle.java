package leetcode;

public class _141_LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        ListNode hare = head;
        ListNode tortoise = head;

        while ((hare != null) && (hare.next != null)) { // Check next too to avoid NullPointerException on the next move
            hare = hare.next.next; // Hare moves 2 steps
            tortoise = tortoise.next; // Tortoise moves 1 step

            if (hare == tortoise) {
                return true;
            }
        }

        return false;
    }
}
