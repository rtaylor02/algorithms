package leetcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class _G42_CodingPractice {
    private static class TestCode1 {

        public int[][] merge(int[][] origin) {
            // Sort array
            Arrays.sort(origin, (a, b) -> Integer.compare(a[0], b[0]));

            // Progressive merge
            List<int[]> result = new ArrayList<>();
            result.add(origin[0]);

            for (int i = 1; i < origin.length; i++) {
                int[] lastArray = result.getLast();
                int[] temp = origin[i];
                if (temp[0] <= lastArray[1]) {
                    lastArray[1] = Math.max(temp[1], lastArray[1]);
                } else {
                    result.add(temp);
                }
            }


            return result.toArray(new int[result.size()][]);
        }
    }

    @DisplayName("Merge Intervals")
    @ParameterizedTest(name = "{0} ==> {1}")
    @MethodSource("testCode1")
    void testCode1(int[][] origin, int[][] expected) {
        TestCode1 sut = new TestCode1();

        int[][] result = sut.merge(origin);

        assertArrayEquals(expected, result);
    }

    private static Stream<Arguments> testCode1() {
        return Stream.of(
                Arguments.of(new int[][]{{8,10}, {1,3}, {2,6}, {15,18}}, new int[][]{{1, 6}, {8, 10}, {15, 18}}),
                Arguments.of(new int[][]{{9, 11}, {4, 7}, {8, 10}, {1, 4}}, new int[][]{{1, 7}, {8, 11}})
        );
    }
}
