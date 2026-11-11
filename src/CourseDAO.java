import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CourseDAO {

    // Add a course to the database
    public void addCourse(Course course) throws SQLException {

        String sql = "INSERT INTO course " +
                     "(id, course_code, title, credits, prereq_code) " +
                     "VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, course.getId());
            statement.setString(2, course.getCourseCode());
            statement.setString(3, course.getTitle());
            statement.setInt(4, course.getCredits());
            statement.setString(5, course.getPrereqCode());

            statement.executeUpdate();

            System.out.println("Course added successfully!");
        }
    }

    // Retrieve all courses from the database
    public ArrayList<Course> getAllCourses() throws SQLException {

        ArrayList<Course> courses = new ArrayList<>();

        String sql = "SELECT * FROM course";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet results = statement.executeQuery()) {

            while (results.next()) {

                Course course = new Course(
                    results.getInt("id"),
                    results.getString("course_code"),
                    results.getString("title"),
                    results.getInt("credits"),
                    results.getString("prereq_code")
                );

                courses.add(course);
            }
        }

        return courses;
    }
    // Retrieve a course using its ID
public Course getCourseById(int id) throws SQLException {

    String sql = "SELECT * FROM course WHERE id = ?";

    try (Connection connection = DatabaseConnection.getConnection();
         PreparedStatement statement = connection.prepareStatement(sql)) {

        statement.setInt(1, id);

        try (ResultSet results = statement.executeQuery()) {

            if (results.next()) {

                return new Course(
                    results.getInt("id"),
                    results.getString("course_code"),
                    results.getString("title"),
                    results.getInt("credits"),
                    results.getString("prereq_code")
                );
            }
        }
    }

    return null;
}
}