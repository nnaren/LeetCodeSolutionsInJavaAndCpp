//package leetCode;
//
//
//class ListNode {
//    int val;
//    ListNode next;
//    ListNode(int x) { val = x; }
//}
//
//public class ReverseNodesInkGroup {
//
//	public ListNode reverseKGroup(ListNode head, int k) {
//		if(head == null || head.next == null || k == 0 || k == 1) return head; 
//		int length = length(head);
//		if(length < k) return head;
//		if(length == k) return reverseList(head);
//		int num = 1;
//		ListNode temp = head;
//		while(num < k) {
//			temp = temp.next;
//			num++;
//		}
//		
//		ListNode tempForTemp = temp.next;
//		temp.next = null;
//		ListNode res = reverseList(head);
//		ListNode resTemp = res;
//		while(resTemp.next != null) {
//			resTemp = resTemp.next;
//		}
//		resTemp.next = reverseKGroup(tempForTemp, k);
//		return res;
//    }
//	
//	public int length(ListNode head) {
//		if(head == null) return 0;
//		if(head.next == null) return 1;
//		return 1+length(head.next);
//	}
//		
//	public void show(ListNode head) {
//		ListNode temp = head;
//		while(temp != null) {
//			System.out.printf("%d", temp.val);
//			System.out.print("->");
//			temp = temp.next;
//		}
//	}
//	
//	public ListNode reverseList(ListNode head) {
//		if(head == null || head.next == null) return head;
//		ListNode p1 = head;
//		ListNode p2 = p1.next;
//		while(p2 != null) {
//			ListNode p3 = p2.next;
//			p2.next = p1;
//			p1 = p2;
//			p2 = p3;
//		}
//		head.next = null;
//		return p1;
//	}
//	
//	public static void main(String[] args) {
//		ReverseNodesInkGroup m = new ReverseNodesInkGroup();
//		ListNode list1 = new ListNode(1);
//		list1.next = null;
//		for(int i = 3; i < 17; i+=1) {
//			ListNode temp1 = new ListNode(i);
//			ListNode tempHead1 = list1;
//			while(tempHead1.next != null) {
//				tempHead1 = tempHead1.next;
//			}
//			tempHead1.next = temp1;
//		}
//		m.show(list1);
//		System.out.println();
//		//System.out.println(m.length(list1));
//		//System.out.println();
//		//m.show(m.reverseList(list1));
//		
//		System.out.println();
//		System.out.println();
//		m.show(m.reverseKGroup(list1, 15));
//	}
//	
//}


/////////////////////////////a better answer
///**
// * Definition for singly-linked list.
// * public class ListNode {
// *     int val;
// *     ListNode next;
// *     ListNode(int x) { val = x; }
// * }
// */
//public class Solution {
//    public ListNode reverseKGroup(ListNode head, int k) {
//        ListNode curr = head;
//        int count = 0;
//        while (curr != null && count != k) { // find the k+1 node
//            curr = curr.next;
//            count++;
//        }
//        if (count == k) { // if k+1 node is found
//            curr = reverseKGroup(curr, k); // reverse list with k+1 node as head
//            // head - head-pointer to direct part, 
//            // curr - head-pointer to reversed part;
//            while (count-- > 0) { // reverse current k-group: 
//                ListNode tmp = head.next; // tmp - next head in direct part
//                head.next = curr; // preappending "direct" head to the reversed list 
//                curr = head; // move head of reversed part to a new node
//                head = tmp; // move "direct" head to the next node in direct part
//            }
//            head = curr;
//        }
//        return head;
//    }
//}



