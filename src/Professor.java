
public class Professor {

    // Attributes
    private int id;
    private String firstName;
    private String lastName;
    private String department;
    private String email;
    private String phone;


    // Constructor
    public Professor(int id, String firstName, String lastName,
                     String department, String email, String phone) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.email = email;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDepartment() {
        return department;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

}
