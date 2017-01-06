/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        return mergeLists(lists, 0, lists.size()-1);
    }

	ListNode* mergeLists(vector<ListNode *>& lists, int lo, int hi) {
		if(lo > hi) return nullptr;
		int len = hi-lo+1;
		if(len == 1) return lists[lo];

		ListNode* left = mergeLists(lists, lo, lo+(len/2)-1);
		ListNode* right = mergeLists(lists, lo+len/2, hi);
		return mergeTwoLists(left, right);
	}

	ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
		if(l1 == nullptr) return l2;
		if(l2 == nullptr) return l1;

		if (l1->val < l2->val) {
			l1->next = mergeTwoLists(l1->next, l2);
			return l1;
		} else {
			l2->next = mergeTwoLists(l1, l2->next);
			return l2;
		}
	}
};

///Another Solution
//ListNode *mergeKLists(vector<ListNode *> &lists) {
//     if(lists.empty()){
//         return nullptr;
//     }
//     while(lists.size() > 1){
//         lists.push_back(mergeTwoLists(lists[0], lists[1]));
//         lists.erase(lists.begin());
//         lists.erase(lists.begin());
//     }
//     return lists.front();
// }
// ListNode *mergeTwoLists(ListNode *l1, ListNode *l2) {
//     if(l1 == nullptr){
//         return l2;
//     }
//     if(l2 == nullptr){
//         return l1;
//     }
//     if(l1->val <= l2->val){
//         l1->next = mergeTwoLists(l1->next, l2);
//         return l1;
//     }
//     else{
//         l2->next = mergeTwoLists(l1, l2->next);
//         return l2;
//     }
// }
