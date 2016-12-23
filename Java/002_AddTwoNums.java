package leetCode;


class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }
 

public class Addtwonums {

	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       
		ListNode head = new ListNode(0);
		ListNode temp = head;
		int flag = 0;
		
		while(l1 != null || l2 != null || flag != 0) {
			
			int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + flag;
			flag = sum / 10;
			temp.next = new ListNode(sum % 10);
			temp = temp.next;
			
			l1 = (l1 != null ? l1.next : l1);
			l2 = (l2 != null ? l2.next : l2);
		}
		
        return head.next;
    }
	
	public static void main(String[] args) {
		ListNode a1 = new ListNode(9);
		ListNode a2 = new ListNode(9);
		a1.next = a2;
		
		ListNode b1 = new ListNode(1);
		
		ListNode res = addTwoNumbers(a1, b1);
		

		while(res != null) {	
			System.out.println(res.val);
			res = res.next;
		}
	}
}



