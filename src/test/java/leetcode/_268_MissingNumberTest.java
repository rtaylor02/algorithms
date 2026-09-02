package leetcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class _268_MissingNumberTest {
    private _268_MissingNumber sut = new _268_MissingNumber();

    @DisplayName("Missing number")
    @ParameterizedTest(name = "{0} missing number: {1}")
    @MethodSource("testData")
    void testCases(int[] array, int expected) {
        // ARRANGE - ACT
        int result = sut.missingNumber(array);

        // ASSERT
        assertEquals(expected, result);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{3, 0, 1}, 2),
                Arguments.of(new int[]{0, 1}, 2),
                Arguments.of(new int[]{0, 1, 2, 3}, 4),
                Arguments.of(new int[]{2, 0, 5, 1, 3}, 4),
                Arguments.of(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}, 8)
        );
    }
}
