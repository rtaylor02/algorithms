import java.util.HashMap;

/*
Source: LeetCode problem #169
==============================

Given an array nums of size n, return the majority element.
The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

Example 1:
Input: nums = [3,2,3]
Output: 3

Example 2:
Input: nums = [2,2,1,1,1,2,2]
Output: 2

Constraints:
n == nums.length
1 <= n <= 5 * 104
-109 <= nums[i] <= 109

Follow-up: Could you solve the problem in linear time and in O(1) space?
 */
public class _169_MajorityElement {
    // Space complexity O(n); time complexity = O(n)
    public int majorityElement(int[] nums) {
        int majority = 0;
        int frequencyOfMajority = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 1) + 1);
            if (frequencyOfMajority < map.get(i)) {
                frequencyOfMajority = map.get(i);
                majority = i;
            }
        }

        return majority;
    }

    // Better solution with space complexity of O(1); time complexity O(n)
    public int majorityElement2(int[] nums) {
        int majority = 0;
        int frequencyOfMajority = 0;

        for (int n : nums) {
            // Update only when there is no majority
            if (frequencyOfMajority == 0) {
                majority = n;
            }

            // Remember priority of execution: equality (==), ternary (?:), assignment (+=)
            frequencyOfMajority += n == majority ? 1 : -1;
        }

        return majority;
    }
}
