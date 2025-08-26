package Java8.flatmapexample;

import java.util.Arrays;
import java.util.List;

public class Department {
    String name;
    List<Employee> employees;

    Department(String name, List<Employee> employees) {
        this.name = name;
        this.employees = employees;
    }

    public String getName() { return name; }
    public List<Employee> getEmployees() { return employees; }

    public static List<Department> getDepartmentsList() {
        // Departments with employees
        Department it = new Department("IT", Arrays.asList(
                new Employee("Alice"),
                new Employee("Bob"),
                new Employee("Charlie")
        ));

        Department hr = new Department("HR", Arrays.asList(
                new Employee("David"),
                new Employee("Eva")
        ));

        Department finance = new Department("Finance", Arrays.asList(
                new Employee("Frank"),
                new Employee("Grace"),
                new Employee("Helen"),
                new Employee("Ivy")
        ));

        return Arrays.asList(it, hr, finance);
    }
}


