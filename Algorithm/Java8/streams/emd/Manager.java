package Java8.streams.emd;

import java.util.List;

public class Manager {
    private String managerName;
    private List<Employee> employees;

    public Manager(String managerName, List<Employee> employees) {
        this.managerName = managerName;
        this.employees = employees;
    }
    public String getManagerName() { return managerName; }
    public List<Employee> getEmployees() { return employees; }
}
