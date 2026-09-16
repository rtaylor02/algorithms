package genzcareer.codinginterview.java;

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

}
