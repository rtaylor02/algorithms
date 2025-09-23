import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class _169_MajorityElementTest {
    private _169_MajorityElement sut = new _169_MajorityElement();

    @DisplayName("Majority Element")
    @ParameterizedTest(name = "{0} majority element: {1}")
    @MethodSource("argsProvider")
    void testMajorityElement(int[] nums, int expected) {
        // ARRANGE - ACT
        int actual = sut.majorityElement(nums);

        // ASSERT
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> argsProvider() {
        return Stream.of(
                //Arguments.of(new int[]{3, 2, 3}, 3),
                //Arguments.of(new int[]{2, 2, 1, 1, 1, 2, 2}, 2),
                //Arguments.of(new int[]{4, 2, 4}, 4),
                //Arguments.of(new int[]{4, 2, 2}, 2),
                Arguments.of(new int[]{2, 4, 4}, 4)
        );
    }


}
