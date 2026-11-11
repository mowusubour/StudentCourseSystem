import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProfessorDAO {

    // Add a professor to the database
    public void addProfessor(Professor professor) throws SQLException {

        String sql = "INSERT INTO professor " +
                     "(id, first_name, last_name, department, email, phone) " +
                     "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, professor.getId());
            statement.setString(2, professor.getFirstName());
            statement.setString(3, professor.getLastName());
            statement.setString(4, professor.getDepartment());
            statement.setString(5, professor.getEmail());
            statement.setString(6, professor.getPhone());

            statement.executeUpdate();

            System.out.println("Professor added successfully!");
        }
    }

    // Retrieve all professors from the database
    public ArrayList<Professor> getAllProfessors() throws SQLException {

        ArrayList<Professor> professors = new ArrayList<>();

        String sql = "SELECT * FROM professor";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet results = statement.executeQuery()) {

            while (results.next()) {

                Professor professor = new Professor(
                    results.getInt("id"),
                    results.getString("first_name"),
                    results.getString("last_name"),
                    results.getString("department"),
                    results.getString("email"),
                    results.getString("phone")
                );

                professors.add(professor);
            }
        }

        return professors;
    }
    // Retrieve a professor using their ID
public Professor getProfessorById(int id) throws SQLException {

    String sql = "SELECT * FROM professor WHERE id = ?";

    try (Connection connection = DatabaseConnection.getConnection();
         PreparedStatement statement = connection.prepareStatement(sql)) {

        statement.setInt(1, id);

        try (ResultSet results = statement.executeQuery()) {

            if (results.next()) {

                return new Professor(
                    results.getInt("id"),
                    results.getString("first_name"),
                    results.getString("last_name"),
                    results.getString("department"),
                    results.getString("email"),
                    results.getString("phone")
                );
            }
        }
    }

    return null;
}
}