package udemy.scottbarret.javadsa;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Section6_LL_Interview_Leetcode_Exercise_Test {
    @DisplayName("Find middle node")
    @ParameterizedTest
    @MethodSource("argSource_createList")
    //@CsvSource({"7, 4", "4, 3"})
    void testFindMiddleNode(Section6_LL_Interview_Leetcode_Exercise.LinkedList sut, int expected) {
        // ARRANGE - ACT
        Section6_LL_Interview_Leetcode_Exercise.LinkedList.Node middleNode = sut.findMiddleNode();
        int middleNodeValue = middleNode.getValue();

        // ASSERT
        assertEquals(expected, middleNodeValue);
    }

    private static Stream<Arguments> argSource_createList() {
        return Stream.of(
                Arguments.of(createList(7, false), 4),
                Arguments.of(createList(4, false), 3)
        );
    }

    private static Section6_LL_Interview_Leetcode_Exercise.LinkedList createList(int totalMembers, boolean cyclic) {
        int[] values = new int[totalMembers];
        for (int i = 1; i <= totalMembers; i++) {
            values[i - 1] = i;
        }
        Section6_LL_Interview_Leetcode_Exercise.LinkedList list = new Section6_LL_Interview_Leetcode_Exercise.LinkedList(values);

        if (cyclic) {
            list.getTail().setNext(list.getHead());
        }

        return list;
    }

    @ParameterizedTest
    @MethodSource("argSource_hasLoop")
    void testHasLoop(Section6_LL_Interview_Leetcode_Exercise.LinkedList sut, boolean expected) {
        // ACT
        boolean actual = sut.hasLoop();

        // ASSERT
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> argSource_hasLoop() {
        return Stream.of(
                Arguments.of(createList(5, false), false),
                Arguments.of(createList(5, true), true)
        );
    }

    @DisplayName("Find Kth Node")
    @ParameterizedTest
    @MethodSource("argSource_findKthNode")
    void testFindKthNode(Section6_LL_Interview_Leetcode_Exercise.LinkedList sut, int k, int expected) {
        // ARRANGE - ACT
        Section6_LL_Interview_Leetcode_Exercise.LinkedList.Node kthNode = sut.findKthNode(k);
        int actual = kthNode.getValue();

        // ASSERT
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> argSource_findKthNode() {
        return Stream.of(
                Arguments.of(createList(5, false), 3, 3),
                Arguments.of(createList(6, false), 2, 5)
        );
    }

    @DisplayName("Find Kth Node")
    @ParameterizedTest
    @MethodSource("argSource_findKthNode_whenInputIsZeroOrOutOfRange")
    void testFindKthNode_whenInputIsZeroOrOutOfRange(Section6_LL_Interview_Leetcode_Exercise.LinkedList sut, int k, Object expected) {
        // ARRANGE - ACT
        Section6_LL_Interview_Leetcode_Exercise.LinkedList.Node kthNode = sut.findKthNode(k);

        // ASSERT
        assertEquals(expected, kthNode);
    }

    private static Stream<Arguments> argSource_findKthNode_whenInputIsZeroOrOutOfRange() {
        return Stream.of(
                Arguments.of(createList(3, false), 0, null),
                Arguments.of(createList(3, false), 6, null)
        );
    }

    @DisplayName("Remove duplicates")
    @ParameterizedTest(name = "{1} ==> {0}")
    @MethodSource("argSource_removeDuplicates")
    void testRemoveDuplicates(List<Integer> expected, int... values) {
        // ARRANGE
        Section6_LL_Interview_Leetcode_Exercise.LinkedList sut = new Section6_LL_Interview_Leetcode_Exercise.LinkedList(values);

        // ACT
        sut.removeDuplicates();

        // ASSERT
        assertIterableEquals(expected, sut.asList());
    }

    private static Stream<Arguments> argSource_removeDuplicates() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5), new int[]{1, 2, 3, 1, 4, 2, 5}), // Duplicates at several places
                Arguments.of(List.of(1, 2, 3, 4), new int[]{1, 2, 3, 4, 1}), // Start & end duplicates
                Arguments.of(List.of(1, 2, 3, 4, 5), new int[]{1, 2, 3, 3, 4, 5}), // Middle duplicates
                Arguments.of(List.of(1, 2, 3, 4, 5), new int[]{1, 2, 3, 4, 5}), // No duplicates
                Arguments.of(List.of(1), new int[]{1}), // Single node
                Arguments.of(List.of(1), new int[]{1, 1, 1}) // All duplicates
        );
    }

    @DisplayName("Binary to Decimal")
    @ParameterizedTest(name = "{0} ==> {1}")
    @MethodSource("argSource_binaryLinkedList")
    void testBinaryToDecimal(Section5_LinkedList_Coding_Exercises.LinkedList sut, int expected) {
        // ARRANGE - ACT - ASSERT
        assertEquals(expected, sut.binaryToDecimal());
    }

    private static Stream<Arguments> argSource_binaryLinkedList() {
        return Stream.of(
                Arguments.of(createBinaryLinkedList("111"), 7),
                Arguments.of(createBinaryLinkedList("000"), 0),
                Arguments.of(createBinaryLinkedList("1000"), 8)
        );
    }

    private static Section5_LinkedList_Coding_Exercises.LinkedList createBinaryLinkedList(String binaryNumberInString) {
        Section5_LinkedList_Coding_Exercises.LinkedList linkedList = null;

        for (int i = 0; i < binaryNumberInString.length(); i++) {
            if (linkedList == null) {
                linkedList = new Section5_LinkedList_Coding_Exercises.LinkedList(binaryNumberInString.charAt(i) - '0');
            } else {
                linkedList.append(binaryNumberInString.charAt(i) - '0');
            }
        }

        return linkedList;
    }
}