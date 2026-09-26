package leetcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Given a string s, return the longest palindromic substring in s.

Example 1:
Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.

Example 2:
Input: s = "cbbd"
Output: "bb"

Constraints:
1 <= s.length <= 1000
s consist of only digits and English letters.
 */
public class _5_LongestPalindromicSubstringTest {
    private _5_LongestPalindromicSubstring sut = new _5_LongestPalindromicSubstring();

    @DisplayName("Longest palindromic substring")
    @ParameterizedTest(name = "Longest palindromic substring in {0}: {1}")
    @CsvSource({"babad, aba", "cbbd, bb", "aabaaca, aabaa", "aaa, aaa"})
    void testLongestPalindrome(String s, String expected) {
        // ARRANGE - ACT
        String actual = sut.longestPalindrome(s);

        // ASSERT
        assertEquals(expected, actual);
    }
}
