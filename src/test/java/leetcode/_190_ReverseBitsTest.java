package leetcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Reverse bits of a given 32 bits signed integer.



Example 1:

Input: n = 43261596

Output: 964176192

Explanation:

Integer	Binary
43261596	00000010100101000001111010011100
964176192	00111001011110000010100101000000
Example 2:

Input: n = 2147483644

Output: 1073741822

Explanation:

Integer	Binary
2147483644	01111111111111111111111111111100
1073741822	00111111111111111111111111111110


Constraints:

0 <= n <= 231 - 2
n is even.
 */
public class _190_ReverseBitsTest {
    private _190_ReverseBits sut = new _190_ReverseBits();

    @DisplayName("Reverse bits")
    @ParameterizedTest(name = "Reverse bits of {0}: {1}")
    @CsvSource({"43261596, 964176192", "2147483644, 1073741822"})
    void testHammingWeight(int n, int expected) {
        // ARRANGE - ACT
        int actual = sut.reverseBits(n);

        // ASSERT
        assertEquals(expected, actual);
    }
}
