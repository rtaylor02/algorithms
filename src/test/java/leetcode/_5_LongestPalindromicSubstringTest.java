package leetcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*

 */
public class _5_LongestPalindromicSubstringTest {
    private _5_LongestPalindromicSubstring sut = new _5_LongestPalindromicSubstring();

    @DisplayName("Longest palindromic substring")
    @ParameterizedTest(name = "Longest palindromic substring in {0}: {1}")
    @CsvSource({"babad, bab", "cbbd, bb"})
    void testLongestPalindrome(String s, String expected) {
        // ARRANGE - ACT
        String actual = sut.longestPalindrome(s);

        // ASSERT
        assertEquals(expected, actual);
    }
}
