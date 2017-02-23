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
