package leetCode;


//Definition for singly-linked list.

class ListNode {
	   int val;
	   ListNode next;
	   ListNode(int x) { val = x; }
	}

public class Solution_removeNth {
	
	

//	public ListNode removeNthFromEnd(ListNode head, int n) {
//     
//		if(head == null || n < 1) {
//			return head;
//		}
//		
//		if(head.next == null && n > 1) {
//			return head;
//		}
//		
//		ListNode n1, n2, n3, headTemp = head, temp;
//		
//		n1 = headTemp;
//		n2 = n1.next;
//		while(n2 != null) {
//			n3 = n2.next;
//			n2.next = n1;
//			n1 = n2;
//			n2 = n3;
//		}
//		
//		
//		headTemp.next = null;
//		headTemp = n1;
//		
//		///////////////////////////////////////////////
//		//System.out.println("1st reverse");
//		//show(headTemp);
//		///////////////////////////////////////////////
//		
//		temp = headTemp;
//		
//		if(n == 1) {
//			headTemp = headTemp.next;
//		} else {
//			int i = 1;
//			while(temp != null) {
//				if(i == n-1) {
//					break;
//				}
//				temp = temp.next;
//				i++;
//			}
//			temp.next = temp.next.next;
//		}
//		
//		///////////////////////////////////////////////
//		//System.out.println();
//		//System.out.println("after delete");
//		//show(headTemp);
//		///////////////////////////////////////////////
//		
//		n1 = headTemp;
//		n2 = n1.next;
//		while(n2 != null) {
//			n3 = n2.next;
//			n2.next = n1;
//			n1 = n2;
//			n2 = n3;
//		}
//		
//		headTemp.next = null;
//		head = n1;
//		
//		///////////////////////////////////////////////
//		//System.out.println();
//		//System.out.println("2nd reverse");
//		//show(head);
//		///////////////////////////////////////////////
//		
//		return head;
//    }
//	
//	public ListNode reverseList(ListNode head) {
//		ListNode n1, n2, n3;
//		
//		n1 = head;
//		n2 = n1.next;
//		while(n2 != null) {
//			n3 = n2.next;
//			n2.next = n1;
//			n1 = n2;
//			n2 = n3;
//		}
//		
//		head.next = null;
//		head = n1;
//		return head;
//	}
//	
	public void show(ListNode head) {
		ListNode temp = head;
		while(temp != null) {
			System.out.printf("%d", temp.val);
			System.out.print("->");
			temp = temp.next;
		}
	}
	
//	public ListNode removeNthFromEnd(ListNode head, int n) {
////		if(head == null || (head.next == null && n > 1) || n == 0) {
////			return head;
////		}
//		
//		int length = 0;
//		ListNode temp = head;
//		while(temp != null) {
//			length++;
//			temp = temp.next;
//		}
//		
//		temp = head;
//		if(n == length) {
//			return head.next;
//		} else if(n < length && n > 0) {
//			int nth = length+1-n;
//			int i = 1;
//			while(temp != null) {
//				if(i == nth-1) {
//					break;
//				}
//				temp = temp.next;
//				i++;
//			}
//			temp.next = temp.next.next;
//			return head;
//		}
//		return head;
//	}
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
	    
	    ListNode start = new ListNode(0);
	    ListNode slow = start, fast = start;
	    slow.next = head;
	    
	    //Move fast in front so that the gap between slow and fast becomes n
	    for(int i=1; i<=n+1; i++)   {
	        fast = fast.next;
	    }
	    //Move fast to the end, maintaining the gap
	    while(fast != null) {
	        slow = slow.next;
	        fast = fast.next;
	    }
	    //Skip the desired node
	    slow.next = slow.next.next;
	    return start.next;
	}
	
	public static void main(String[] args) {
		Solution_removeNth s = new Solution_removeNth();
		ListNode head = new ListNode(1);
		head.next = null;
		for(int i = 2; i < 10; i++) {
			ListNode temp = new ListNode(i);
			ListNode tempHead = head;
			while(tempHead.next != null) {
				tempHead = tempHead.next;
			}
			tempHead.next = temp;
		}
		
		s.show(head);
		System.out.println();
		
		//head = s.reverseList(head);
		//s.show(head);
		//System.out.println();
		
		head = s.removeNthFromEnd(head,8);
		s.show(head);
	}
}




 
