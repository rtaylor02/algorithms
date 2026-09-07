package leetcode;

public class _190_ReverseBits {
    public int reverseBits(int n) {
        int reverse = 0;

        for (int i = 0; i < 32; i++) {
            int leastSignificantBit = n & 1;
            reverse = (reverse << 1) | leastSignificantBit; // We copy from LSB by using OR bitwise operator
            n >>>= 1;
        }
        return reverse;
    }
}


/*
Given two integers a and b, return the sum of the two integers without using the operators + and -.

Example 1:
Input: a = 1, b = 2
Output: 3

Example 2:
Input: a = 2, b = 3
Output: 5

Constraints:
-1000 <= a, b <= 1000
 */