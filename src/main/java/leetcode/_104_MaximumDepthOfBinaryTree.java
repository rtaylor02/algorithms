package leetcode;

import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class _104_MaximumDepthOfBinaryTree {
    private Algorithm algorithm = Algorithm.RECURSIVE_DFS;

    enum Algorithm {
        RECURSIVE_DFS, ITERATIVE_BFS, ITERATIVE_DFS,
    }

    void setAlgorithm(Algorithm algorithm) {
        this.algorithm = algorithm;
    }

    public int maxDepth(TreeNode root) {
        return switch (this.algorithm) {
            case Algorithm.ITERATIVE_BFS -> maxDepth_iterativBFS(root);
            case Algorithm.ITERATIVE_DFS -> maxDepth_iterativeDFS(root);
            case Algorithm.RECURSIVE_DFS -> maxDepth_recursiveDFS(root);
        };
    }

    private int maxDepth_iterativeDFS(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Stack<TreeNode> nodeStack = new Stack<>();
        nodeStack.push(root);
        Stack<Integer> depthStack = new Stack<>();
        depthStack.push(1);

        Integer maxDepth = 0;
        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            int depth = depthStack.pop();
            maxDepth = Integer.max(maxDepth, depth);
            if (node.left != null) {
                nodeStack.push(node.left);
                depthStack.push(depth + 1);
            }
            if (node.right != null) {
                nodeStack.push(node.right);
                depthStack.push(depth + 1);
            }
        }

        return maxDepth;
    }

    private int maxDepth_recursiveDFS(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftNodeDepth = maxDepth_recursiveDFS(root.left);
        int rightNodeDepth = maxDepth_recursiveDFS(root.right);

        return 1 + Math.max(leftNodeDepth, rightNodeDepth);
    }

    private int maxDepth_iterativBFS(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int depth = 0;
        while (!q.isEmpty()) {
            depth++;
            for (int levelSize = q.size(); levelSize > 0; levelSize--) {
                TreeNode n = q.remove();
                if (n.left != null) {
                    q.add(n.left);
                }
                if (n.right != null) {
                    q.add(n.right);
                }
            }
        }

        return depth;
    }
}
