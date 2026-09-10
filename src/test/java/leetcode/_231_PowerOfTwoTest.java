package leetcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Given an integer n, return true if it is a power of two. Otherwise, return false.
An integer n is a power of two, if there exists an integer x such that n == 2x.

Example 1:
Input: n = 1
Output: true
Explanation: 20 = 1

Example 2:
Input: n = 16
Output: true
Explanation: 24 = 16

Example 3:
Input: n = 3
Output: false

Constraints:
-2^31 <= n <= 2^(31 - 1)
 */

public class _231_PowerOfTwoTest {
    private _231_PowerOfTwo sut = new _231_PowerOfTwo();

    @DisplayName("Power of 2")
    @ParameterizedTest(name = "{0} is a power of 2: {1}")
    @CsvSource({"1, true", "16, true", "3, false"})
    void testIsValid(int n, boolean expected) {
        // ARRANGE - ACT
        boolean actual = sut.isPowerOfTwo(n);

        // ASSERT
        assertEquals(expected, actual);
    }
}
