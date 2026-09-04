package leetcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Given a positive integer n, write a function that returns the number of set bits in its binary representation (also known as the Hamming weight).

Example 1:
Input: n = 11
Output: 3
Explanation:
The input binary string 1011 has a total of three set bits.

Example 2:
Input: n = 128
Output: 1
Explanation:
The input binary string 10000000 has a total of one set bit.

Example 3:
Input: n = 2147483645
Output: 30
Explanation:
The input binary string 1111111111111111111111111111101 has a total of thirty set bits.
 */
public class _191_NumberOf1BitsTest {
    private _191_NumberOf1Bits sut = new _191_NumberOf1Bits();

    @DisplayName("Number of 1 bits")
    @ParameterizedTest(name = "Total bit 1 in {0}: {1}")
    @CsvSource({"11, 3", "128, 1", "2147483645, 30", "157, 5"})
    void testHammingWeight(int n, int expected) {
        // ARRANGE - ACT
        int actual = sut.hammingWeight2(n);

        // ASSERT
        assertEquals(expected, actual);
    }
}
