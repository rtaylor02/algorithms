package genzcareer.codinginterview.java;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

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

}