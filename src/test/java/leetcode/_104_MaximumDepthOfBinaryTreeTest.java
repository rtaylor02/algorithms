package leetcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class _104_MaximumDepthOfBinaryTreeTest {
    private _104_MaximumDepthOfBinaryTree sut = new _104_MaximumDepthOfBinaryTree();

    @DisplayName("Maximum Depth of Binary Tree - Recursive DFS")
    @ParameterizedTest(name = "{0} max depth: {1}")
    @MethodSource("testData")
    void maxDepthTest(TreeNode root, int expected) {
        // ARRANGE
        sut.setAlgorithm(_104_MaximumDepthOfBinaryTree.Algorithm.RECURSIVE_DFS);

        // ACT
        int actual = sut.maxDepth(root);

        // ASSERT
        assertEquals(expected, actual);
    }

    @DisplayName("Maximum Depth of Binary Tree - Iterative BFS")
    @ParameterizedTest(name = "{0} max depth: {1}")
    @MethodSource("testData")
    void maxDepthTest_iterativeBFS(TreeNode root, int expected) {
        // ARRANGE
        sut.setAlgorithm(_104_MaximumDepthOfBinaryTree.Algorithm.ITERATIVE_BFS);

        // ACT
        int actual = sut.maxDepth(root);

        // ASSERT
        assertEquals(expected, actual);
    }

    @DisplayName("Maximum Depth of Binary Tree - Iterative DFS")
    @ParameterizedTest(name = "{0} max depth: {1}")
    @MethodSource("testData")
    void maxDepthTest_iterativeDFS(TreeNode root, int expected) {
        // ARRANGE
        sut.setAlgorithm(_104_MaximumDepthOfBinaryTree.Algorithm.ITERATIVE_DFS);

        // ACT
        int actual = sut.maxDepth(root);

        // ASSERT
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new TreeNode(3,
                        new TreeNode(9,
                                null,
                                null),
                        new TreeNode(20,
                                new TreeNode(15,
                                        null,
                                        null),
                                new TreeNode(7,
                                        new TreeNode(5,
                                                null,
                                                null),
                                        null))),
                        4), // This means 3 has children of 9 & 20; 9 hasn't got any children (null, null), 20 has 15 & 7 as children, 7 has 5 as its only child
                Arguments.of(new TreeNode(1,
                        null,
                        new TreeNode(2,
                                null,
                                null)),
                        2) // This means 1 has no child on left, but 2 as its child on right side.
        );
    }
}
