package leetcode;

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

    public boolean isValidAnagram3(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        var map = new HashMap<Character, Integer>(s1.length());
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0) + 1);
        }

        for (int j = 0; j < s2.length(); j++) {
            if (!map.containsKey(s2.charAt(j))) {
                return false;
            }
            map.put(s2.charAt(j), map.getOrDefault(s2.charAt(j), 0) - 1);
            if (map.get(s2.charAt(j)) < 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isValidAnagram2(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }

        int[] alphabetCount = new int[26];
        for (int i = 0; i < word1.length(); i++) {
            alphabetCount[word1.charAt(i) - 'a']++;
            alphabetCount[word2.charAt(i) - 'a']--;
        }
        for (int j : alphabetCount) {
            if (j != 0) {
                return false;
            }
        }
        return true;
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
