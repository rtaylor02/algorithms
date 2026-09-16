package genzcareer.codinginterview.java;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
@DisplayName("All tests in GenZ Career interview prep: Common Step - Java Coding")
class MainTest {
    @DisplayName("Q1:")
    @Nested
    class Q1 {
        private Main.Q1 sut = new Main.Q1();

        @DisplayName("Write a Java Program to reverse a string without using String inbuilt function, e.g. StringBuilder's reverse()")
        @ParameterizedTest(name = "{0} ==> {1}")
        @CsvSource({"abc, cba", "thisNOTthat, tahtTONsiht"})
        void testReverseString(String input, String expected) {
            // ARRANGE - ACT
            String actual = sut.reverseString(input);

            // ASSERT
            assertEquals(expected, actual);
        }
    }

    @DisplayName("Q2:")
    @Nested
    class Q2 {
        private Main.Q2 sut = new Main.Q2();

        @DisplayName("Write a Java Program to swap two numbers without using the third variable.")
        @ParameterizedTest(name = "Before swapping: a = {0}, b = {1}. After swapping: a = {2}, b = {3}")
        @CsvSource({"1, 2, 2, 1", "21, 3, 3, 21"})
        void testSwapNumbers(int a, int b, int a_, int b_) {
            // ARRANGE - ACT
            sut.swapNumbers(a, b);

            // ASSERT
            assertEquals(a, b_);
            assertEquals(b, a_);
        }
    }

    @DisplayName("Q3:")
    @Nested
    class Q3 {
        private Main.Q3 sut = new Main.Q3();

        @DisplayName("Write a Java Program to count the number of words in a string using HashMap.")
        @ParameterizedTest(name = "Word counts: {1}")
        @MethodSource("testData")
        void testCountWords(String input, Map<String, Integer> expected) {
            // ARRANGE - ACT
            Map<String, Integer> actual = sut.countWords(input);

            // ASSERT
            assertEquals(expected, actual);
        }

        private static Stream<Arguments> testData() {
            return Stream.of(
                    Arguments.of("Hello there", Map.of("Hello", 1, "there", 1)),
                    Arguments.of("you you you", Map.of("you", 3)),
                    Arguments.of("", Map.of("", 1)),
                    Arguments.of("How are you?", Map.of("How", 1, "are", 1, "you?", 1))
            );
        }
    }

    @DisplayName("Q4:")
    @Nested
    class Q4 {
        private Main.Q4 sut = new Main.Q4();

        //@DisplayName("Write a Java Program to iterate HashMap using While and advance for loop.")
        @ParameterizedTest(name = "{0}")
        @MethodSource("testData")
        void testIterateHashMap(Map<String, String> map) {
            // ARRANGE - ACT
            sut.iterateHashMap(map);

            // ASSERT - No assertion needed
        }


        private static Stream<Arguments> testData() {
            return Stream.of(
                    Arguments.of(Map.of("1", "Hello", "2", "World")),
                    Arguments.of(Map.of("1", "One", "2", "Two"))
            );
        }
    }



}