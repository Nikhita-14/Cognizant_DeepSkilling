public class Main {
    public static void main(String[] args) {
        EmployeeManagement ems = new EmployeeManagement(5);

        System.out.println("--- Adding Employees ---");
        ems.add(new Employee("E001", "John Doe", "Developer", 75000));
        ems.add(new Employee("E002", "Jane Smith", "Manager", 90000));
        ems.add(new Employee("E003", "Bob Johnson", "Designer", 65000));
        ems.traverse();

        System.out.println("\n--- Searching for Employee E002 ---");
        Employee found = ems.search("E002");
        if (found != null) {
            System.out.println("Found: " + found.getName() + " (" + found.getPosition() + ")");
        } else {
            System.out.println("Employee not found.");
        }

        System.out.println("\n--- Deleting Employee E002 ---");
        ems.delete("E002");

        System.out.println("\n--- Final Employee Records ---");
        ems.traverse();
    }
}