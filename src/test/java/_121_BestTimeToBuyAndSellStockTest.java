import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class _121_BestTimeToBuyAndSellStockTest {
    private _121_BestTimeToBuyAndSellStock sut = new _121_BestTimeToBuyAndSellStock();

    @DisplayName("Max profit")
    @ParameterizedTest(name = "max Profit of {0} = {1}")
    @MethodSource("argsSource_bestTimeToBuyAndSellStock")
    void maxProfitTest(int[] prices, int expectedProfit) {
        // ARRANGE
        int profit = sut.maxProfit(prices);

        // ASSERT
        assertEquals(expectedProfit, profit);
    }

    private static Stream<Arguments> argsSource_bestTimeToBuyAndSellStock() {
        return Stream.of(
                Arguments.of(new int[]{7, 1, 5, 3, 6, 4}, 5),
                Arguments.of(new int[]{7, 6, 4, 3, 1}, 0)
        );
    }
}