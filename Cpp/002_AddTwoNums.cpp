class Solution {
public:
	ListNode *addTwoNumbers(ListNode *l1, ListNode *l2) {

		ListNode preHead(0), *p = &preHead;
		int extra = 0;

		while (l1 || l2 || extra) {

			int sum = (l1 ? l1->val : 0) + (l2 ? l2->val : 0) + extra;
			extra = sum / 10;
			p->next = new ListNode(sum % 10);
			p = p->next;
			l1 = l1 ? l1->next : l1;
			l2 = l2 ? l2->next : l2;
		}
			return preHead.next;
		}
};
void main() {
	Solution s;

	ListNode* a1 = new ListNode(1);
	//ListNode* a2 = new ListNode(8);
	//ListNode* a3 = new ListNode(3);
	//a1->next = a2;
	//a2->next = a3;
	//a3->next = NULL;



	ListNode* b1 = new ListNode(9);
	ListNode* b2 = new ListNode(9);
	//ListNode* b3 = new ListNode(1);
	b1->next = b2;
	//b2->next = b3;
	//b3->next = NULL;


	ListNode* res = s.addTwoNumbers(a1, b1);
	/*std::cout << res->val << " ";
	std::cout << (res->next == NULL) << " ";*/
	
	while (res != NULL)
	{
		std::cout << res->val << " ";
		res = res->next;
	}

}
