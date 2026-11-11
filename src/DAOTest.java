public class DAOTest {

    public static void main(String[] args) {

        try {
            StudentDAO studentDAO = new StudentDAO();
            CourseDAO courseDAO = new CourseDAO();
            ProfessorDAO professorDAO = new ProfessorDAO();

            System.out.println("===== STUDENTS =====");

            for (Student student : studentDAO.getAllStudents()) {
                System.out.println(
                    student.getId() + " - " +
                    student.getFirstName() + " " +
                    student.getLastName()
                );
            }

            System.out.println("\n===== COURSES =====");

            for (Course course : courseDAO.getAllCourses()) {
                System.out.println(
                    course.getCourseCode() + " - " +
                    course.getTitle()
                );
            }

            System.out.println("\n===== PROFESSORS =====");

            for (Professor professor : professorDAO.getAllProfessors()) {
                System.out.println(
                    professor.getId() + " - " +
                    professor.getFirstName() + " " +
                    professor.getLastName()
                );
            }

        } catch (Exception e) {
            System.out.println("Something went wrong!");
            e.printStackTrace();
        }
    }
}