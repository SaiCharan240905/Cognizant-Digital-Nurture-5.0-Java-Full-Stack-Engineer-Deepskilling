// Employee Class
class Employee {

    private int employeeId;
    private String name;
    private String position;
    private double salary;

    public Employee(int employeeId,
                    String name,
                    String position,
                    double salary) {

        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    @Override
    public String toString() {

        return "Employee ID: " + employeeId +
               ", Name: " + name +
               ", Position: " + position +
               ", Salary: ₹" + salary;
    }
}

// Main Class
public class EmployeeManagementSystem {

    private Employee[] employees;
    private int count;

    public EmployeeManagementSystem(int size) {
        employees = new Employee[size];
        count = 0;
    }

    // Add Employee
    public void addEmployee(Employee employee) {

        if (count == employees.length) {

            System.out.println(
                    "Employee Database is Full!");

            return;
        }

        employees[count] = employee;
        count++;

        System.out.println(
                "Employee Added Successfully.");
    }

    // Search Employee
    public Employee searchEmployee(int employeeId) {

        for (int i = 0; i < count; i++) {

            if (employees[i].getEmployeeId()
                    == employeeId) {

                return employees[i];
            }
        }

        return null;
    }

    // Traverse Employees
    public void displayEmployees() {

        if (count == 0) {

            System.out.println(
                    "No Employees Found.");

            return;
        }

        System.out.println(
                "\nEmployee Records:");

        for (int i = 0; i < count; i++) {

            System.out.println(employees[i]);
        }
    }

    // Delete Employee
    public void deleteEmployee(int employeeId) {

        int index = -1;

        for (int i = 0; i < count; i++) {

            if (employees[i].getEmployeeId()
                    == employeeId) {

                index = i;
                break;
            }
        }

        if (index == -1) {

            System.out.println(
                    "Employee Not Found.");

            return;
        }

        // Shift elements left
        for (int i = index; i < count - 1; i++) {

            employees[i] = employees[i + 1];
        }

        employees[count - 1] = null;
        count--;

        System.out.println(
                "Employee Deleted Successfully.");
    }

    public static void main(String[] args) {

        EmployeeManagementSystem system =
                new EmployeeManagementSystem(10);

        // Add Employees
        system.addEmployee(
                new Employee(
                        101,
                        "Sai",
                        "Software Engineer",
                        60000));

        system.addEmployee(
                new Employee(
                        102,
                        "Rahul",
                        "Data Analyst",
                        55000));

        system.addEmployee(
                new Employee(
                        103,
                        "Priya",
                        "Project Manager",
                        85000));

        // Display Employees
        system.displayEmployees();

        // Search Employee
        System.out.println(
                "\nSearching Employee ID 102...");

        Employee emp =
                system.searchEmployee(102);

        if (emp != null) {

            System.out.println(
                    "Employee Found:");

            System.out.println(emp);
        }
        else {

            System.out.println(
                    "Employee Not Found.");
        }

        // Delete Employee
        System.out.println(
                "\nDeleting Employee ID 102...");

        system.deleteEmployee(102);

        // Display Updated Records
        system.displayEmployees();
    }
}