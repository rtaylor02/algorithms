import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TwoSumTest {
    private final TwoSum sut = new TwoSum();

    private static Stream<Arguments> argsSource_findTwoSums() {
        return Stream.of(
                Arguments.of(new int[]{2, 7, 11, 15}, 9, new int[]{0, 1}),
                Arguments.of(new int[]{3, 2, 4}, 6, new int[]{1, 2}),
                Arguments.of(new int[]{3, 3}, 6, new int[]{0, 1})
        );
    }

    @DisplayName("Testing scenarios")
    @ParameterizedTest(name = "Target of {1} from {0}: {2}")
    @MethodSource("argsSource_findTwoSums")
    void testCases(int[] nums, int target, int[] expected) {
        // ARRANGE - ACT
        int[] result = sut.twoSum(nums, target);
        Arrays.sort(result);
        Arrays.sort(expected);

        // ASSERT
        assertArrayEquals(expected, result);
    }
}