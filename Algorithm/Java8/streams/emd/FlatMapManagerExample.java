package Java8.streams.emd;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapManagerExample {

    public static void main() {
        List<Employee> empList1 = Arrays.asList(
                new Employee("Arun", "IT"),
                new Employee("Priya", "HR"),
                new Employee("Kumar", "IT"),
                new Employee("Anitha", "IT")
        );

        // Manager 2 employees
        List<Employee> empList2 = Arrays.asList(
                new Employee("Vidhya", "Finance"),
                new Employee("Suresh", "HR"),
                new Employee("Anitha", "Finance")
        );

        // Managers
        List<Manager> managers = Arrays.asList(
                new Manager("Ravi", empList1),
                new Manager("Karthik", empList2)
        );

        managers.stream()
                .collect(Collectors.toMap(
                        Manager::getManagerName,
                        m -> m.getEmployees()
                                .stream()
                        .map(Employee::getName)
                        .collect(Collectors.toList())
                )).forEach((k,v) -> System.out.println(k + ": " + v));
    }
}
