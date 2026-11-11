import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        // Create a Student object
        Student student1 = new Student(
            1, "John", "Smith", "john@email.com", "1234567890"
        );

        // Create a Course object
        Course course1 = new Course(
            101, "CSC101", "Introduction to Programming", 3, "None"
        );

        // Create a Professor object
        Professor professor1 = new Professor(
            1, "Jane", "Doe", "Computer Science", "jane@email.com", "1234567890"
        );

        // Create an Enrollment object
        Enrollment enrollment1 = new Enrollment(
            1, LocalDate.now(), student1, course1, professor1
        );

        // Display enrollment information
        System.out.println("Enrollment Created!");
        System.out.println("Student: " +
            enrollment1.getStudent().getFirstName() + " " +
            enrollment1.getStudent().getLastName());

        System.out.println("Course: " +
            enrollment1.getCourse().getTitle());

        System.out.println("Professor: " +
            enrollment1.getProfessor().getFirstName() + " " +
            enrollment1.getProfessor().getLastName());
    }
}