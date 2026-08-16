package leetcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/*
https://leetcode.com/problems/two-sum/description/

You are given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.



Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]

Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]


Constraints:

2 <= nums.length <= 10^4
-10^9 <= nums[i] <= 10^9
-10^9 <= target <= 10^9
Only one valid answer exists.
 */

class _1_TwoSumTest {
    private final _1_TwoSum sut = new _1_TwoSum();

    private static Stream<Arguments> argsSource_findTwoSums() {
        return Stream.of(
                Arguments.of(new int[]{2, 7, 11, 15}, 9, new int[]{0, 1}),
                Arguments.of(new int[]{3, 2, 4}, 6, new int[]{1, 2}),
                Arguments.of(new int[]{3, 1, 7, 9, 4}, 6, new int[]{}),
                Arguments.of(new int[]{3, 3}, 6, new int[]{0, 1})
        );
    }

    @DisplayName("Testing scenarios")
    @ParameterizedTest(name = "Target of {1} from {0}: {2}")
    @MethodSource("argsSource_findTwoSums")
    void testCases(int[] nums, int target, int[] expected) {
        // ARRANGE - ACT
        int[] result = sut.twoSum(nums, target);
        // Sort both result and expected arrays so they can be compared
        Arrays.sort(result);
        Arrays.sort(expected);

        // ASSERT
        assertArrayEquals(expected, result);
    }
}