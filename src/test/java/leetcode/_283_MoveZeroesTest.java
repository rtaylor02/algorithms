package leetcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
Note that you must do this in-place without making a copy of the array.

Example 1:
Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]

Example 2:
Input: nums = [0]
Output: [0]

Constraints:
1 <= nums.length <= 10^4
-2^31 <= nums[i] <= 2^31 - 1
 */

public class _283_MoveZeroesTest {
    private _283_MoveZeroes sut = new _283_MoveZeroes();

    @DisplayName("Move Zeroes")
    @ParameterizedTest(name = "{0} ==> {1}")
    @MethodSource("testData")
    void testIsValid(int[] nums, int[] expected) {
        sut.moveZeroes(nums);

        // ASSERT
        assertArrayEquals(expected, nums);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{0, 1, 0, 3, 12}, new int[]{1, 3, 12, 0, 0}),
                Arguments.of(new int[]{1, 3, 0, 4, 5}, new int[]{1, 3, 4, 5, 0}),
                Arguments.of(new int[]{0}, new int[]{0})
        );
    }
}
