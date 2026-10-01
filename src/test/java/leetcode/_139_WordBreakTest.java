package leetcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.
Note that the same word in the dictionary may be reused multiple times in the segmentation.

Example 1:
Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".

Example 2:
Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
Note that you are allowed to reuse a dictionary word.

Example 3:
Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false

Constraints:
1 <= s.length <= 300
1 <= wordDict.length <= 1000
1 <= wordDict[i].length <= 20
s and wordDict[i] consist of only lowercase English letters.
All the strings of wordDict are unique.
 */
public class _139_WordBreakTest {
    private _139_WordBreak sut = new _139_WordBreak();

    @DisplayName("Word Break")
    @ParameterizedTest(name = "{0} can be segmented from dictionary {1}: {2}")
    @MethodSource("testData")
    void testCases(String s, List<String> wordDict, boolean expected) {
        // ARRANGE - ACT
        boolean actual = sut.wordBreak(s, wordDict);

        // ASSERT
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("leetcode", List.of("leet", "code"), true),
                Arguments.of("applepenapple", List.of("apple", "pen"), true),
                Arguments.of("unwiredlearning", List.of("unwired", "learning"), true),
                Arguments.of("catsanddog", List.of("cats", "dog", "sand", "and", "cat"), true),
                Arguments.of("catsandog", List.of("og", "sand", "and", "cat"), true),
                Arguments.of("cars", List.of("car", "ca", "rs"), true),
                Arguments.of("catsandog", List.of("cats", "dog", "sand", "and", "cat"), false)
        );
    }
}
