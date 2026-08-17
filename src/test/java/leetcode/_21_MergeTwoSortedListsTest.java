package leetcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
https://leetcode.com/problems/merge-two-sorted-lists/description/

You are given the heads of two sorted linked lists list1 and list2.
Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
Return the head of the merged linked list.

Example 1:
Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]

Example 2:
Input: list1 = [], list2 = []
Output: []

Example 3:
Input: list1 = [], list2 = [0]
Output: [0]

Constraints:
The number of nodes in both lists is in the range [0, 50].
-100 <= Node.val <= 100
Both list1 and list2 are sorted in non-decreasing order.
 */

public class _21_MergeTwoSortedListsTest {
    private _21_MergeTwoSortedLists sut = new _21_MergeTwoSortedLists();

    @DisplayName("21 Merge 2 Sorted Lists")
    @ParameterizedTest(name = "{0} & {1} => {2}")
    @MethodSource("testData")
    void testIsValid(ListNode list1, ListNode list2, ListNode expected) {
        // ARRANGE - ACT
        ListNode actual = sut.mergeTwoLists(list1, list2);

        // ASSERT
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> testData() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(6);
        ListNode node4 = new ListNode(7);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode node11 = new ListNode(2);
        ListNode node12 = new ListNode(4);
        ListNode node13 = new ListNode(5);
        node11.next = node12;
        node12.next = node13;

        ListNode node21 = new ListNode(1);
        ListNode node22 = new ListNode(2);
        ListNode node23 = new ListNode(4);
        node21.next = node22;
        node22.next = node23;

        ListNode node31 = new ListNode(1);
        ListNode node32 = new ListNode(3);
        ListNode node33 = new ListNode(4);
        node31.next = node32;
        node32.next = node33;

        return Stream.of(
                Arguments.of(node1, node11, node1),
                Arguments.of(node21, node31, node21));
    }
}
