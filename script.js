
function showSection(sectionId) {

    // Get all the content areas inside main
    const sections = document.querySelectorAll("main > div");

    // Hide all content areas
    sections.forEach(function(section) {
        section.style.display = "none";
    });

    // Display the selected content area
    document.getElementById(sectionId).style.display = "block";
}

// Display Home when the page first loads
showSection("home");

// Get the Student Registration form
const studentForm = document.getElementById("student-form");

// Run this function when the form is submitted
studentForm.addEventListener("submit", function(event) {

    // Prevent the page from refreshing
    event.preventDefault();

    // Get the information entered into the form
    const studentId = document.getElementById("student-id").value;
    const firstName = document.getElementById("first-name").value;
    const lastName = document.getElementById("last-name").value;
    const email = document.getElementById("email").value;
    const phone = document.getElementById("phone").value;

    // Get the Student Records table
    const studentList = document.getElementById("student-list");

    // Create a new row
    const newRow = studentList.insertRow();

    // Add the student information to the row
    newRow.insertCell(0).textContent = studentId;
    newRow.insertCell(1).textContent = firstName;
    newRow.insertCell(2).textContent = lastName;
    newRow.insertCell(3).textContent = email;
    newRow.insertCell(4).textContent = phone;

    // Clear the form
    studentForm.reset();

});

// Get the Course form
const courseForm = document.getElementById("course-form");

// Run this function when the form is submitted
courseForm.addEventListener("submit", function(event) {

    event.preventDefault();

    // Get the information entered into the form
    const courseId = document.getElementById("course-id").value;
    const courseCode = document.getElementById("course-code").value;
    const courseTitle = document.getElementById("course-title").value;
    const credits = document.getElementById("credits").value;
    const prereqCode = document.getElementById("prereq").value;

    // Get the Course Records table
    const courseList = document.getElementById("course-list");

    // Create a new row
    const newRow = courseList.insertRow();

    // Add the course information to the row
    newRow.insertCell(0).textContent = courseId;
    newRow.insertCell(1).textContent = courseCode;
    newRow.insertCell(2).textContent = courseTitle;
    newRow.insertCell(3).textContent = credits;
    newRow.insertCell(4).textContent = prereqCode;

    // Clear the form
    courseForm.reset();

});

// Get the Prof form
const profForm = document.getElementById("prof-form");

// Run this function when the form is submitted
profForm.addEventListener("submit", function(event) {

    // Prevent the page from refreshing
    event.preventDefault();

    // Get the information entered into the form
    const profId = document.getElementById("prof-id").value;
    const profFirstName = document.getElementById("prof-first-name").value;
    const dept = document.getElementById("dept").value;
    const profLastName = document.getElementById("prof-last-name").value;
    const profEmail = document.getElementById("prof-email").value;
    const profPhone = document.getElementById("prof-phone").value;

console.log(profId);
console.log(profFirstName);
console.log(profLastName);
console.log(dept);
console.log(profEmail);
console.log(profPhone);

    // Get the prof Records table
    const profList = document.getElementById("prof-list");

    // Create a new row
    const newRow = profList.insertRow();

    // Add the prof information to the row
    newRow.insertCell(0).textContent = profId;
    newRow.insertCell(1).textContent = profFirstName;
    newRow.insertCell(2).textContent = profLastName;
    newRow.insertCell(3).textContent = dept;
    newRow.insertCell(4).textContent = profEmail;
    newRow.insertCell(5).textContent = profPhone;

    // Clear the form
    profForm.reset();

});


// Get the Enrollment form
const enrollmentForm = document.getElementById("enrollment-form");

// Run this function when the form is submitted
enrollmentForm.addEventListener("submit", function(event) {

    // Prevent the page from refreshing
    event.preventDefault();

    // Get the information entered into the form
    const registrationDate = document.getElementById("registration-date").value;
    const student = document.getElementById("enrollment-student");
    const course = document.getElementById("enrollment-course");
    const professor = document.getElementById("enrollment-professor");

    // Get the selected student, course, and professor
    const studentName = student.options[student.selectedIndex].text;
    const courseName = course.options[course.selectedIndex].text;
    const professorName = professor.options[professor.selectedIndex].text;

    // Get the Enrollment Records table
    const enrollmentList = document.getElementById("enrollment-list");

    // Create a new row
    const newRow = enrollmentList.insertRow();

    // Generate a temporary enrollment ID
    const enrollmentId = enrollmentList.rows.length;

    // Add the enrollment information to the row
    newRow.insertCell(0).textContent = enrollmentId;
    newRow.insertCell(1).textContent = registrationDate;
    newRow.insertCell(2).textContent = studentName;
    newRow.insertCell(3).textContent = courseName;
    newRow.insertCell(4).textContent = professorName;

    // Clear the form
    enrollmentForm.reset();

});

