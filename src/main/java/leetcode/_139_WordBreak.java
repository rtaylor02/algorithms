package leetcode;

import java.util.List;

public class _139_WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] result = new boolean[s.length() + 1];
        result[0] = true;

        for (int i = 0; i < result.length; i++) {
            for (String word : wordDict) {
                if (result[i] && ((i + word.length()) <= s.length()) && (s.substring(i, i + word.length()).equals(word))) {
                    result[i + word.length()] = true;
                }
            }
        }

        return result[result.length - 1];
    }
}
