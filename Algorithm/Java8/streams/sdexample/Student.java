package Java8.streams.sdexample;

import java.util.List;

public class Student {
    private String name;
    private List<String> departments;

    public Student(String name, List<String> departments) {
        this.name = name;
        this.departments = departments;
    }
    public String getName() { return name; }
    public List<String> getDepartments() { return departments; }

}
