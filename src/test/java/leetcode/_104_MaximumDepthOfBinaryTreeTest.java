package leetcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class _104_MaximumDepthOfBinaryTreeTest {
    private _104_MaximumDepthOfBinaryTree sut = new _104_MaximumDepthOfBinaryTree();

    @DisplayName("Maximum Depth of Binary Tree")
    @ParameterizedTest(name = "{0} ==> max depth: {1}")
    @MethodSource("testData")
    void maxDepthTest(TreeNode root, int expected) {
        // ARRANGE - ACT
        int actual = sut.maxDepth(root);

        // ASSERT
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new Integer[] {3, 9, 20, null, null, 15, 7}, 3),
                Arguments.of(new Integer[] {1, null, 2}, 2)
        );
    }
}
