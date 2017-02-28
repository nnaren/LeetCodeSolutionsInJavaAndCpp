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
        return generateTrees(1, n);
    }
    
    vector<TreeNode *> generateTrees(int start, int end) {
        vector<TreeNode *> trees;
        if (start > end) {
            trees.push_back(NULL);
            return trees;
        }

        for (int rootValue = start; rootValue <= end; rootValue++) {
            vector<TreeNode *> leftSubTrees = generateTrees(start, rootValue - 1);
            vector<TreeNode *> rightSubTrees = generateTrees(rootValue + 1, end);

            for (TreeNode *leftSubTree : leftSubTrees) {
                for (TreeNode *rightSubTree : rightSubTrees) {
                    TreeNode *root = new TreeNode(rootValue);
                    root->left = leftSubTree;
                    root->right = rightSubTree;
                    trees.push_back(root);
                }
            }
        }
        return trees;
    }
};
