// Edition 1
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)return head;
        head.next = deleteDuplicates(head.next);
        return head.val == head.next.val ? head.next : head;
    }
}

// Edition 2
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
        	return head;
        ListNode tmpHead = head;
        
        while (tmpHead != null) {
        	if (tmpHead.next != null && tmpHead.val == tmpHead.next.val) {
        		tmpHead.next = tmpHead.next.next;
        	} else
        		tmpHead = tmpHead.next;
        }
        return head;
    }
}

// Edition 3
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
        	return head;
        ListNode tmpHead = head, start = null;
        
        while (tmpHead != null) {
        	if (tmpHead.next != null && tmpHead.val == tmpHead.next.val) {
        		start = tmpHead.next;
        		while (start != null && start.val == tmpHead.val)
        			start = start.next;
        		tmpHead.next =start;
        	}
        	tmpHead = tmpHead.next;
        }
        return head;
    }
}
