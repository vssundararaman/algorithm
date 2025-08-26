package designpattern.prototype;

public class PrototypeExample {
    public static void main(String[] args) {
        Employee employee1 =  new Employee("Alice", "Developer", 30);
        employee1.showDetails();

        Employee employee2 = (Employee) employee1.clone();
        employee2.showDetails();

        System.out.println(employee1 == employee2); // false
    }
}
