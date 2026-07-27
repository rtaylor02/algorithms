package leetcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class _206_ReversedLinkedListTest {
    private _206_ReversedLinkedList sut = new _206_ReversedLinkedList();

    @DisplayName("Reversed LinkedLIst")
    @Test()
    void testMajorityElement() {
        // ARRANGE
        _206_ReversedLinkedList.LinkedList linkedList = new _206_ReversedLinkedList.LinkedList(1, 2, 3, 4);
        ListNode oldTail = linkedList.tail;

        // ACT
        ListNode newHead = sut.reverseLinkedList(linkedList.head);

        // ASSERT
        assertEquals(oldTail, newHead); // Old tail has now become new head
    }
}
