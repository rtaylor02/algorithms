package leetcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.

Example 1:
Input: nums = [4,3,2,7,8,2,3,1]
Output: [5,6]

Example 2:
Input: nums = [1,1]
Output: [2]

Constraints:
n == nums.length
1 <= n <= 10^5
1 <= nums[i] <= n
 */

public class _448_FindAllNumbersDisappearedInAnArrayTest {
    private _448_FindAllNumbersDisappearedInAnArray sut = new _448_FindAllNumbersDisappearedInAnArray();

    @DisplayName("Find All Numbers Disappeared In An Array")
    @ParameterizedTest(name = "{0} ==> {1}")
    @MethodSource("testData")
    void testIsValid(int[] nums, List<Integer> expected) {
        List<Integer> actual = sut.findDisappearedNumbers(nums);

        // ASSERT
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{4, 3, 2, 7, 8, 2, 3, 1}, List.of(5, 6)),
                Arguments.of(new int[]{1, 1}, List.of(2))
        );
    }
}
