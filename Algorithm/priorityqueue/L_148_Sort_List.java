package priorityqueue;

/**
 * 148. Sort List
 * Medium
 * Topics
 * conpanies icon
 * Companies
 * Given the head of a linked list, return the list after sorting it in ascending order.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [4,2,1,3]
 * Output: [1,2,3,4]
 * Example 2:
 *
 *
 * Input: head = [-1,5,3,4,0]
 * Output: [-1,0,3,4,5]
 * Example 3:
 *
 * Input: head = []
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [0, 5 * 104].
 * -105 <= Node.val <= 105
 *
 *
 * Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?
 */
public class L_148_Sort_List {

    public static void main(String[] args) {

        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);

        ListNode node = sortList(head);
        ListNode.printListNode(node);


    }

    static ListNode sortList(ListNode head) {

        if(head == null || head.next == null) return head;

        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(slow);

       return merge(left, right);
    }

    static ListNode merge(ListNode L1, ListNode L2) {
        ListNode l = new ListNode(0), p=l;
        while(L1 != null && L2 != null) {
            if(L1.val < L2.val) {
                p.next = L1;
                L1 = L1.next;
            } else {
                p.next = L2;
                L2 = L2.next;
            }
            p = p.next;
        }
        if(L1 != null) p.next = L1;
        if(L2 != null) p.next = L2;
        return l.next;
    }

}
