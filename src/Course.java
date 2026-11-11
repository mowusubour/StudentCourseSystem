
public class Course {

    // Attributes
    private int id;
    private String courseCode;
    private String title;
    private int credits;
    private String prereqCode;

    // Constructor
    public Course(int id, String courseCode, String title,
                  int credits, String prereqCode) {
        this.id = id;
        this.courseCode = courseCode;
        this.title = title;
        this.credits = credits;
        this.prereqCode = prereqCode;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getTitle() {
        return title;
    }

    public int getCredits() {
        return credits;
    }

    public String getPrereqCode() {
        return prereqCode;
    }

}
