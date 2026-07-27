package oreilly.liveevents.rohitbhardwaj.algorithms.arrays;

public class LongestSubstringSlidingWindow {
    public int findLongestSubstring(String input) {
        String window = "";
        int maxSubString = 0;

        // Edge case: null input
        if (null == input) {
            return 0;
        }

        for (char c : input.toCharArray()) {
            if (!window.isEmpty() && window.contains(String.valueOf(c))) {
                window = window.substring(window.indexOf(c) + 1);
            }
            window = window + c;

            maxSubString = Math.max(maxSubString, window.length());
        }

        return maxSubString;
    }
}
