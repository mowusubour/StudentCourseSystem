import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDAO {

    // Add a student to the database
    public void addStudent(Student student) throws SQLException {

        String sql = "INSERT INTO student " +
                     "(id, first_name, last_name, email, phone) " +
                     "VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, student.getId());
            statement.setString(2, student.getFirstName());
            statement.setString(3, student.getLastName());
            statement.setString(4, student.getEmail());
            statement.setString(5, student.getPhone());

            statement.executeUpdate();

            System.out.println("Student added successfully!");
        }
    }

    // Retrieve all students from the database
    public ArrayList<Student> getAllStudents() throws SQLException {

        ArrayList<Student> students = new ArrayList<>();

        String sql = "SELECT * FROM student";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet results = statement.executeQuery()) {

            while (results.next()) {

                Student student = new Student(
                    results.getInt("id"),
                    results.getString("first_name"),
                    results.getString("last_name"),
                    results.getString("email"),
                    results.getString("phone")
                );

                students.add(student);
            }
        }

        return students;
    }
    // Retrieve a student using their ID
public Student getStudentById(int id) throws SQLException {

    String sql = "SELECT * FROM student WHERE id = ?";

    try (Connection connection = DatabaseConnection.getConnection();
         PreparedStatement statement = connection.prepareStatement(sql)) {

        statement.setInt(1, id);

        try (ResultSet results = statement.executeQuery()) {

            if (results.next()) {

                return new Student(
                    results.getInt("id"),
                    results.getString("first_name"),
                    results.getString("last_name"),
                    results.getString("email"),
                    results.getString("phone")
                );
            }
        }
    }

    return null;
}
}