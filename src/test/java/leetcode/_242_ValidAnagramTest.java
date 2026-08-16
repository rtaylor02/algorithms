package leetcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
https://leetcode.com/problems/valid-anagram/description/

Given two strings s and t, return true if t is an anagram of s, and false otherwise.

Example 1:
Input: s = "anagram", t = "nagaram"
Output: true

Example 2:
Input: s = "rat", t = "car"
Output: false

Constraints:
1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.
 */

public class _242_ValidAnagramTest {
    private _242_ValidAnagram sut = new _242_ValidAnagram();

    @DisplayName("Valid Anagrams")
    @ParameterizedTest(name = "{0} and {1} are anagrams: {2}")
    @CsvSource({"anagram, nagaram, true", "rat, car, false", "grab, brag, true", "mug, guns, false", "ggii, eekk, false"})
    void testIsAnagram(String word1, String word2, boolean expected) {
        // ARRANGE - ACT
        boolean actual = sut.isValidAnagram2(word1, word2);

        // ASSERT
        assertEquals(expected, actual);
    }
}
