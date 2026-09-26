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

    // ********************************
    // Better solution from Leetcode:
    // ********************************
    private int start = 0;
    private int end = 0;

    public String longestPalindrome2(String s) {
        solve(s.toCharArray(), 0);

        return s.substring(start, end+1);
    }

    private void solve(char[] s, int m) {
        if(s.length - m < (end-start)/2){
            return;
        }

        int right = m;
        int left = m;

        while(right+1 < s.length && s[right] == s[right+1]) {
            right++;
        }

        m = right;

        while(left-1 >= 0 && right+1 < s.length && s[left-1] == s[right+1]) {
            right ++;
            left--;
        }

        if (end - start < right - left) {
            start = left;
            end = right;
        }

        solve(s, m + 1);
    }
}
