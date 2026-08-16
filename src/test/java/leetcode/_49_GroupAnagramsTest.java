package leetcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/*
https://leetcode.com/problems/group-anagrams/description/

Given an array of strings strs, group the anagrams together. You can return the answer in any order.

Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
Explanation:
There is no string in strs that can be rearranged to form "bat".
The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.

Example 2:

Input: strs = [""]
Output: [[""]]

Example 3:

Input: strs = ["a"]
Output: [["a"]]


Constraints:
1 <= strs.length <= 104
0 <= strs[i].length <= 100
strs[i] consists of lowercase English letters.
 */

public class _49_GroupAnagramsTest {
    private GroupAnagram sut = new GroupAnagram();

    @DisplayName("Group Anagram")
    @ParameterizedTest(name = "{0} ==> {1}")
    @MethodSource("testData")
    void testCases(String[] strings, List<List<String>> expected) {
        // ARRANGE, ACT
        List<List<String>> actual = sut.getGroupAnagram_Answer(strings);

        // ASSERT
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new String[]{"eat","tea","tan","ate","nat","bat"}, List.of(List.of("bat"), List.of("tan", "nat"), List.of("ate", "eat", "tea"))),
                Arguments.of(new String[]{"a"}, List.of(List.of("a"))),
                Arguments.of(new String[]{"bdddddddddd","bbbbbbbbbbc"}, List.of(List.of("bbbbbbbbbbc"), List.of("bdddddddddd"))),
                Arguments.of(new String[]{""}, List.of(List.of("")))
        );
    }
}
