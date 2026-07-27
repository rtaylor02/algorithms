package oreilly.liveevents.rohitbhardwaj.algorithms.arrays;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestSubstringSlidingWindowTest {
    private LongestSubstringSlidingWindow sut = new LongestSubstringSlidingWindow();

    @ParameterizedTest
    @CsvSource({
            "abcabcbb, 3",
            "bbbbb, 1",
            "pwwkew, 3",
            "a, 1", // Edge case: string only 1 character
            ",0", // Edge case: null
            "'',0", // Edge case: empty string
    })
    void findLongestSubstring(String input, int expectedLongestSubstring) {
        // ARRANGE - ACT
        int result = sut.findLongestSubstring(input);

        // ASSERT
        assertEquals(expectedLongestSubstring, result);
    }
}
