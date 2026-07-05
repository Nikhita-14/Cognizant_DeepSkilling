public class EmployeeManagement {
    private Employee[] employees;
    private int size;

    public EmployeeManagement(int capacity) {
        employees = new Employee[capacity];
        size = 0;
    }

    public boolean add(Employee emp) {
        if (size >= employees.length) return false;
        employees[size++] = emp;
        return true;
    }

    public Employee search(String empId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId().equals(empId)) {
                return employees[i];
            }
        }
        return null;
    }

    public void traverse() {
        for (int i = 0; i < size; i++) {
            System.out.println("ID: " + employees[i].getEmployeeId() + " | Name: " + employees[i].getName() + " | Role: " + employees[i].getPosition() + " | Salary: $" + employees[i].getSalary());
        }
    }

    public boolean delete(String empId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId().equals(empId)) {
                for (int j = i; j < size - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[size - 1] = null;
                size--;
                return true;
            }
        }
        return false;
    }
}