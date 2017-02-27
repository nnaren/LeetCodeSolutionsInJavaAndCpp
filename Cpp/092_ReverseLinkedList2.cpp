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
    ListNode* reverseBetween(ListNode* head, int m, int n) {
        if (head == nullptr || head->next == nullptr)
            return head;
        ListNode* temp = new ListNode(0);
        temp->next = head;
        ListNode* pre = temp;
        for (int i = 0; i < m-1; ++i) pre = pre->next;
        
        ListNode* start = pre->next;
        ListNode* then = start->next;
        for (int i = 0; i < n-m; ++i) {
            start->next = then->next;
            then->next = pre->next;
            pre->next = then;
            then = start->next;
        }
        return temp->next;
    }
};
