import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class _242_ValidAnagramTest {
    private _242_ValidAnagram sut = new _242_ValidAnagram();

    @DisplayName("Valid Anagrams")
    @ParameterizedTest(name = "{0} and {1} are anagrams: {2}")
    @CsvSource({"anagram, nagaram, true", "rat, car, false", "grab, brag, true", "mug, guns, false"})
    void testIsAnagram(String word1, String word2, boolean expected) {
        // ARRANGE - ACT
        boolean actual = sut.isValidAnagram(word1, word2);

        // ASSERT
        assertEquals(expected, actual);
    }
}
