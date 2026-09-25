package dev.alg0;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GreedyVsDPTest {
    private static class DP {
        List<Integer> dpCoinChange(int[] coins, int amount) {
            int[] dp = new int[amount + 1];
            int[] used = new int[amount + 1];
            Arrays.fill(dp, Integer.MAX_VALUE / 2);
            Arrays.fill(used, -1);
            dp[0] = 0;
            for (int subAmount = 1; subAmount <= amount; subAmount++) {
                for (int coin : coins) {
                    if (coin <= subAmount && dp[subAmount - coin] + 1 < dp[subAmount]) {
                        dp[subAmount] = dp[subAmount - coin] + 1;  // result = [4, 4], totalCoins = 2, optimal = true
                        used[subAmount] = coin;
                    }
                }
            }
            // Reconstruct solution
            List<Integer> result = new ArrayList<>();
            int rem = amount;
            while (rem > 0) {
                result.add(used[rem]);
                rem -= used[rem];
            }
            return result;
        }
    }

    @DisplayName("Greedy vs Deep Programming")
    @ParameterizedTest(name = "DP ==> Target of {1} from {0}: {2}")
    @MethodSource("testData")
    void testDpCoinChange(int[] coins, int amount, List<Integer> expected) {
        // ARRANGE
        DP sut = new DP();

        // ACT
        List<Integer> actual = sut.dpCoinChange(new int[]{1, 4, 6}, 8);

        // ASSERT
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{1, 4, 6}, 8, List.of(4, 4))
        );
    }
}
