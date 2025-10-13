package deque;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequePrograms {
    public static void main(String[] args) {

        Deque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(10);
        deque.addLast(20);
        deque.addFirst(5);

        System.out.println("Deque: " + deque);
        System.out.println(deque.removeLast());
        System.out.println("Deque after removal: " + deque);
        System.out.println(deque.removeFirst());
        System.out.println("Deque after removal: " + deque);
    }
}
