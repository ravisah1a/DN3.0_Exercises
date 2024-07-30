public class Student {
    private int id;
    private String name;
    private double grade;

    public Student(int id, String name, double grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }
}
public class StudentView {
    public void displayStudentDetails(Student student) {
        System.out.println("Student Details:");
        System.out.println("ID: " + student.getId());
        System.out.println("Name: " + student.getName());
        System.out.println("Grade: " + student.getGrade());
    }
}
public class StudentController {
    private Student model;
    private StudentView view;

    public StudentController(Student model, StudentView view) {
        this.model = model;
        this.view = view;
    }

    public void updateStudentDetails(String name, double grade) {
        model.setName(name);
        model.setGrade(grade);
    }
    public void displayStudentDetails() {
        view.displayStudentDetails(model);
    }
}
public class Main {
    public static void main(String[] args) {
        Student student = new Student(1, "Alice", 85.5);
        StudentView studentView = new StudentView();
        StudentController studentController = new StudentController(student, studentView);
        studentController.displayStudentDetails();
        studentController.updateStudentDetails("Bob", 92.0);
        studentController.displayStudentDetails();
    }
}