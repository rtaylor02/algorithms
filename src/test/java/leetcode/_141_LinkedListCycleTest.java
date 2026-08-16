package leetcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
https://leetcode.com/problems/linked-list-cycle/

Given head, the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

Return true if there is a cycle in the linked list. Otherwise, return false.


Example 1:

Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).

Example 2:

Input: head = [1,2], pos = 0
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.

Example 3:

Input: head = [1], pos = -1
Output: false
Explanation: There is no cycle in the linked list.


Constraints:

The number of the nodes in the list is in the range [0, 10^4].
-10^5 <= Node.val <= 10^5
pos is -1 or a valid index in the linked-list.
 */

public class _141_LinkedListCycleTest {
    private _141_LinkedListCycle sut = new _141_LinkedListCycle();

    @DisplayName("LinkedList cycle")
    @ParameterizedTest(name = "{0}: {1}")
    @MethodSource("testData")
    void testCases(ListNode head, boolean expected) {
        // ARRANGE, ACT
        boolean actual = sut.hasCycle(head);

        // ASSERT
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> testData() {
        // Test case 1: LinkedList of 3, 2, 0, 4 with cycle back to 2
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;

        // Test case 2: LinkedList of 1, 2 with cycle back to 1
        ListNode node11 = new ListNode(3);
        ListNode node12 = new ListNode(2);
        node11.next = node12;
        node12.next = node11;

        // Test case 3: LinkedList of 1 with no cycle
        ListNode node21 = new ListNode(1);

        return Stream.of(
                Arguments.of(node1, true),
                Arguments.of(node11, true),
                Arguments.of(node21, false)
        );
    }
}
