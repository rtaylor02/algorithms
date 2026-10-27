package udemy.scottbarret.javadsa;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class Section5_LinkedList_Coding_Exercises_Test {
    @Test
    @DisplayName("Appending linked list from non-empty list")
    void testAppend() {
        // ARRANGE - ACT
        var sut = new Section5_LinkedList_Coding_Exercises.LinkedList(1);
        sut.append(2);
        List<Integer> actual = sut.asList();

        // ASSERT
        assertIterableEquals(List.of(1, 2), actual);
    }

    @Test
    @DisplayName("Appending linked list from empty list")
    void testAppendFromEmptyLinkedList() {
        // ARRANGE
        var sut = new Section5_LinkedList_Coding_Exercises.LinkedList(1);
        sut.makeEmpty();

        // ACT
        sut.append(100);
        List<Integer> actual = sut.asList();

        // ASSERT
        assertIterableEquals(List.of(100), actual);
    }
}