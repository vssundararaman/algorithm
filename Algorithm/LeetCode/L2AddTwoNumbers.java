package LeetCode;

/**
 * 2. Add Two Numbers
 * Medium
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 */
public class L2AddTwoNumbers {
    public static void main(String[] args) {

        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode result = addTwoNumbers(l1, l2);
        printList(result); // Expected output: 7 -> 0 -> 8
    }
	
	static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode head = new ListNode();
		ListNode p = l1, q = l2, current = head;

		int carry = 0;

		while(p !=null || q !=null) {
		
			int x = (p !=null)?p.val:0;
			int y = (q !=null)?q.val:0;
				
			int sum = x + y + carry;
			
			carry = sum / 10;
			
			current.next = new ListNode(sum %10);
			current = current.next;
			
			if (p!=null) p = p.next;
			if (q!=null) q = q.next;
		}
		
		if(carry > 0) {
			current.next = new ListNode(carry);
		}
	
		return head.next;
	}

    static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }
	
}
