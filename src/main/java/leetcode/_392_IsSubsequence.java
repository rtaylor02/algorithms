package leetcode;

public class _392_IsSubsequence {
    /*
    Use 2 pointers to traverse word1 and word2 respectively. If the characters pointed by the pointers are the same,
    move both pointers; if not, move only word2 pointers. This enforces sequential search within word2. Only when
    word1 pointer reaches the length + 1 iteration, then we know word2 contains word1 as its subsequence.
     */
    public boolean isSubsequence(String word1, String word2) {
        int pointer1 = 0, pointer2 = 0;

        while ((pointer1 < word1.length()) && (pointer2 < word2.length())) {
            if (word1.charAt(pointer1) == word2.charAt(pointer2)) {
                pointer1++;
                pointer2++;
            } else {
                pointer2++;
            }
        }

        return pointer1 == word1.length();
    }
}
