package oreilly.liveevents.rohitbhardwaj.algorithms.topcodingquestionsolutions;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


//Single Number
//Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
// You must implement a solution with a linear runtime complexity and use only constant extra space.
//example: [4, 1, 2, 1, 2] --> 4
//
// Rod:
// Other considerations:
// - What about empty array?
// - What if array only contains repeated numbers?
// - What if array contains a number repeated 3 times or more? NOTE: this is a killer to XOR solution
public class SingleNumberTest {
    private SingleNumber sut = new SingleNumber();

    @ParameterizedTest(name = "{0} => {1}")
    @MethodSource("testData")
    void allCases(int[] arrayInput, int expected) {
        // ARRANGE - ACT
        int result = sut.singleNumber(arrayInput);

        // ASSERT
        assertEquals(expected, result);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{4, 1, 2, 2, 1}, 4), // Normal case: long array
                Arguments.of(new int[]{5, 1, 1}, 5), // Normal case: short array
                Arguments.of(new int[]{}, 0), // Edge case: empty array
                Arguments.of(new int[]{4, 4}, 0), // Edge case: only-repeated numbers
                Arguments.of(new int[]{4, 4, 4}, 0) // Edge case: a number repeated 3 times - FAIL
        );
    }
}
