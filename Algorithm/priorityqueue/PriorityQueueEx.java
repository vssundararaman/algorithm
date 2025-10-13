package priorityqueue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueEx {
    public static void main(String[] args) {

        priorityQueueEx();
    }

    static void priorityQueueEx() {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(10);
        priorityQueue.add(75);
        priorityQueue.add(85);
        priorityQueue.add(50);
        priorityQueue.add(25);
        priorityQueue.add(100);

        System.out.println("=-----------------------------=");
        while(!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll());
        }

        //System.out.println(priorityQueue);
        PriorityQueue<Integer> priorityQueue1 = new PriorityQueue<>(Comparator.reverseOrder());
        priorityQueue1.add(10);
        priorityQueue1.add(75);
        priorityQueue1.add(85);
        priorityQueue1.add(50);
        priorityQueue1.add(25);
        priorityQueue1.add(100);

        System.out.println("=-----------------------------=");
        while(!priorityQueue1.isEmpty()) {
            System.out.println(priorityQueue1.poll());
        }
    }
}
