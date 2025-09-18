import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class _125_ValidPalindromeTest {
    private _125_ValidPalindrome sut = new _125_ValidPalindrome();

    @DisplayName("Testing A palindrome")
    @Test
    void testActualPalindrome() {
        // ARRANGE - ACT
        boolean actual = sut.isPalindrome("A man, a plan, a canal: Panama");

        // ASSERT
        assertTrue(actual);
    }

    @DisplayName("Testing NOT a palindrome")
    @Test
    void testNonPalindrome() {
        // ARRANGE - ACT
        boolean actual = sut.isPalindrome("race a car");

        // ASSERT
        assertFalse(actual);
    }

    @DisplayName("Space / empty string is palindrome")
    @Test
    void testSpace() {
        // ARRANGE - ACT
        boolean actual = sut.isPalindrome(" ");

        // ASSERT
        assertTrue(actual);
    }

    @DisplayName("Testing Alphanumeric palindrome")
    @Test
    void testAlphanumericPalindrome() {
        // ARRANGE - ACT
        boolean actual = sut.isPalindrome("21_manam_12");

        // ASSERT
        assertTrue(actual);
    }
}
