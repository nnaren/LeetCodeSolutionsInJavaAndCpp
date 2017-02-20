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
        if (head == nullptr) return head;
        if (head->next != nullptr && head->val == head->next->val) {
            while (head->next != nullptr && head->val == head->next->val) 
                head = head->next;
            return deleteDuplicates(head->next);
        } else 
            head->next = deleteDuplicates(head->next);
        return head;
    }
};


// method 2
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
        if (head == nullptr) return head;
        ListNode* fakeHead = new ListNode(0);
        fakeHead->next = head;
        ListNode* pre = fakeHead;
        ListNode* cur = head;
        
        while (cur != nullptr) {
            while (cur->next != nullptr && cur->next->val == cur->val)
                cur = cur->next;
            if (pre->next == cur)
                pre = pre->next;
            else 
                pre->next = cur->next;
            cur = cur->next;
        }
        return fakeHead->next;
    }
};
