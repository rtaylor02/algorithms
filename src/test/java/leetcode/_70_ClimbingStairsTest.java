package leetcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class _70_ClimbingStairsTest {
    private _70_ClimbingStairs sut = new _70_ClimbingStairs();

    @DisplayName("Climbing stairs")
    @ParameterizedTest(name = "{0} steps ==> {1} distinct ways to climb")
    @CsvSource({"1, 1", "2, 2", "3, 3", "4, 5", "5, 8"})
    void testIsValid(int n, int expected) {
        // ARRANGE - ACT
        int actual = sut.climbStairs(n);

        // ASSERT
        assertEquals(expected, actual);
    }
}
