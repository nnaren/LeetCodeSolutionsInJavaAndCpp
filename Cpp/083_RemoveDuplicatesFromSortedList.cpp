// Edition 1
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
    ListNode* deleteDuplicates(ListNode* head) {
        if (head == nullptr || head->next == nullptr)
        	return head;
        ListNode *tmpHead = head, *start = nullptr;
        
        while (tmpHead != nullptr) {
        	if (tmpHead->next != nullptr && tmpHead->val == tmpHead->next->val) {
        		start = tmpHead->next;
        		while (start != nullptr && start->val == tmpHead->val)
        			start = start->next;
        		tmpHead->next = start;
        	}
        	tmpHead = tmpHead->next;
        }
        return head;
    }
};
