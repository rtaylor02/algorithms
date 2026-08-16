package leetcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static java.util.stream.Stream.of;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

public class _252_MeetingRoomsTest {
    private _252_MeetingRooms sut = new _252_MeetingRooms();

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[][]{{0, 30}, {5, 10}, {15, 20}}, false),
                Arguments.of(new int[][]{{5, 8}, {9, 15}}, false),
                Arguments.of(new int[][]{{8, 10}, {9, 25}}, false) // Edge case: invalid input - time exceed 24-hour notation
        );
    }

    @DisplayName("Valid Parenthesis")
    @ParameterizedTest(name = "{0} is valid parenthesis: {1}")
    @MethodSource("testdata")
    void testIsValid(String s, boolean expected) {
        // ARRANGE - ACT
        boolean actual = sut.canAttendMeetings();



        // ASSERT
        assertEquals(expected, actual);
    }
}
