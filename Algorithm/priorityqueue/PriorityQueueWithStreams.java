package priorityqueue;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PriorityQueueWithStreams {
        // 1. Kth Largest Element in an Array (LeetCode 215)
        public static int findKthLargest(int[] nums, int k) {
            // Use streams to box and collect into PQ
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            Arrays.stream(nums).forEach(n -> {
                minHeap.offer(n);
                if (minHeap.size() > k) minHeap.poll();
            });
            return minHeap.peek();
        }

        // 2. Merge K Sorted Lists (LeetCode 23)
        static class ListNode {
            int val;
            ListNode next;
            ListNode(int x) { val = x; }
        }
        public static ListNode mergeKLists(ListNode[] lists) {
            PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
            Arrays.stream(lists).filter(Objects::nonNull).forEach(pq::offer);

            ListNode dummy = new ListNode(0), curr = dummy;
            while (!pq.isEmpty()) {
                ListNode node = pq.poll();
                curr.next = node;
                curr = curr.next;
                Optional.ofNullable(node.next).ifPresent(pq::offer);
            }
            return dummy.next;
        }

        // 3. Meeting Rooms II (LeetCode 253)
        public static int minMeetingRooms(int[][] intervals) {
            Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();

            Arrays.stream(intervals).forEach(interval -> {
                if (!minHeap.isEmpty() && minHeap.peek() <= interval[0]) {
                    minHeap.poll();
                }
                minHeap.offer(interval[1]);
            });
            return minHeap.size();
        }

        // 4. Task Scheduler (LeetCode 621)
        public static int leastInterval(char[] tasks, int n) {
            Map<Character, Long> freqMap = new String(tasks).chars()
                    .mapToObj(c -> (char)c)
                    .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

            PriorityQueue<Long> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
            maxHeap.addAll(freqMap.values());

            int time = 0;
            while (!maxHeap.isEmpty()) {
                List<Long> temp = new ArrayList<>();
                int cycle = n + 1;

                while (cycle-- > 0 && !maxHeap.isEmpty()) {
                    long f = maxHeap.poll();
                    if (f > 1) temp.add(f - 1);
                    time++;
                }
                temp.forEach(maxHeap::offer);

                if (!maxHeap.isEmpty()) time += cycle + 1; // idle time
            }
            return time;
        }

        // 5. Connect N Ropes with Minimum Cost (LeetCode 1167)
        public static int connectSticks(int[] sticks) {
            PriorityQueue<Integer> minHeap = Arrays.stream(sticks)
                    .boxed()
                    .collect(Collectors.toCollection(PriorityQueue::new));

            int cost = 0;
            while (minHeap.size() > 1) {
                int a = minHeap.poll();
                int b = minHeap.poll();
                cost += a + b;
                minHeap.offer(a + b);
            }
            return cost;
        }

        // MAIN DRIVER
        public static void main(String[] args) {
            // 1. Kth Largest
            int[] nums = {3,2,1,5,6,4};
            System.out.println("Kth Largest (k=2): " + findKthLargest(nums, 2)); // Output: 5

            // 2. Merge K Sorted Lists
            ListNode l1 = new ListNode(1); l1.next = new ListNode(4); l1.next.next = new ListNode(5);
            ListNode l2 = new ListNode(1); l2.next = new ListNode(3); l2.next.next = new ListNode(4);
            ListNode l3 = new ListNode(2); l3.next = new ListNode(6);
            ListNode merged = mergeKLists(new ListNode[]{l1, l2, l3});
            System.out.print("Merged List: ");
            Stream.iterate(merged, Objects::nonNull, node -> node.next)
                    .forEach(node -> System.out.print(node.val + " "));
            System.out.println();

            // 3. Meeting Rooms II
            int[][] intervals = {{0,30},{5,10},{15,20}};
            System.out.println("Min Meeting Rooms: " + minMeetingRooms(intervals)); // Output: 2

            // 4. Task Scheduler
            char[] tasks = {'A','A','A','B','B','B'};
            System.out.println("Least Interval: " + leastInterval(tasks, 2)); // Output: 8

            // 5. Connect Ropes
            int[] sticks = {2,4,3};
            System.out.println("Min Cost to Connect Ropes: " + connectSticks(sticks)); // Output: 14
        }
}
