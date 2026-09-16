package genzcareer.codinginterview.java;

import java.util.HashMap;

public class Main {
    static class Q1 {
        public String reverseString(String input) {
            char[] chars = input.toCharArray();
            int left = 0, right = chars.length - 1;
            while (left < right) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }

            return new String(chars);
        }
    }

    static class Q2 {

        public void swapNumbers(int a, int b) {
            System.out.println("*********************************");
            System.out.printf("Before swapping: a = %d, b = %d%n", a, b);
            a = a + b;
            b = a - b;
            a = a - b;
            System.out.printf("After swapping: a = %d, b = %d%n", a, b);
        }
    }

    static class Q3 {
        public HashMap<String, Integer> countWords(String input) {
            HashMap<String, Integer> wordCounts = new HashMap<>();
            String[] words = input.split("\\s");
            for (String word : words) {
                wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
            }

            return wordCounts;
        }
    }
}
