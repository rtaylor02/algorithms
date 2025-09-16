import java.util.HashMap;

/*
Source: LeetCode problem #242
==============================

Given two strings s and t, return true if t is an anagram of s, and false otherwise.

Example 1:
Input: s = "anagram", t = "nagaram"
Output: true

Example 2:
Input: s = "rat", t = "car"
Output: false

Constraints:
1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.
 */
public class _242_ValidAnagram {

    public boolean isValidAnagram2(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        } else {
            int count1 = 0;
            int count2 = 0;
            for (int i = 0; i < word1.length(); i++) {
                count1 = count1 + word1.charAt(i);
                count2 = count2 + word2.charAt(i);
            }
            return count2 == count1;
        }
    }

    public boolean isValidAnagram(String word1, String word2) {
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        if (word1.length() != word2.length()) {
            return false;
        } else {
            for (int i = 0; i < word1.length(); i++) {
                map1.put(word1.charAt(i), map1.getOrDefault(word1.charAt(i), 0) + 1);
                map2.put(word2.charAt(i), map2.getOrDefault(word2.charAt(i), 0) + 1);
            }
        }

        return map1.equals(map2);
    }
}
