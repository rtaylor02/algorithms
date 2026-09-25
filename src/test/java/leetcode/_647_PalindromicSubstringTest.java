package leetcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Given a string s, return the number of palindromic substrings in it.
A string is a palindrome when it reads the same backward as forward.
A substring is a contiguous sequence of characters within the string.

Example 1:
Input: s = "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".

Example 2:
Input: s = "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".

Constraints:
1 <= s.length <= 1000
s consists of lowercase English letters.
 */
public class _647_PalindromicSubstringTest {
    private _647_PalindromicSubstring sut = new _647_PalindromicSubstring();

    @DisplayName("Total palindromic substrings")
    @ParameterizedTest(name = "Total palindromic substrings in {0}: {1}")
    @CsvSource({"abc, 3", "aaa, 6", "aabaaca, 12"})
    void testCountSubstrings(String s, int expected) {
        // ARRANGE - ACT
        int actual = sut.countSubstring(s);

        // ASSERT
        assertEquals(expected, actual);
    }
}
