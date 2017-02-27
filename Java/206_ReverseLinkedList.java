/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        
        if (head == null || head.next == null)
            return head;

        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode start = pre.next;
        ListNode then = start.next;
        while(start.next != null) {
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }
        return pre.next;
    }
}
