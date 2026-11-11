import java.time.LocalDate;

public class Enrollment {

    // Attributes
    private int enrollmentId;
    private LocalDate registrationDate;
    private Student student;
    private Course course;
    private Professor professor;

    // Constructor
    public Enrollment(int enrollmentId, LocalDate registrationDate,
                      Student student, Course course, Professor professor) {
        this.enrollmentId = enrollmentId;
        this.registrationDate = registrationDate;
        this.student = student;
        this.course = course;
        this.professor = professor;
    }

    // Getters
    public int getEnrollmentId() {
        return enrollmentId;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public Professor getProfessor() {
        return professor;
    }
}