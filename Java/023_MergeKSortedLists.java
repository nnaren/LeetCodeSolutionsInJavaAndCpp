
//////////////////////////////////////////效率第二

//package leetCode;
//
//import java.util.Arrays;
//
//class ListNode {
//    int val;
//    ListNode next;
//    ListNode(int x) { val = x; }
//}
//
//
//public class MergeKList {
//
//	public ListNode mergeKLists(ListNode[] lists) {
//		
//        ListNode res = new ListNode(0);
//        int len = lists.length;
//        
//        if(len == 0) {
//        	return res.next;
//        }
//        if(len == 1) {
//        	return lists[0];
//        }
//        
//        if(len == 2) {
//        	return mergeTwoLists(lists[0], lists[1]);
//        }
//        
//        if(len % 2 == 0) {
//        	ListNode[] left = new ListNode[len/2];//= Arrays.copyOfRange(lists, 0, (len-2)/2);
//        	ListNode[] right = new ListNode[len/2];//= Arrays.copyOfRange(lists, len/2, len-1);
//        	
//        	for (int i = 0; i < len/2; i++) {
//        		left[i] = lists[i];	
//        		right[i] = lists[i+(len/2)];
//        	}
//     	
//        	ListNode l1 = mergeKLists(left);
//        	ListNode l2 = mergeKLists(right);
//        	return mergeTwoLists(l1, l2);
//        } else {
//        	ListNode[] left = new ListNode[(len-1)/2];// = Arrays.copyOfRange(lists, 0, (len-3)/2);
//        	ListNode[] right = new ListNode[(len-1)/2];// = Arrays.copyOfRange(lists, (len-1)/2, len-2);
//        	
//        	for (int i = 0; i < (len-1)/2; i++) {
//        		left[i] = lists[i];	
//        		right[i] = lists[i+(len-1)/2];
//        	}       	
//        	
//        	ListNode l1 = mergeKLists(left);
//        	ListNode l2 = mergeKLists(right);
//        	return mergeTwoLists(mergeTwoLists(l1, l2), lists[len-1]);
//        }
//    }
//	
//	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//		
//		if(l1 == null) return l2;
//		if(l2 == null) return l1;
//		
//		if(l1.val < l2.val) {
//			l1.next = mergeTwoLists(l1.next, l2);
//			return l1;
//		} else {
//			l2.next = mergeTwoLists(l1, l2.next);
//			return l2;
//		}
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
//	
//	public static void main(String[] args) {
//		
//		MergeKList m = new MergeKList();
//		
//		ListNode list1 = new ListNode(1);
//		ListNode list2 = new ListNode(2);
//		ListNode list3 = new ListNode(6);
//		ListNode list4 = new ListNode(5);
//		list1.next = null;
//		list2.next = null;
//		list3.next = null;
//		list4.next = null;
//		for(int i = 3; i < 10; i+=2) {
//			ListNode temp1 = new ListNode(i);
//			ListNode tempHead1 = list1;
//			while(tempHead1.next != null) {
//				tempHead1 = tempHead1.next;
//			}
//			tempHead1.next = temp1;
//			
//			
//		}
//		
//		for(int i = 44; i < 56; i+=2) {
//			ListNode temp2 = new ListNode(i);
//			ListNode tempHead2 = list2;
//			while(tempHead2.next != null) {
//				tempHead2 = tempHead2.next;
//			}
//			tempHead2.next = temp2;
//		}
//		
//		for(int i = 15; i < 25; i+=2) {
//			ListNode temp3 = new ListNode(i);
//			ListNode tempHead3 = list3;
//			while(tempHead3.next != null) {
//				tempHead3 = tempHead3.next;
//			}
//			tempHead3.next = temp3;
//		}
//		
//		for(int i = 20; i < 29; i+=2) {
//			ListNode temp4 = new ListNode(i);
//			ListNode tempHead4 = list4;
//			while(tempHead4.next != null) {
//				tempHead4 = tempHead4.next;
//			}
//			tempHead4.next = temp4;
//		}
//		
//		m.show(list1);
//		System.out.println();
//		
//		m.show(list2);
//		System.out.println();
//		
//		m.show(list3);
//		System.out.println();
//		
//		m.show(list4);
//		System.out.println();
//		
//		ListNode[] lists = new ListNode[4]; 
//		lists[0] = list1;
//		lists[1] = list2;
//		lists[2] = list3;
//		lists[3] = list4;
//		
//		System.out.println();
//		
//		ListNode res = m.mergeKLists(lists);
//		m.show(res);
//		System.out.println();
//	}
//}
//
//
//
// 
//




////////////////////////////此方法不可用



//package leetCode;
//
//import java.util.Arrays;
//
//class ListNode {
//    int val;
//    ListNode next;
//    ListNode(int x) { val = x; }
//}
//
//
//public class MergeKList {
//
//	public ListNode mergeKLists(ListNode[] lists) {
//		
//        int len = lists.length;
//        
//        if(len == 0) {
//        	return null;
//        }
//        if(len == 1) {
//        	return lists[0];
//        }
//        
//        if(len == 2) {
//        	return mergeTwoLists(lists[0], lists[1]);
//        }
//        
//        ListNode[] lists2 = new ListNode[len+1];
//        
//        if(len % 2 == 0) {
//        	ListNode temp = null;       	
//        	for(int i = 0; i < len; i++) {
//        		lists2[i] = lists[i];
//        	}
//        	lists2[len] = temp;
//        	len++;
//        }
//        
//        ListNode[] left = new ListNode[(len-1)/2];// = Arrays.copyOfRange(lists, 0, (len-3)/2);
//        ListNode[] right = new ListNode[(len-1)/2];// = Arrays.copyOfRange(lists, (len-1)/2, len-2);
//        	
//        for (int i = 0; i < (len-1)/2; i++) {
//        	left[i] = lists2[i];	
//        	right[i] = lists2[i+(len-1)/2];
//        }       	
//        	
//        ListNode l1 = mergeKLists(left);
//        ListNode l2 = mergeKLists(right);
//      	return mergeTwoLists(mergeTwoLists(l1, l2), lists2[len-1]);
//        
//    }
//	
//	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//		
//		if(l1 == null) return l2;
//		if(l2 == null) return l1;
//		
//		if(l1.val < l2.val) {
//			l1.next = mergeTwoLists(l1.next, l2);
//			return l1;
//		} else {
//			l2.next = mergeTwoLists(l1, l2.next);
//			return l2;
//		}
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
//	
//	public static void main(String[] args) {
//		
//		MergeKList m = new MergeKList();
//		
//		ListNode list1 = new ListNode(1);
//		ListNode list2 = new ListNode(2);
//		ListNode list3 = new ListNode(6);
//		ListNode list4 = new ListNode(5);
//		list1.next = null;
//		list2.next = null;
//		list3.next = null;
//		list4.next = null;
//		for(int i = 3; i < 10; i+=2) {
//			ListNode temp1 = new ListNode(i);
//			ListNode tempHead1 = list1;
//			while(tempHead1.next != null) {
//				tempHead1 = tempHead1.next;
//			}
//			tempHead1.next = temp1;
//			
//			
//		}
//		
//		for(int i = 44; i < 56; i+=2) {
//			ListNode temp2 = new ListNode(i);
//			ListNode tempHead2 = list2;
//			while(tempHead2.next != null) {
//				tempHead2 = tempHead2.next;
//			}
//			tempHead2.next = temp2;
//		}
//		
//		for(int i = 15; i < 25; i+=2) {
//			ListNode temp3 = new ListNode(i);
//			ListNode tempHead3 = list3;
//			while(tempHead3.next != null) {
//				tempHead3 = tempHead3.next;
//			}
//			tempHead3.next = temp3;
//		}
//		
//		for(int i = 20; i < 29; i+=2) {
//			ListNode temp4 = new ListNode(i);
//			ListNode tempHead4 = list4;
//			while(tempHead4.next != null) {
//				tempHead4 = tempHead4.next;
//			}
//			tempHead4.next = temp4;
//		}
//		
//		m.show(list1);
//		System.out.println();
//		
//		m.show(list2);
//		System.out.println();
//		
//		m.show(list3);
//		System.out.println();
//		
//		m.show(list4);
//		System.out.println();
//		
//		ListNode[] lists = new ListNode[4]; 
//		lists[0] = list1;
//		lists[1] = list2;
//		lists[2] = list3;
//		lists[3] = list4;
//		
//		System.out.println();
//		
//		ListNode res = m.mergeKLists(lists);
//		m.show(res);
//		System.out.println();
//	}
//}


//////////////////////////////////////////效率最高

//package leetCode;
//
//import java.util.Arrays;
//
//class ListNode {
//    int val;
//    ListNode next;
//    ListNode(int x) { val = x; }
//}
//
//
//public class MergeKList {
//	
//	
//	
//	public ListNode mergeKLists(ListNode[] lists) {
//		
//		return mergeLists(lists, 0, lists.length-1);      
//    }
//	
//	public ListNode mergeLists(ListNode[] lists, int lo, int hi) {
//		
//		if(lo > hi) {
//			return null;
//		}
//		
//		int len = hi-lo+1;
//		if(len == 1) {
//			return lists[lo];
//		}
//		
//		ListNode left = mergeLists(lists, lo, lo+((len/2)-1));
//		ListNode Right = mergeLists(lists, lo+len/2 , hi);
//		return mergeTwoLists(left, Right);
//	}
//	
//	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//		
//		if(l1 == null) return l2;
//		if(l2 == null) return l1;
//		
//		if(l1.val < l2.val) {
//			l1.next = mergeTwoLists(l1.next, l2);
//			return l1;
//		} else {
//			l2.next = mergeTwoLists(l1, l2.next);
//			return l2;
//		}
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
//	
//	public static void main(String[] args) {
//		
//		MergeKList m = new MergeKList();
//		
//		ListNode list1 = new ListNode(1);
//		ListNode list2 = new ListNode(2);
//		ListNode list3 = new ListNode(6);
//		ListNode list4 = new ListNode(5);
//		list1.next = null;
//		list2.next = null;
//		list3.next = null;
//		list4.next = null;
//		for(int i = 3; i < 10; i+=2) {
//			ListNode temp1 = new ListNode(i);
//			ListNode tempHead1 = list1;
//			while(tempHead1.next != null) {
//				tempHead1 = tempHead1.next;
//			}
//			tempHead1.next = temp1;
//			
//			
//		}
//		
//		for(int i = 44; i < 56; i+=2) {
//			ListNode temp2 = new ListNode(i);
//			ListNode tempHead2 = list2;
//			while(tempHead2.next != null) {
//				tempHead2 = tempHead2.next;
//			}
//			tempHead2.next = temp2;
//		}
//		
//		for(int i = 15; i < 25; i+=2) {
//			ListNode temp3 = new ListNode(i);
//			ListNode tempHead3 = list3;
//			while(tempHead3.next != null) {
//				tempHead3 = tempHead3.next;
//			}
//			tempHead3.next = temp3;
//		}
//		
//		for(int i = 20; i < 29; i+=2) {
//			ListNode temp4 = new ListNode(i);
//			ListNode tempHead4 = list4;
//			while(tempHead4.next != null) {
//				tempHead4 = tempHead4.next;
//			}
//			tempHead4.next = temp4;
//		}
//		
//		m.show(list1);
//		System.out.println();
//		
//		m.show(list2);
//		System.out.println();
//		
//		m.show(list3);
//		System.out.println();
//		
//		m.show(list4);
//		System.out.println();
//		
//		ListNode[] lists = new ListNode[4]; 
//		lists[0] = list1;
//		lists[1] = list2;
//		lists[2] = list3;
//		lists[3] = list4;
//		
//		System.out.println();
//		
//		ListNode res = m.mergeKLists(lists);
//		m.show(res);
//		System.out.println();
//	}
//}

 

//////////////////////////////////////////////////////效率最低
//package leetCode;
//
//import java.util.Arrays;
//
//class ListNode {
//    int val;
//    ListNode next;
//    ListNode(int x) { val = x; }
//}
//
//
//public class MergeKList {
//	
//	
//	
//	public ListNode mergeKLists(ListNode[] lists) {
//		
//		int len = lists.length;
//		if(len == 0) return null;
//		if(len == 1) return lists[0];
//		
//		ListNode res = lists[0];
//		
//		for(int i = 1; i < len; i++) {
//			res = mergeTwoLists(res, lists[i]);
//		}
//		return res;
//    }
//	
//
//	
//	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//		
//		if(l1 == null) return l2;
//		if(l2 == null) return l1;
//		
//		if(l1.val < l2.val) {
//			l1.next = mergeTwoLists(l1.next, l2);
//			return l1;
//		} else {
//			l2.next = mergeTwoLists(l1, l2.next);
//			return l2;
//		}
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
//	
//	public static void main(String[] args) {
//		
//		MergeKList m = new MergeKList();
//		
//		ListNode list1 = new ListNode(1);
//		ListNode list2 = new ListNode(2);
//		ListNode list3 = new ListNode(6);
//		ListNode list4 = new ListNode(5);
//		list1.next = null;
//		list2.next = null;
//		list3.next = null;
//		list4.next = null;
//		for(int i = 3; i < 10; i+=2) {
//			ListNode temp1 = new ListNode(i);
//			ListNode tempHead1 = list1;
//			while(tempHead1.next != null) {
//				tempHead1 = tempHead1.next;
//			}
//			tempHead1.next = temp1;
//			
//			
//		}
//		
//		for(int i = 44; i < 56; i+=2) {
//			ListNode temp2 = new ListNode(i);
//			ListNode tempHead2 = list2;
//			while(tempHead2.next != null) {
//				tempHead2 = tempHead2.next;
//			}
//			tempHead2.next = temp2;
//		}
//		
//		for(int i = 15; i < 25; i+=2) {
//			ListNode temp3 = new ListNode(i);
//			ListNode tempHead3 = list3;
//			while(tempHead3.next != null) {
//				tempHead3 = tempHead3.next;
//			}
//			tempHead3.next = temp3;
//		}
//		
//		for(int i = 20; i < 29; i+=2) {
//			ListNode temp4 = new ListNode(i);
//			ListNode tempHead4 = list4;
//			while(tempHead4.next != null) {
//				tempHead4 = tempHead4.next;
//			}
//			tempHead4.next = temp4;
//		}
//		
//		m.show(list1);
//		System.out.println();
//		
//		m.show(list2);
//		System.out.println();
//		
//		m.show(list3);
//		System.out.println();
//		
//		m.show(list4);
//		System.out.println();
//		
//		ListNode[] lists = new ListNode[4]; 
//		lists[0] = list1;
//		lists[1] = list2;
//		lists[2] = list3;
//		lists[3] = list4;
//		
//		System.out.println();
//		
//		ListNode res = m.mergeKLists(lists);
//		m.show(res);
//		System.out.println();
//	}
//}


