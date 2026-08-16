package leetcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static java.util.stream.Stream.of;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class _509_FibonacciTest {
    /**
     * GIVEN scenario 1
     * WHEN
     * THEN a result comes out
     */
    private Fibonacci sut = new Fibonacci();

    @DisplayName("Fibonacci number")
    @ParameterizedTest(name = "Fibonacci number of {0}: {1}")
    @CsvSource({"0, 0", "1, 1", "2, 1", "3, 2", "4, 3", "5, 5", "6, 8", "7, 13", "8, 21"})
    void testIsValid(int n, int expected) {
        // ARRANGE - ACT
        int actual = sut.fib(n);

        // ASSERT
        assertEquals(expected, actual);
    }

}
