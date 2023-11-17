import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentRepoTest {

    @Test
    void findById_shouldThrowStudentNotFoundException_ifInputGivenIsInvalid(){
        //GIVEN
        StudentRepo repo = new StudentRepo();
        //WHEN

        //THEN
        try{
            repo.findById("1");
            fail();
        } catch (StudentNotFoundException e){
            assertTrue(true);
            System.out.println(e.getMessage());
        }
    }

    @Test
    void findById_shouldReturnStudentWithId1_whenId1IsGiven() {
        //GIVEN
        Student expected = new Student("1", "Horst", "Mathematik");
        StudentRepo repo = new StudentRepo();
        repo.save(expected);

        //WHEN
        Student actual = null;
        try {
            actual = repo.findById("1");

        } catch (StudentNotFoundException e) {
            System.out.println(e.getMessage());
            fail();
        }
        //THEN
        assertEquals(actual, expected);
    }

}