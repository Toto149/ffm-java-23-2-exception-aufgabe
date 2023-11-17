import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class GuestListTest {

    @Test
    void shouldBeEmptyInitially(){
        //GIVEN
        GuestList guestList = new GuestList();
        List<String> expected = List.of();
        guestList.setGuests(expected);
        //WHEN
        List<String> actual = guestList.getGuests();
        //THEN
        assertLinesMatch(expected,actual);
    }
    @Test
    void shouldReadSameGuestsAsWrittenBefore(){
        //GIVEN
        GuestList guestList = new GuestList();
        List<String> expected = List.of("Karl","Ute");
        guestList.setGuests(expected);
        //WHEN
        List<String> actual = guestList.getGuests();
        //THEN
        assertLinesMatch(expected,actual);
    }
}
