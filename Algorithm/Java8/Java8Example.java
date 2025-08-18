import java.util.*;
import java.util.function.*;

class Student {
    String name;
    int marks;

    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return name + " (" + marks + ")";
    }
}

public class Java8Example {
    public static void main(String[] args) {

        // Supplier → Create student list
        Supplier<List<Student>> studentSupplier = () -> Arrays.asList(
                new Student("Arun", 85),
                new Student("Bala", 65),
                new Student("Chitra", 92),
                new Student("Dinesh", 45)
        );

        List<Student> students = studentSupplier.get();

        // Predicate → Check if marks >= 60
        Predicate<Student> isPassed = s -> s.marks >= 60;

        // Function → Convert marks to grade
        Function<Integer, String> marksToGrade = marks -> {
            if (marks >= 90) return "A+";
            else if (marks >= 75) return "A";
            else if (marks >= 60) return "B";
            else return "F";
        };

        // Consumer → Print student with grade
        Consumer<Student> printStudentWithGrade = s ->
                System.out.println(s.name + " → Grade: " + marksToGrade.apply(s.marks));

        // Processing
        students.stream()
                .filter(isPassed)  // Predicate
                .forEach(printStudentWithGrade); // Consumer
    }
}
