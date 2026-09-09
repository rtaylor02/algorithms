package genzcareer.codinginterview.java;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.junit.jupiter.api.Assertions.*;
@DisplayName("All tests in GenZ Career interview prep: Common Step - Java Coding")
class MainTest {
    @DisplayName("Q1")
    @Nested
    class Q1 {
        private Main.Q1 sut = new Main.Q1();

        @DisplayName("Reverse a String without String.reverse()")
        @ParameterizedTest(name = "{0} ==> {1}")
        @CsvSource({"abc, cba"})
        void testReverseString(String input, String expected) {
            String actual = sut.reverseString(input);

            assertEquals(expected, actual);
        }
    }
}