package leetcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class _79_WordSearchTest {
    private _79_WordSearch sut = new _79_WordSearch();

    @DisplayName("Word Search")
    @ParameterizedTest(name = "{1} is found in grid: {2}")
    @MethodSource("testData")
    void existTest(char[][] board, String word, boolean expected) {
        // ARRANGE - ACT
        boolean actual = sut.exist(board, word);

        // ASSERT
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new char[][]{
                        {'A', 'B', 'C', 'E'},
                        {'S', 'F', 'C', 'S'},
                        {'A', 'D', 'E', 'E'}
                }, "ABCCED", true),
                Arguments.of(new char[][]{
                        {'A', 'B', 'C', 'E'},
                        {'S', 'F', 'C', 'S'},
                        {'A', 'D', 'E', 'E'}
                }, "SEE", true),
                Arguments.of(new char[][]{
                        {'A', 'B', 'C', 'E'},
                        {'S', 'F', 'C', 'S'},
                        {'A', 'D', 'E', 'E'}
                }, "ABCB", false)
        );
    }
}
