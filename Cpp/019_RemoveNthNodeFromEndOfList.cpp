#include <iostream>
using namespace std;


 //* Definition for singly-linked list.
 struct ListNode {
     int val;
     ListNode *next;
     ListNode(int x) : val(x), next(NULL) {}
};
 
//class Solution {
//public:
//    ListNode* removeNthFromEnd(ListNode* head, int n) {
//        ListNode *start = new ListNode(0);
//		ListNode *slow = start, *fast = start;
//		slow->next = head;
//
//		for (int i = 1; i <= n+1; i++) {
//			fast = fast->next;
//		}
//
//		while (fast != nullptr) {
//			slow = slow->next;
//			fast = fast->next;
//		}
//
//		slow->next = slow->next->next;
//		return start->next;
//    }
//};

 class Solution {
 public:
	 ListNode* removeNthFromEnd(ListNode* head, int n) {
		 int length = 0;
		 ListNode *temp = head;
		 while (temp != nullptr) {
			 length++;
			 temp = temp->next;
		 }

		 temp = head;
		 if (n == length) {
			 return head->next;
		 } else {
			 int nth = length+1-n;
			 int i = 1;
			 while (temp != nullptr) {
				 if (i == nth-1) {
					 break;
				 }
				 temp = temp->next;
				 i++;
			 }
			 temp->next = temp->next->next;
			 return head;
		 }
		 return head;
	 }
 };
