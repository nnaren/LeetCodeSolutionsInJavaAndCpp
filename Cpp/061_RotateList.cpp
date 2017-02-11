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
    ListNode* rotateRight(ListNode* head, int k) {
        if (head == nullptr || head->next == nullptr)
            return head;
        ListNode *dummy = new ListNode(0);
        dummy->next = head;
        ListNode *fast = dummy, *slow = dummy;
        int len;
        for (len = 0; fast->next != nullptr; len++)
            fast = fast->next;
            
        for (int j = len-k%len; j > 0; j--)
            slow = slow->next;
        
        fast->next = dummy->next;
        dummy->next = slow->next;
        slow->next = nullptr;
        return dummy->next;
    }
};
