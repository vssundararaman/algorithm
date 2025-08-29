package Java8.streams.commonusingset;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class CommonEmployeesExample {
    public static void main(String[] args) {
        // Employees
        Employee alice = new Employee(101, "Alice");
        Employee bob = new Employee(102, "Bob");
        Employee charlie = new Employee(103, "Charlie");
        Employee david = new Employee(104, "David");

        // Teams
        List<Employee> team1 = Arrays.asList(alice, bob, charlie);
        List<Employee> team2 = Arrays.asList(bob, charlie, david);

        // Managers
        Manager m1 = new Manager(1, "Manager1", team1);
        Manager m2 = new Manager(2, "Manager2", team2);

        Set<Employee> common = m1.getEmployees().stream()
                .filter(e -> m2.getEmployees().contains(e))
                .collect(java.util.stream.Collectors.toSet());

        System.out.println("Common Employees between " + m1.getName() + " and " + m2.getName() + ": " + common);
    }
}