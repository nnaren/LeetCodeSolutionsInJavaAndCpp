// Edition 1
class Solution {
public:
    ListNode* deleteDuplicates(ListNode* head) {
        if(head == nullptr || head->next == nullptr) return head;
        head->next = deleteDuplicates(head->next);
        return head->val == head->next->val ? head->next : head;
    }
};

// Edition 2
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
        ListNode *tmpHead = head;
        
        while (tmpHead != nullptr) {
        	if (tmpHead->next != nullptr && tmpHead->val == tmpHead->next->val) {
        		tmpHead->next = tmpHead->next->next;
        	} else 
        	    tmpHead = tmpHead->next;
        }
        return head;
    }
};


// Edition 3
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
