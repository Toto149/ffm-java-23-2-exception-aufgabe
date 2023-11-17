import lombok.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class GuestList {
    private List<String> guests = new ArrayList<>();

    public void setGuests(List<String> guests) throws IOException {
        this.guests = guests;
        Files.write(Path.of("C:\\Users\\Thorsten Thomann" +
                "\\IdeaProjects\\ffm-java-23-2-exception-aufgabe" +
                "\\src\\main\\java\\guests.txt"),guests);
    }
    public List<String> getGuests() {
        try {
            if(Files.exists(Path.of("C:\\Users\\Thorsten Thomann" +
                    "\\IdeaProjects\\ffm-java-23-2-exception-aufgabe" +
                    "\\src\\main\\java\\guests.txt"))){
                return Files.readAllLines(Path.of("C:\\Users\\Thorsten Thomann" +
                        "\\IdeaProjects\\ffm-java-23-2-exception-aufgabe" +
                        "\\src\\main\\java.guests.txt"));
            }
        } catch (IOException e){
            System.out.println("guests.txt does not exist");
        }
        return this.guests;
    }
}
