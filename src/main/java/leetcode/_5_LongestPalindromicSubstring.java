package leetcode;

public class _5_LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        int maxLength = 0;
        int startIndexOfMaxLength = 0;

        // Base case: 1 character palindrome. All is palindrome
        for (int i = 0; i < s.length(); i++) {
            isPalindrome[i][i] = true;
            maxLength = 1;
        }

        // 2 characters palindrome
        for (int i = 0; i + 1 < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                isPalindrome[i][i + 1] = true;
                maxLength = 2;
                startIndexOfMaxLength = i; // Will always register the last detected palindrome of 2 characters
            }
        }

        // > 2 characters palindrome: use isPalindrome[][] as memory of previous calculation and only assess the start index and end index
        for (int length = 3; length <= s.length(); length++) {
            for (int startIndex = 0; startIndex + length <= s.length(); startIndex++) {
                int endIndex = startIndex + length - 1;
                if ((s.charAt(startIndex) == s.charAt(endIndex)) && isPalindrome[startIndex + 1][endIndex - 1]) {
                    isPalindrome[startIndex][endIndex] = true;
                    maxLength = length;
                    startIndexOfMaxLength = startIndex;
                    /*
                    // To catch the first longest palindrome, use logic below instead of the 2 lines above
                    if (maxLength < length) {
                        maxLength = length;
                        startIndexOfMaxLength = startIndex;
                    } */
                }
            }
        }

        return s.substring(startIndexOfMaxLength, startIndexOfMaxLength + maxLength); // + 1 because end index is exclusive
    }
}
