package leetcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
https://leetcode.com/problems/contains-duplicate/description/

Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.



Example 1:

Input: nums = [1,2,3,1]

Output: true

Explanation:

The element 1 occurs at the indices 0 and 3.

Example 2:

Input: nums = [1,2,3,4]

Output: false

Explanation:

All elements are distinct.

Example 3:

Input: nums = [1,1,1,3,3,4,3,2,4,2]

Output: true



Constraints:

1 <= nums.length <= 10^5
-10^9 <= nums[i] <= 10^9
 */

class _217_ContainsDuplicateTest {
    private _217_ContainsDuplicate sut = new _217_ContainsDuplicate();

    @DisplayName("Contains Duplicates")
    @ParameterizedTest(name = "{0} constains duplicate: {1}" )
    @MethodSource("argsProvider")
    void containsDuplicateTest(int[] array, boolean expected) {
        // ARRANGE - ACT
        boolean result = sut.containsDuplicate(array);

        // ASSERT
        assertEquals(expected, result);
    }

    private static Stream<Arguments> argsProvider() {
        return Stream.of(
                Arguments.of(new int[] {1, 2, 3, 1}, true),
                Arguments.of(new int[] {1, 2, 3}, false),
                Arguments.of(new int[] {1, 1}, true),
                Arguments.of(new int[] {1, 2, 3, 4}, false)
        );
    }
}