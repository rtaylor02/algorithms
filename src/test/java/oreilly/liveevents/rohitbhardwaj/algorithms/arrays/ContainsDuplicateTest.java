package oreilly.liveevents.rohitbhardwaj.algorithms.arrays;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContainsDuplicateTest {
    private ContainsDuplicate sut = new ContainsDuplicate();

    @ParameterizedTest(name = "{0} contains duplicate: {1}")
    @MethodSource("testData")
    void containsDuplicate(int[] input, boolean expected) {
        // ARRANGE - ACT
        boolean result = sut.containsDuplicate(input);

        // ASSERT
        assertEquals(expected, result);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 1}, true),
                Arguments.of(new int[]{1, 2, 3, 4}, false),
                Arguments.of(new int[]{1,1,1,3,3,4,3,2,4,2}, true),
                Arguments.of(new int[]{1,1,-1,3,-3,4,3,2,4,2}, true)
        );
    }
}
