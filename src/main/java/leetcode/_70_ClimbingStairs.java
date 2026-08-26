package leetcode;

public class _70_ClimbingStairs {
    public int climbStairs(int n) {
        if ((n == 1) || (n == 2)) {
            return n;
        } else {
            // Initialise memo with values we already know
            int[] memo = new int[n + 1];
            memo[1] = 1;
            memo[2] = 2;

            for (int i = 3; i <= n; i++) {
                memo[i] = memo[i - 1] + memo[i - 2];
            }

            return memo[n];
        }
    }
}
