package leetcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

Example 1:
Input: s = "abc", t = "ahbgdc"
Output: true

Example 2:
Input: s = "axc", t = "ahbgdc"
Output: false

Constraints:
0 <= s.length <= 100
0 <= t.length <= 104
s and t consist only of lowercase English letters.
 */

public class _392_IsSubsequenceTest {
    private _392_IsSubsequence sut = new _392_IsSubsequence();

    @DisplayName("Is Subsequence")
    @ParameterizedTest(name = "{0} is subsequence of {1}: {2}")
    @CsvSource({"abc, ahbgdc, true", "axc, ahbgdc, false", "ach, ahbgdc, false", "hcd, ahbgdc, false", "brd, birdy, true"})
    void testIsAnagram(String word1, String word2, boolean expected) {
        // ARRANGE - ACT
        boolean actual = sut.isSubsequence(word1, word2);

        // ASSERT
        assertEquals(expected, actual);
    }
}
