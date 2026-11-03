package leetcode;

public class _392_IsSubsequence {
    /*
    Use 2 pointers to traverse s and t respectively. If the characters pointed by the pointers are the same,
    move both pointers; if not, move only t pointers. This enforces sequential search within t. Only when
    s pointer reaches the length + 1 iteration, then we know t contains s as its subsequence.
     */
    public boolean isSubsequence(String s, String t) {
        int pointer1 = 0, pointer2 = 0;

        while ((pointer1 < s.length()) && (pointer2 < t.length())) {
            if (s.charAt(pointer1) == t.charAt(pointer2)) {
                pointer1++;
                pointer2++;
            } else {
                pointer2++;
            }
        }

        return pointer1 == s.length();
    }

    // This is the best performing algorithm from LeetCode
    public boolean isSubsequence2(String s, String t) {
        for (int i = 0; i < s.length(); i++) {
            if (!t.contains(Character.toString(s.charAt(i)))) {
                return false;
            }

            int found = t.indexOf(s.charAt(i));
            t = t.substring(found + 1);
        }

        return true;
    }
}
