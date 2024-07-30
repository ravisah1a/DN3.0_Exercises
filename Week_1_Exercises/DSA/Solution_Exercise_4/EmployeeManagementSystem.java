class Employee {
    private int employeeId;
    private String name;
    private String position;
    private double salary;

    public Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    // Getters and setters (omitted for brevity)
}

public class EmployeeManagementSystem {
    private Employee[] employees;
    private int numEmployees;

    public EmployeeManagementSystem(int capacity) {
        employees = new Employee[capacity];
        numEmployees = 0;
    }

    public void addEmployee(Employee employee) {
        if (numEmployees < employees.length) {
            employees[numEmployees] = employee;
            numEmployees++;
        } else {
            System.out.println("Employee database is full.");
        }
    }

    public Employee searchEmployee(int employeeId) {
        for (Employee emp : employees) {
            if (emp != null && emp.getEmployeeId() == employeeId) {
                return emp;
            }
        }
        return null; // Not found
    }

    public void traverseEmployees() {
        for (Employee emp : employees) {
            if (emp != null) {
                System.out.println(emp.getName() + " (" + emp.getPosition() + ")");
            }
        }
    }

    public void deleteEmployee(int employeeId) {
        for (int i = 0; i < numEmployees; i++) {
            if (employees[i] != null && employees[i].getEmployeeId() == employeeId) {
                employees[i] = null;
                numEmployees--;
                break;
            }
        }
    }

    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem(10);

        // Example usage:
        ems.addEmployee(new Employee(101, "Alice", "Manager", 75000.0));
        ems.addEmployee(new Employee(102, "Bob", "Developer", 60000.0));

        Employee foundEmployee = ems.searchEmployee(101);
        if (foundEmployee != null) {
            System.out.println("Found employee: " + foundEmployee.getName());
        } else {
            System.out.println("Employee not found.");
        }

        ems.traverseEmployees();

        ems.deleteEmployee(102);
        System.out.println("Remaining employees:");
        ems.traverseEmployees();
    }
}
