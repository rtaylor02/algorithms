package leetcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class _56_MergeIntervalsTest {
    private _56_MergeIntervals sut = new _56_MergeIntervals();

    @DisplayName("Merge Intervals")
    @ParameterizedTest(name = "{0} ==> {1}")
    @MethodSource("testData")
    void testCases(int[][] intervals, int[][] expected) {
        // ARRANGE - ACT
        int[][] result = sut.merge(intervals);

        // ASSERT
        assertArrayEquals(expected, result);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[][]{{1,3},{2,6},{8,10},{15,18}}, new int[][]{{1,6},{8,10},{15,18}}),
                Arguments.of(new int[][]{{1, 4}, {4, 5}}, new int[][]{{1, 5}}),
                Arguments.of(new int[][]{{1, 4}, {2, 3}}, new int[][]{{1, 4}}),
                Arguments.of(new int[][]{{4, 7}, {1, 4}}, new int[][]{{1, 7}}), // Edge case: unsorted initial interval
                Arguments.of(new int[][]{{1, 4}, {5, 6}}, new int[][]{{1, 4}, {5, 6}}) // Edge case: no merge
        );
    }
}
