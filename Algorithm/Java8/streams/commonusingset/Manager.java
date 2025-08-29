package Java8.streams.commonusingset;

import java.util.List;

public class Manager {
    private int id;
    private String name;
    private List<Employee> employees;

    public Manager(int id, String name, List<Employee> employees) {
        this.id = id;
        this.name = name;
        this.employees = employees;
    }

    public String getName() { return name; }
    public List<Employee> getEmployees() { return employees; }
}
