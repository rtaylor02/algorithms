package leetcode;

public class _53_MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if (nums.length <= 0) {
            return 0;
        }

        int maxSubarrayTotal = nums[0];
        int currentMaxTotal = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentMaxTotal = Math.max(nums[i], currentMaxTotal + nums[i]);
            maxSubarrayTotal = Math.max(maxSubarrayTotal, currentMaxTotal);
        }

        return maxSubarrayTotal;
    }
}
