package javacollections;

import java.util.*;

public class JavaCollectionMaster {

    public static void main(String[] args) {
        // List Interface
        // ArrayList
        // What: Resizable array-based list.
        // Unique: Fast random access (O(1)), slower inserts in middle.
        // Where: Used when frequent retrieval is required.
        List<String> arrayList = new ArrayList<>();
        arrayList.add("Ramesh");
        arrayList.add("Amit");
        System.out.println(" ArrayList " + arrayList);

        // LinkedList
        // What: Resizable linked list.
        // Unique: Fast random access (O(1)), faster inserts in middle.
        // Where: Used when frequent insertion and deletion is required.
         LinkedList<String> linkedList = new LinkedList<>();
         linkedList.add("Ramesh");
         linkedList.add("Amit");
         System.out.println(" LinkedList " + linkedList);

        //Vector
         // What: Resizable array-based list.
         // Unique: Fast random access (O(1)), slower inserts in middle.
         // Where: Used when frequent retrieval is required.
         Vector<String> vector = new Vector<>();
         vector.add("Ramesh");
         vector.add("Amit");
         System.out.println(" Vector " + vector);

         //Stack
        // What: LIFO (Last In First Out) data structure.
         // Unique: Fast random access (O(1)), slower insertion and deletion.
         // Where: Used when the last element is added and removed frequently.
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        System.out.println(" Stack " + stack);
        System.out.println(" Stack top: " + stack.peek());
    }
}
