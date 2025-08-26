package Java8.flatmapexample;

import java.util.List;
import java.util.stream.Collectors;

public class FlatMapExample {

    public static void main(String[] args) {
        List<String> result = Department.getDepartmentsList()
                .stream()
                .filter(dept -> dept.getEmployees().size() >2)
                .map(Department::getName)
                .toList();

        System.out.println("Departments with > 2 employees: " + result);
    }
}
