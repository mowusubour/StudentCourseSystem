
# Student Course Management System

## Project Description

The Student Course Management System is a database application designed to manage student information, courses, professors, and course enrollments.

The project uses Java, MySQL, HTML, CSS, and JavaScript.

## Technologies Used

- Java (JDK 25)
- MySQL
- MySQL Connector/J
- HTML
- CSS
- JavaScript
- Visual Studio Code

## Project Structure

```text
StudentCourseSystem/
├── src/
│   ├── Student.java
│   ├── Course.java
│   ├── Professor.java
│   ├── Enrollment.java
│   ├── Main.java
│   ├── DatabaseConnection.java
│   ├── StudentDAO.java
│   ├── CourseDAO.java
│   ├── ProfessorDAO.java
│   └── EnrollmentDAO.java
├── lib/
│   └── MySQL Connector/J
├── index.html
├── style.css
├── script.js
├── mac250.sql
└── README.md
```

## Requirements

- Java Development Kit (JDK)
- MySQL Server
- MySQL Workbench
- Visual Studio Code

## Database Setup

1. Open MySQL Workbench.
2. Create or select the `mac250` database.
3. Open the `mac250.sql` file.
4. Execute the SQL script to create the database tables.

## Java Setup

1. Clone or download this repository.
2. Open the project folder in Visual Studio Code.
3. Make sure the MySQL Connector/J JAR is inside the `lib` folder.
4. Configure your database password using the `DB_PASSWORD` environment variable.
5. Compile the Java files from the `src` folder:

```powershell
javac -cp ".;../lib/*" *.java
```

## Project Status

The Java classes, database connection, and DAO operations have been developed and tested. The website and Java backend integration are still in progress.
