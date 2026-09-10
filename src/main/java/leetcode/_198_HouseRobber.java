package leetcode;

public class _198_HouseRobber {
    public int rob(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j = j + 2) {
                sum += nums[j];
                max = Math.max(max, sum);
            }
        }

        return max;
    }
}
