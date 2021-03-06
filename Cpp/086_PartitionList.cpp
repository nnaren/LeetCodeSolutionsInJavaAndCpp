// Good
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
    ListNode *partition(ListNode *head, int x) {
        ListNode node1(0), node2(0);
        ListNode *p1 = &node1, *p2 = &node2;
        while (head) {
            if (head->val < x)
                p1 = p1->next = head;
            else
                p2 = p2->next = head;
            head = head->next;
        }
        p2->next = NULL;
        p1->next = node2.next;
        return node1.next;
    }
};

// Bad
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
    ListNode* partition(ListNode* head, int x) {
        if (head == nullptr || head->next == nullptr) return head;
        ListNode *left = new ListNode(0);
        ListNode *right = new ListNode(0);
        ListNode *ltmp = left;
        ListNode *rtmp = right;
        while (head != nullptr) {
        	
        	if (head->val < x) {
        		ltmp->next = head;
        		ltmp = ltmp->next;
        	} else {
        		rtmp->next = head;
        		rtmp = rtmp->next;
        	}
        	head = head->next;
        }
        
        ltmp->next = nullptr;
        rtmp->next = nullptr;
        
        if (left->next == nullptr) return right->next;
        else if(right->next == nullptr) return left->next;
        else {
        	ltmp->next = right->next;
        	return left->next;
        }
    }
};
