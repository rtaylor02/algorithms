import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class _20_ValidParenthesisTest {
    private _20_ValidParenthesis sut = new _20_ValidParenthesis();

    @DisplayName("Valid Parenthesis")
    @ParameterizedTest(name = "{0} is valid parenthesis: {1}")
    @CsvSource({"(), true", "()[]{}, true", "(], false", "([]), true", "([)], false", "()], false"})
    void testIsValid(String s, boolean expected) {
        // ARRANGE - ACT
        boolean actual = sut.isValid2(s);

        // ASSERT
        assertEquals(expected, actual);
    }
}
