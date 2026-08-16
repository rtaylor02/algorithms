package leetcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
https://www.geeksforgeeks.org/dsa/length-of-the-longest-substring-without-repeating-characters/

Given a string s having lowercase characters, find the length of the longest substring without repeating characters.

Examples:

Input: s = "geeksforgeeks"
Output: 7
Explanation: The longest substrings without repeating characters are "eksforg” and "ksforge", with lengths of 7.

Input: s = "aaa"
Output: 1
Explanation: The longest substring without repeating characters is "a"

Input: s = "abcdefabcbb"
Output: 6
Explanation: The longest substring without repeating characters is "abcdef".

Input: s = "pwwkew"
Output: 3
Explanation: The longest substring without repeating characters are "wke" and "kew".

Input: s = "abcde"
Output: 5
Explanation: The longest substring without repeating characters is "abcde".
 */

public class _3_LongestSubstringWithoutRepeatingCharactersTest {
    private _3_LongestSubstringWithoutRepeatingCharacters sut = new _3_LongestSubstringWithoutRepeatingCharacters();

    @DisplayName("Longest substring without repeating characters")
    @ParameterizedTest(name = "{0} ==> {1}")
    @CsvSource({"geeksforgeeks, 7", "aaa, 1", "abcdefabcbb, 6", "pwwkew, 3", "abcde, 5"})
    void testCases(String testCase, int expected) {
        // ARRANGE, ACT
        int actual = sut.getLongestSubstringWithoutRepeatingCharacters(testCase);

        // ASSERT
        assertEquals(expected, actual);
    }
}
