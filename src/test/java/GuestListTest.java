import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class GuestListTest {

    @Test
    void shouldBeEmptyInitially() throws IOException {
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
    void shouldReadSameGuestsAsWrittenBefore() throws IOException {
        //GIVEN
        GuestList guestList = new GuestList();
        List<String> expected = List.of("Karl","Ute");
        guestList.setGuests(expected);
        //WHEN
        List<String> actual = guestList.getGuests();
        //THEN
        assertLinesMatch(expected,actual);
    }
    @Test
    void shouldWriteToFileSystem() throws IOException {
        //GIVEN
        GuestList guestList = new GuestList();
        List<String> input = List.of("Theodor", "Anette");
        guestList.setGuests(input);
        Path expected = Path.of("C:\\Users\\Thorsten Thomann" +
                "\\IdeaProjects\\ffm-java-23-2-exception-aufgabe" +
                "\\src\\main\\java\\guests.txt");
        //WHEN
        Boolean actual = Files.exists(expected);

        //THEN
        assertTrue(actual);
    }
    @Test
    void shouldReadFromFileSystem() throws IOException {
        //GIVEN
        List<String> expected = Files.readAllLines(Path.of("C:\\Users\\Thorsten Thomann" +
                "\\IdeaProjects\\ffm-java-23-2-exception-aufgabe" +
                "\\src\\main\\java\\guests.txt"));
        GuestList guestList = new GuestList();
        //WHEN
        List<String> actual = guestList.getGuests();
        //THEN
        assertLinesMatch(expected,actual);

    }
}
