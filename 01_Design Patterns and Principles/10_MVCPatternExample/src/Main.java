public class Main {
    public static void main(String[] args) {
        Student model = new Student("Alice Johnson", "S101", "A");
        StudentView view = new StudentView();
        StudentController controller = new StudentController(model, view);

        System.out.println("--- Initial Record ---");
        controller.updateView();

        System.out.println("\n--- Updating Record via Controller ---");
        controller.setStudentGrade("A+");
        controller.updateView();
    }
}