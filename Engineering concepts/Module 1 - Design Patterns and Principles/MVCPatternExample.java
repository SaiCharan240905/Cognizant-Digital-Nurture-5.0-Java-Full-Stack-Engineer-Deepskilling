// --------------------------------------------------
// Model Class
// --------------------------------------------------
class Student {

    private String name;
    private int id;
    private String grade;

    public Student(
            String name,
            int id,
            String grade) {

        this.name = name;
        this.id = id;
        this.grade = grade;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getGrade() {
        return grade;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}

// --------------------------------------------------
// View Class
// --------------------------------------------------
class StudentView {

    public void displayStudentDetails(
            String studentName,
            int studentId,
            String studentGrade) {

        System.out.println(
                "===== STUDENT DETAILS =====");

        System.out.println(
                "Student Name : "
                        + studentName);

        System.out.println(
                "Student ID   : "
                        + studentId);

        System.out.println(
                "Student Grade: "
                        + studentGrade);

        System.out.println();
    }
}

// --------------------------------------------------
// Controller Class
// --------------------------------------------------
class StudentController {

    private Student model;
    private StudentView view;

    public StudentController(
            Student model,
            StudentView view) {

        this.model = model;
        this.view = view;
    }

    // Update Name
    public void setStudentName(
            String name) {

        model.setName(name);
    }

    // Update Grade
    public void setStudentGrade(
            String grade) {

        model.setGrade(grade);
    }

    // Retrieve Data
    public String getStudentName() {

        return model.getName();
    }

    public int getStudentId() {

        return model.getId();
    }

    public String getStudentGrade() {

        return model.getGrade();
    }

    // Update View
    public void updateView() {

        view.displayStudentDetails(
                model.getName(),
                model.getId(),
                model.getGrade());
    }
}

// --------------------------------------------------
// Main Test Class
// --------------------------------------------------
public class MVCPatternExample {

    public static void main(String[] args) {

        System.out.println(
                "===== MVC Pattern Demo =====\n");

        // Create Model
        Student student =
                new Student(
                        "Sai Charan",
                        101,
                        "A");

        // Create View
        StudentView view =
                new StudentView();

        // Create Controller
        StudentController controller =
                new StudentController(
                        student,
                        view);

        // Display Initial Data
        System.out.println(
                "Initial Student Data:\n");

        controller.updateView();

        // Update Student Data
        System.out.println(
                "Updating Student Details...\n");

        controller.setStudentName(
                "Sai Kumar");

        controller.setStudentGrade(
                "A+");

        // Display Updated Data
        System.out.println(
                "Updated Student Data:\n");

        controller.updateView();
    }
}