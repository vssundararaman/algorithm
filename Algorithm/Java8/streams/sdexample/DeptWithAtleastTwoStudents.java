package Java8.streams.sdexample;

import java.util.Arrays;
import java.util.List;

public class DeptWithAtleastTwoStudents {

    public static void main(String[] args) {
        // Students
        Student s1 = new Student("Arun", Arrays.asList("IT", "HR"));
        Student s2 = new Student("Priya", Arrays.asList("Finance"));
        Student s3 = new Student("Kumar", Arrays.asList("IT", "Finance"));
        Student s4 = new Student("Anitha", Arrays.asList("HR"));
        Student s5 = new Student("Ravi", Arrays.asList("IT"));

        List<Student> students = Arrays.asList(s1, s2, s3, s4, s5);



    }
}
