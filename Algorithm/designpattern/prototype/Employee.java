package designpattern.prototype;

public class Employee implements Prototype{
    private String name;
    private String designation;
    private int age;

    public Employee(String name, String designation, int age) {
        this.name = name;
        this.designation = designation;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public Prototype clone() {
        return new Employee(name, designation, age);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", designation='" + designation + '\'' +
                ", age=" + age +
                '}';
    }

    public void showDetails() {
        System.out.println("Employee: " + name + ", Age: " + age);
    }
}
