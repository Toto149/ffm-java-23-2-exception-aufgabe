import java.util.*;

public class StudentRepo {

    private final Map<String, Student> students = new HashMap<>();

    public List<Student> getAllStudents() {
        return new ArrayList<>(students.values());
    }

    public Student save(Student student) {
        students.put(student.id(), student);
        return student;
    }
    public Student findById(String id) throws StudentNotFoundException{
        return this.getAllStudents()
                .stream()
                .filter(student -> student.id().equals(id))
                .findFirst().
                orElseThrow(() -> new StudentNotFoundException("Der Student mit der id: " + id + " wurde nicht gefunden"));

    }
    public Optional<Student> findStudentById(String id) {
        return Optional.ofNullable(students.get(id));
    }
}
