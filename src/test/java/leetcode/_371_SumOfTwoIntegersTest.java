package leetcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Given two integers a and b, return the sum of the two integers without using the operators + and -.

Example 1:
Input: a = 1, b = 2
Output: 3

Example 2:
Input: a = 2, b = 3
Output: 5

Constraints:
-1000 <= a, b <= 1000
 */
public class _371_SumOfTwoIntegersTest {
    private _371_SumOfTwoIntegers sut = new _371_SumOfTwoIntegers();

    @DisplayName("Sum of 2 Integers")
    @ParameterizedTest(name = "Sum of {0} and {1} = {2}")
    @CsvSource({"2, 3, 5", "3, 6, 9"})
    void testHammingWeight(int a, int b, int expected) {
        // ARRANGE - ACT
        int actual = sut.getSum(a, b);

        // ASSERT
        assertEquals(expected, actual);
    }
}
