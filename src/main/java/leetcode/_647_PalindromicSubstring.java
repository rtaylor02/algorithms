package leetcode;

public class _647_PalindromicSubstring {
    public int countSubstring(String s) {
        int count = 0;
        boolean[][] dp = new boolean[s.length()][s.length()]; // Storing previously calculated indices

        // Base case 1: single character palindrome - all are palindrome
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
            count++;
        }

        // Base case 2: double character palindrome - only palindrome if they're both the same character
        for (int i = 0; i + 1 < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                count++;
            }
        }

        // Substrings with > 2 characters
        for (int substringLength = 3; substringLength <= s.length(); substringLength++) {
            for (int startIndex = 0; startIndex + substringLength <= s.length(); startIndex++) {
                int endIndex = startIndex + substringLength - 1;
                // Only check the start and end index if they are the same AND previous length of is palindrome (tabulation)
                if ((s.charAt(startIndex) == s.charAt(endIndex)) && dp[startIndex + 1][endIndex - 1]) {
                    count++;
                    dp[startIndex][endIndex] = true;
                }
            }
        }

        return count;
    }

    public int countSubstring2(String s) {
        int count = 0;
        int stringLength = s.length();
        char[] s1 = s.toCharArray();
        for (int c = 0; c < stringLength; c++) {
            int i = c - 1, j = c;
            while (j < stringLength - 1 && s1[j] == s1[j + 1]) {
                j++;
            }
            count += (j - i) * (j - i + 1) / 2;
            c = j;
            j++;
            while (i >= 0 && j < stringLength && s1[i] == s1[j]) {
                i--;
                j++;
                count++;
            }
        }
        return count;
    }
}
