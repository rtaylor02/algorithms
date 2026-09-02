package leetcode;

import java.util.Arrays;

/*
Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.

Example 1:
Input: nums = [3,0,1]
Output: 2
Explanation:
n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.

Example 2:
Input: nums = [0,1]
Output: 2
Explanation:
n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.

Example 3:
Input: nums = [9,6,4,2,3,5,7,0,1]
Output: 8
Explanation:
n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.

Constraints:
n == nums.length
1 <= n <= 10^4
0 <= nums[i] <= n
All the numbers of nums are unique.
 */

public class _268_MissingNumber {

    // Brute force: using comparison. Tc = O(n) + O(n+1); Sc = O(n) + O(n+1)
    public int missingNumber(int[] nums) {
        int[] completeArray = new int[nums.length + 1];
        for (int i = 0; i < completeArray.length; i++) {
            completeArray[i] = i;
        }

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (completeArray[i] != nums[i]) {
                return i;
            }
        }

        return completeArray[completeArray.length - 1];
    }

    // Using XOR operation: Tc = O(n); Sc = O(1)
    public int missingNumber2(int[] nums) {
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor = xor ^ i ^ nums[i];
        }

        // As the array length is always -1 of range (0, n)
        xor ^= nums.length;

        return xor;
    }

    // Using addition: Tc = O(n); Sc = O(n)
    public int missingNumber3(int[] nums) {
        int actualTotal = 0;
        for (int i = 0; i < nums.length; i++) {
            actualTotal += nums[i];
        }

        // Mathematical equation of total addition of consecutive positive integers
        int expectedTotal = nums.length * (nums.length + 1) / 2;

        return expectedTotal - actualTotal;
    }
}
