package leetcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class _53_MaximumSubarrayTest {
    private _53_MaximumSubarray sut = new _53_MaximumSubarray();

    @DisplayName("Maximum Subarray")
    @ParameterizedTest(name = "Max subarray of {0}: {1}")
    @MethodSource("testData")
    void testCases(int[] nums, int expected) {
        // ARRANGE - ACT
        int actual = sut.maxSubArray(nums);

        // ASSERT
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}, 6),
                Arguments.of(new int[]{1}, 1),
                Arguments.of(new int[]{5, 4, -1, 7, 8}, 23)
        );
    }
}
