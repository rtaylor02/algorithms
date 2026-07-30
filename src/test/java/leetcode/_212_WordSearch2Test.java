package leetcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class _212_WordSearch2Test {
    private _212_WordSearch2 sut = new _212_WordSearch2();

    @DisplayName("Word Search")
    @ParameterizedTest(name = "{2} found in grid")
    @MethodSource("testData")
    void findWordsTest(char[][] board, String[] words, List<String> expected) {
        // ARRANGE - ACT
        List<String> actual = sut.findWords(board, words);

        // ASSERT
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new char[][]{
                        {'o', 'a', 'a', 'n'},
                        {'e', 't', 'a', 'e'},
                        {'i', 'h', 'k', 'r'},
                        {'i', 'f', 'l', 'v'}
                }, new String[]{"oath","pea","eat","rain"}, List.of("oath","eat")),
                Arguments.of(new char[][]{
                        {'a', 'b'},
                        {'c', 'd'},
                }, new String[]{"abcb"}, List.of())
        );
    }
}
