package priorityqueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class PriorityQueueExamples {

    // 1. Kth Largest Element in an Array (LeetCode 215)
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int n : nums) {
            minHeap.add(n);
            if (minHeap.size() > k) {
                minHeap.poll(); // remove smallest
            }
        }
        return minHeap.peek();
    }

    // 2. Merge K Sorted Lists (LeetCode 23)
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode node : lists) {
            if (node != null) pq.add(node);
        }
        ListNode dummy = new ListNode(0), curr = dummy;
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            curr.next = node;
            curr = curr.next;
            if (node.next != null) pq.add(node.next);
        }
        return dummy.next;
    }

    // 3. Meeting Rooms II (LeetCode 253)
    public static int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int[] interval : intervals) {
            if (!minHeap.isEmpty() && minHeap.peek() <= interval[0]) {
                minHeap.poll(); // free a room
            }
            minHeap.add(interval[1]); // allocate room till end time
        }
        return minHeap.size();
    }

    // 4. Task Scheduler (LeetCode 621)
    public static int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char c : tasks) freq[c - 'A']++;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int f : freq) if (f > 0) maxHeap.add(f);

        int time = 0;
        while (!maxHeap.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int cycle = n + 1;
            while (cycle-- > 0 && !maxHeap.isEmpty()) {
                int f = maxHeap.poll();
                if (f > 1) temp.add(f - 1);
                time++;
            }
            for (int t : temp) maxHeap.add(t);
            if (!maxHeap.isEmpty()) time += cycle + 1; // idle time
        }
        return time;
    }

    // 5. Connect N Ropes with Minimum Cost (LeetCode 1167)
    public static int connectSticks(int[] sticks) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int s : sticks) minHeap.add(s);
        int cost = 0;
        while (minHeap.size() > 1) {
            int a = minHeap.poll();
            int b = minHeap.poll();
            cost += a + b;
            minHeap.add(a + b);
        }
        return cost;
    }

    // MAIN DRIVER to test all
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
        while (merged != null) { System.out.print(merged.val + " "); merged = merged.next; }
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
