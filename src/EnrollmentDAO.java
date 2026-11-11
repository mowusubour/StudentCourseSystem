import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;

public class EnrollmentDAO {

    // Add an enrollment to the database
    public void addEnrollment(Enrollment enrollment) throws SQLException {

        String sql = "INSERT INTO enrollment " +
                     "(registration_date, student_id, course_id, professor_id) " +
                     "VALUES (?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setDate(1, Date.valueOf(enrollment.getRegistrationDate()));
            statement.setInt(2, enrollment.getStudent().getId());
            statement.setInt(3, enrollment.getCourse().getId());
            statement.setInt(4, enrollment.getProfessor().getId());

            statement.executeUpdate();

            System.out.println("Enrollment added successfully!");
        }
    }

    // Retrieve all enrollments from the database
    public ArrayList<Enrollment> getAllEnrollments() throws SQLException {

        ArrayList<Enrollment> enrollments = new ArrayList<>();

        String sql = "SELECT * FROM enrollment";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet results = statement.executeQuery()) {

            while (results.next()) {

                int studentId = results.getInt("student_id");
                int courseId = results.getInt("course_id");
                int professorId = results.getInt("professor_id");

                // Retrieve the associated objects
                Student student = new StudentDAO()
                    .getStudentById(studentId);

                Course course = new CourseDAO()
                    .getCourseById(courseId);

                Professor professor = new ProfessorDAO()
                    .getProfessorById(professorId);

                // Create an Enrollment object
                Enrollment enrollment = new Enrollment(
                    results.getInt("enrollment_id"),
                    results.getDate("registration_date").toLocalDate(),
                    student,
                    course,
                    professor
                );

                enrollments.add(enrollment);
            }
        }

        return enrollments;
    }
}