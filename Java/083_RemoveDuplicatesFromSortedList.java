
// Edition 1
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
