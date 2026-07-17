package udemy.scottbarret.javadsa;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Section6_LL_Interview_Leetcode_ExerciseTest {
    @Test
    @DisplayName("Appending linked list from non-empty list")
    void testAppend() {
        // ARRANGE - ACT
        Section6_LL_Interview_Leetcode_Exercise.LinkedList sut = new Section6_LL_Interview_Leetcode_Exercise.LinkedList(1);
        sut.append(2);
        List<Integer> actual = sut.asList();

        // ASSERT
        assertIterableEquals(List.of(1, 2), actual);
    }

    @Test
    @DisplayName("Appending linked list from empty list")
    void testAppendFromEmptyLinkedList() {
        // ARRANGE
        Section6_LL_Interview_Leetcode_Exercise.LinkedList sut = new Section6_LL_Interview_Leetcode_Exercise.LinkedList(1);
        sut.makeEmpty();

        // ACT
        sut.append(100);
        List<Integer> actual = sut.asList();

        // ASSERT
        assertIterableEquals(List.of(100), actual);
    }


    @ParameterizedTest
    @MethodSource("argSource_createList")
    void testFindMiddleNode(int totalMembersOfLinkedList, int expected) {
        // ARRANGE
        Section6_LL_Interview_Leetcode_Exercise.LinkedList sut = createList(totalMembersOfLinkedList, false);

        // ACT
        Section6_LL_Interview_Leetcode_Exercise.LinkedList.Node middleNode = sut.findMiddleNode();
        int middleNodeValue = middleNode.getValue();

        // ASSERT
        assertEquals(expected, middleNodeValue);
    }

    private static Stream<Arguments> argSource_createList() {
        return Stream.of(
                Arguments.of(7, 4),
                Arguments.of(4, 3)
        );
    }

    private static Section6_LL_Interview_Leetcode_Exercise.LinkedList createList(int totalMembers, boolean cyclic) {
        Section6_LL_Interview_Leetcode_Exercise.LinkedList list = new Section6_LL_Interview_Leetcode_Exercise.LinkedList(1);
        if (totalMembers >= 0) {
            for (int i = 1; i < totalMembers; i++) {
                list.append(i + 1); // The first Node was initialised with 1, so the next nodes should be 2, 3, 4, ...
            }
        }

        if (cyclic) {
            list.getTail().setNext(list.getHead());
        }

        return list;
    }

    @ParameterizedTest
    @MethodSource("argSource_hasLoop")
    void testHasLoop(Section6_LL_Interview_Leetcode_Exercise.LinkedList list, boolean expected) {
        // ACT
        boolean actual = list.hasLoop();

        // ASSERT
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> argSource_hasLoop() {
        return Stream.of(
                Arguments.of(createList(5, false), false),
                Arguments.of(createList(5, true), true)
        );
    }

    @ParameterizedTest
    @MethodSource("argSource_findKthNode")
    void testFindKthNode(Section6_LL_Interview_Leetcode_Exercise.LinkedList list, int k, int expected) {
        // ARRANGE - ACT
        Section6_LL_Interview_Leetcode_Exercise.LinkedList.Node kthNode = list.findKthNode(k);
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

    @ParameterizedTest
    @MethodSource("argSource_findKthNode_whenInputIsZeroOrOutOfRange")
    void testFindKthNode_whenInputIsZeroOrOutOfRange(Section6_LL_Interview_Leetcode_Exercise.LinkedList list, int k, Object expected) {
        // ARRANGE - ACT
        Section6_LL_Interview_Leetcode_Exercise.LinkedList.Node kthNode = list.findKthNode(k);

        // ASSERT
        assertEquals(expected, kthNode);
    }

    private static Stream<Arguments> argSource_findKthNode_whenInputIsZeroOrOutOfRange() {
        return Stream.of(
                Arguments.of(createList(3, false), 0, null),
                Arguments.of(createList(3, false), 6, null)
        );
    }



}