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
    vector<TreeNode *> generateTrees(int n) {
        vector<TreeNode *> res;
        if (n == 0) return res;
        return genTreeList(1, n);
    }
    
    vector<TreeNode *> genTreeList (int start, int end) {
        vector<TreeNode *> res;
        if (start > end)
            res.push_back(nullptr);
        for (int i = start; i <= end; ++i) {
            vector<TreeNode *> leftList = genTreeList(start, i-1);
            vector<TreeNode *> rightList = genTreeList(i+1, end);
            for (TreeNode *l : leftList) {
                for(TreeNode *r : rightList) {
                    TreeNode *root = new TreeNode(i);
                    root->left = l;
                    root->right = r;
                    res.push_back(root);
                } 
            }
        }
        return res;
    }
};
