package leetcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;


/*
Source: LeetCode problem #125
==============================

A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
Given a string s, return true if it is a palindrome, or false otherwise.

Example 1:
Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.

Example 2:
Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.

Example 3:
Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.

Constraints:
1 <= s.length <= 2 * 105
s consists only of printable ASCII characters.
 */

public class _125_ValidPalindromeTest {
    private _125_ValidPalindrome sut = new _125_ValidPalindrome();

    @DisplayName("Testing A palindrome")
    @ParameterizedTest(name = "{0} is palindrome: {1}")
    @CsvSource(delimiter = '|', textBlock = """
        A man, a plan, a canal: Panama | true
        race a car | false
        21_manam_12 | true
        """)
    void isPalindromeTest(String s, boolean expected) {
        // ARRANGE - ACT
        boolean actual = sut.isPalindrome(s);

        // ASSERT
        assertEquals(expected, actual);
    }

    @DisplayName("Testing A palindrome")
    @Test
    void testActualPalindrome() {
        // ARRANGE - ACT
        boolean actual = sut.isPalindrome("A man, a plan, a canal: Panama");

        // ASSERT
        assertTrue(actual);
    }

    @DisplayName("Testing NOT a palindrome")
    @Test
    void testNonPalindrome() {
        // ARRANGE - ACT
        boolean actual = sut.isPalindrome("race a car");

        // ASSERT
        assertFalse(actual);
    }

    @DisplayName("Space / empty string is palindrome")
    @Test
    void testSpace() {
        // ARRANGE - ACT
        boolean actual = sut.isPalindrome(" ");

        // ASSERT
        assertTrue(actual);
    }

    @DisplayName("Testing Alphanumeric palindrome")
    @Test
    void testAlphanumericPalindrome() {
        // ARRANGE - ACT
        boolean actual = sut.isPalindrome("21_manam_12");

        // ASSERT
        assertTrue(actual);
    }
}
