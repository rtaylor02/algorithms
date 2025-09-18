/*
Source: LeetCode problem #125
==============================

A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
Given a string s, return true if it is a palindrome, or false otherwise.

Example 1:
Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.

Example 2:
Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.

Example 3:
Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.

Constraints:
1 <= s.length <= 2 * 105
s consists only of printable ASCII characters.
 */

public class _125_ValidPalindrome {
    public boolean isPalindrome2(String s) {
        String nonAlphanumericString = s.toLowerCase().replaceAll("[^a-z0-9]","");
        StringBuilder ori = new StringBuilder(nonAlphanumericString);
        StringBuilder reversed = new StringBuilder(nonAlphanumericString).reverse();
        if (ori.compareTo(reversed) == 0) {
            return true;
        }
        return false;
    }

    public boolean isPalindrome(String s) {
        // 1. Remove non-alphanumeric characters
        StringBuilder filtered = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                filtered.append(Character.toLowerCase(c));
            }
        }
        System.out.println(filtered);

        // 2. 'break' the new word in half to compare each character
        int leftTraverse = 0 , rightTraverse = filtered.length() - 1;
        while (leftTraverse < rightTraverse) {
            if (filtered.charAt(leftTraverse++) != filtered.charAt(rightTraverse--)) {
                return false;
            }
        }
        return true;
    }
}
