package trywithresources;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResourcesExample {

    public static void main(String[] args) {
        // Create a dummy file for demonstration
        // In a real application, "input.txt" would already exist.
        try (java.io.FileWriter writer = new java.io.FileWriter("input.txt")) {
            writer.write("Line 1\n");
            writer.write("Line 2\n");
            writer.write("Line 3\n");
        } catch (IOException e) {
            System.err.println("Error creating input file: " + e.getMessage());
        }

        // Using try-with-resources to read from the file
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("Read: " + line);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
