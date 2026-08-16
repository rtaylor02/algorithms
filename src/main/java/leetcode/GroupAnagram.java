package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagram {
    public List<List<String>> getGroupAnagram(String[] strings) {
        Map<String, List<String>> patternMap = new HashMap<>();

        for (String s : strings) {
            char[] pattern = new char[26];
            List<String> words = new ArrayList<>();

            for (char c : s.toLowerCase().toCharArray()) {
                int pos = c - 'a';
                pattern[pos]++;
            }
            words.add(s);

            String patternStr = String.valueOf(pattern);
            if (patternMap.containsKey(patternStr)) {
                patternMap.get(patternStr).add(s);
            } else {
                List<String> newList = new ArrayList<>();
                newList.add(s);
                patternMap.put(patternStr, newList);
            }
        }

        List<List<String>> collectedList = new ArrayList<>();
        for (String key : patternMap.keySet()) {
            collectedList.add(patternMap.get(key));
        }

        return collectedList;
    }

    public List<List<String>> getGroupAnagram_Answer(String[] strs) {
        Map<String, List<String>> anagramMap = new HashMap<>();

        for (String word : strs) {
            char[] count = new char[26];
            for (char c : word.toCharArray()) {
                count[c - 'a']++;
            }
            String key = String.valueOf(count);
            anagramMap.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
        }

        return new ArrayList<>(anagramMap.values());
    }
}
