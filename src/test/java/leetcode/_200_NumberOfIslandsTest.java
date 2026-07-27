package leetcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class _200_NumberOfIslandsTest {
    private _200_NumberOfIslands sut = new _200_NumberOfIslands();

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        new char[][]{
                                {'1', '1', '1', '1', '0'},
                                {'1', '1', '0', '1', '0'},
                                {'1', '1', '0', '0', '0'},
                                {'0', '0', '0', '0', '0'}}, 1),
                Arguments.of(
                        new char[][]{
                                {'1', '1', '0', '0', '0'},
                                {'1', '1', '0', '0', '0'},
                                {'0', '0', '1', '0', '0'},
                                {'0', '0', '0', '1', '1'}}, 3),
                Arguments.of(
                        new char[][]{
                                {'0', '0', '0', '0', '0'},
                                {'0', '0', '0', '0', '0'},
                                {'0', '0', '0', '0', '0'},
                                {'0', '0', '0', '0', '0'}}, 0),
                Arguments.of(
                        new char[][]{
                                {'1', '1', '1', '1', '1'},
                                {'1', '1', '1', '1', '1'},
                                {'1', '1', '1', '1', '1'},
                                {'1', '1', '1', '1', '1'}}, 1)
        );
    }

    @DisplayName("Number of Islands")
    @ParameterizedTest(name = "Number of islands: {1}")
    @MethodSource("testData")
    void testIsValid(char[][] grid, int expectedTotalIsland) {
        // ARRANGE - ACT
        int actual = sut.calculateNumberOfIslands(grid);

        // ASSERT
        assertEquals(expectedTotalIsland, actual);
    }
}
