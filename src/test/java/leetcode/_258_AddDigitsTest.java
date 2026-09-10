package leetcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Given an integer num, repeatedly add all its digits until the result has only one digit, and return it.

Example 1:
Input: num = 38
Output: 2
Explanation: The process is
38 --> 3 + 8 --> 11
11 --> 1 + 1 --> 2
Since 2 has only one digit, return it.

Example 2:
Input: num = 0
Output: 0

Constraints:
0 <= num <= 231 - 1
 */

public class _258_AddDigitsTest {
    private _258_AddDigits sut = new _258_AddDigits();

    @DisplayName("Add Digits")
    @ParameterizedTest(name = "{0}: total digits ==> {1}")
    @CsvSource({"38, 2", "0, 0", "123, 6", "99, 9"})
    void testIsValid(int num, int expected) {
        // ARRANGE - ACT
        int actual = sut.addDigits(num);

        // ASSERT
        assertEquals(expected, actual);
    }
}
