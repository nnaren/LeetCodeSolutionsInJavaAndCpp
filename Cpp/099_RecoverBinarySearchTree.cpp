/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    void recoverTree(TreeNode* root) {
        inorder(root);
        exchangeValue(first, second);
    }
        
private:
    TreeNode *first = nullptr;
    TreeNode *second = nullptr;
    TreeNode *pre = nullptr;
    
    void inorder(TreeNode* root) {
        if (root == nullptr) return;
        inorder(root->left);
        
        if (pre != nullptr && pre->val > root->val) {
            if (first == nullptr) first = pre;
            second = root;
        }
        pre = root;
        
        inorder(root->right);
    }
    
    void exchangeValue(TreeNode* t1, TreeNode* t2) {
        int tmp = t1->val;
        t1->val = t2->val;
        t2->val = tmp;
    }
};
