package leetcode;

public class _198_HouseRobber {
    public int rob(int[] nums) {
        if (nums.length <= 1) {
            return nums[0];
        }

        int[] maxRob = new int[nums.length];
        maxRob[0] = nums[0];
        maxRob[1] = Math.max(maxRob[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            maxRob[i] = Math.max(maxRob[i - 2] + nums[i], maxRob[i - 1]);
        }
        return maxRob[maxRob.length - 1];
    }

    public int rob2(int[] nums) {
        if (nums.length <= 1) {
            return nums[0];
        }

        int max1 = nums[0];
        int max2 = Math.max(max1, nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int currentMax = Math.max(max1 + nums[i], max2);
            max1 = max2;
            max2 = currentMax;
        }

        return max2;
    }
}
