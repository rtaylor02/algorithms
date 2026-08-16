package leetcode;

import javax.xml.stream.events.Characters;
import java.util.HashSet;
import java.util.Set;

public class _3_LongestSubstringWithoutRepeatingCharacters {

    public int getLongestSubstringWithoutRepeatingCharacters(String s) {
        int rightIndex = 0;
        int leftIndex = 0;
        int maxNumberOfChars = 0;
        Set<Character> uniqueCharacters = new HashSet<>();

        while (rightIndex < s.length()) {
            if (!uniqueCharacters.contains(s.charAt(rightIndex))) {
                uniqueCharacters.add(s.charAt(rightIndex));
                maxNumberOfChars = Integer.max(maxNumberOfChars, rightIndex - leftIndex + 1);
                rightIndex++;
            } else {
                uniqueCharacters.remove(s.charAt(leftIndex));
                leftIndex++;
            }
        }

        return maxNumberOfChars;
    }
}
