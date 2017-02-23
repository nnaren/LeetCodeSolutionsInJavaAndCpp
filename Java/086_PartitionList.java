// Good
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(0);
        ListNode p1 = node1, p2 = node2;
        while (head != null) {
            if (head.val < x)
                p1 = p1.next = head;
            else
                p2 = p2.next = head;
            head = head.next;
        }
        p2.next = null;
        p1.next = node2.next;
        return node1.next;
    }
}


// Bad
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        ListNode left = new ListNode(0);
        ListNode right = new ListNode(0);
        ListNode ltmp = left;
        ListNode rtmp = right;
        while (head != null) {
        	
        	if (head.val < x) {
        		ltmp.next = head;
        		ltmp = ltmp.next;
        	} else {
        		rtmp.next = head;
        		rtmp = rtmp.next;
        	}
        	head = head.next;
        }
        
        ltmp.next = null;
        rtmp.next = null;
        
        if (left.next == null) return right.next;
        else if(right.next == null) return left.next;
        else {
        	ltmp.next = right.next;
        	return left.next;
        }
    }
}
