package priorityqueue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueExample {

    public static void main(String[] args) {

        priorityQueue();
        priorityQueuecustomSortOrder();
        priorityQueueCustomOrder();
        priorityQueueCustomStringOrder();

    }

    private static void priorityQueue() {
        PriorityQueue<Integer> numbers = new PriorityQueue<>();
        numbers.add(10);
        numbers.add(75);
        numbers.add(75);
        numbers.add(50);
        numbers.add(100);
        numbers.add(25);
        // Highest in the queue
        System.out.println(numbers.peek());
        printQueue(numbers);
    }

    static void printQueue(PriorityQueue<Integer> numbers) {
        while(!numbers.isEmpty()) {
            System.out.print(numbers.poll() + " ");
        }
        System.out.println(" ");
    }

    static void priorityQueuecustomSortOrder() {
        PriorityQueue<Integer> numbers = new PriorityQueue<>((n1, n2) -> n2 - n1);
        numbers.add(10);
        numbers.add(75);
        numbers.add(75);
        numbers.add(50);
        numbers.add(100);
        numbers.add(25);
        System.out.println(numbers.peek());
        printQueue(numbers);
    }

    static void priorityQueueCustomOrder() {
        PriorityQueue<Task> taskQueue = new PriorityQueue<>(Comparator.comparingInt(task -> task.priority));

        taskQueue.add(new Task("Write report", 2));
        taskQueue.add(new Task("Fix bug", 1));
        taskQueue.add(new Task("Deploy feature", 3));

        while (!taskQueue.isEmpty()) {
            System.out.println(taskQueue.poll());
        }
    }

    static void priorityQueueCustomStringOrder() {
        PriorityQueue<Task> taskQueue = new PriorityQueue<>(Comparator.comparing(task -> task.name));

        taskQueue.add(new Task("Write report", 2));
        taskQueue.add(new Task("Fix bug", 1));
        taskQueue.add(new Task("Deploy feature", 3));

        while (!taskQueue.isEmpty()) {
            System.out.println(taskQueue.poll());
        }
    }

}

class Task {

    String name;
    int priority;

    public Task(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return name + " (Priority: " + priority + ")";
    }
}
