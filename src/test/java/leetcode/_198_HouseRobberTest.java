package leetcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/*
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

Example 1:
Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.

Example 2:
Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.
 */

class _198_HouseRobberTest {
    private final _198_HouseRobber sut = new _198_HouseRobber();

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 1}, 4),
                Arguments.of(new int[]{2, 1, 1, 2}, 4),
                Arguments.of(new int[]{3, 6, 2, 1, 5, 1, 2, 9}, 20),
                Arguments.of(new int[]{0}, 0),
                Arguments.of(new int[]{2, 7, 9, 3, 1}, 12)
        );
    }

    @DisplayName("House Robber")
    @ParameterizedTest(name = "Max rob from {0}: {1}")
    @MethodSource("testData")
    void testRob(int[] nums, int expected) {
        // ARRANGE - ACT
        int result = sut.rob(nums);

        // ASSERT
        assertEquals(expected, result);
    }
}