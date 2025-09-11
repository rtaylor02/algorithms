import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ContainsDuplicateTest {
    private ContainsDuplicate sut = new ContainsDuplicate();

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