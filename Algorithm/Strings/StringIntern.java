package Strings;

import java.util.ArrayList;
import java.util.List;

public class StringIntern {
    public static void main(String[] args) {

        String s1 = new String("Hello"); // creates a new object in heap
        String s2 = "Hello";             // refers to string pool

        System.out.println(s1 == s2); // false, different references

        String s3 = s1.intern(); // returns reference from string pool
        System.out.println(s2 == s3); // true, both refer to string pool

        String s4 = new String("World").intern();
        String s5 = "World";

        System.out.println(s4 == s5); // true, both in string pool

    }
}
