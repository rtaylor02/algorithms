package oreilly.liveevents.rohitbhardwaj.algorithms.arrays;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/*
The SumExistInArray class provides a method to determine whether a given array
contains two elements whose sum is equal to a specified target value.
 */
public class SumExistInArrayTest {
    // System Under Test
    private SumExistInArray sut = new SumExistInArray();

    @ParameterizedTest(name = "{0} with target {1}: {2}")
    @MethodSource("testData")
    void allTests(int[] arrayInput, int targetSum, boolean expected) {
        // ARRANGE - ACT
        boolean result = sut.hasArrayTwoCandidates(arrayInput, targetSum);

        // ASSERT
        assertEquals(expected, result);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{1, 4, 45, 6, 10, -8}, 15, false), // Normal case: normal sorted array & size, sum not found
                Arguments.of(new int[]{2, 7, 11, 15}, 9, true), // Normal case: normal sorted array & size, sum found at end of array
                Arguments.of(new int[]{3, 2, 4}, 6, true), // Edge case: unsorted array, sum found at end of array
                Arguments.of(new int[]{3, 3}, 6, true) // Edge case: minimum array size, sum found
        );
    }

    @ParameterizedTest(name = "{0} with target {1}: {2}")
    @MethodSource("testDataWithArrayReturn")
    void getIndicesOfTwoCandidatesTest(int[] arrayInput, int targetSum, int[] expected) {
        // ARRANGE - ACT
        int[] result = sut.getIndicesOfTwoCandidates(arrayInput, targetSum);

        // ASSERT
        assertArrayEquals(expected, result);
    }

    private static Stream<Arguments> testDataWithArrayReturn() {
        return Stream.of(
                Arguments.of(new int[]{1, 4, 45, 6, 10, -8}, 15, null), // Normal case: normal sorted array & size, sum not found
                Arguments.of(new int[]{2, 7, 11, 15}, 9, new int[]{0, 1}), // Normal case: normal sorted array & size, sum found at end of array
                Arguments.of(new int[]{3, 2, 4}, 6, new int[]{1, 2}), // Edge case: unsorted array, sum found at end of array
                Arguments.of(new int[]{3, 3}, 6, new int[]{0, 1}) // Edge case: minimum array size, sum found
        );
    }
}
