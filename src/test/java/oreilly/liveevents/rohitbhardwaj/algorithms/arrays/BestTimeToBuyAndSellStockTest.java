package oreilly.liveevents.rohitbhardwaj.algorithms.arrays;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BestTimeToBuyAndSellStockTest {
    private BestTimeToBuyAndSellStock sut = new BestTimeToBuyAndSellStock();

    @ParameterizedTest(name = "{0} => max profit: {1}")
    @MethodSource("testData")
    void containsDuplicate(int[] input, int expected) {
        // ARRANGE - ACT
        int maxProfit = sut.calculateMaxProfit(input);

        // ASSERT
        assertEquals(expected, maxProfit);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{7, 1, 5, 3, 6, 4}, 5),
                Arguments.of(new int[]{7, 2, 9, 1, 2, 3}, 7),
                Arguments.of(new int[]{7, 6, 4, 3, 1}, 0)
        );
    }
}
