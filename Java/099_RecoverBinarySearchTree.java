/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    private TreeNode first = null;
    private TreeNode second = null;
    private TreeNode pre = null;

    public void recoverTree(TreeNode root) {
        inorder(root);
        if (first != null)
            exchangeValue(first, second);
    }

    private void exchangeValue(TreeNode t1, TreeNode t2) {
        int temp = t1.val;
        t1.val = t2.val;
        t2.val = temp;
    }

    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        if (pre != null && pre.val > root.val) {
            if (first == null) first = pre;
            second = root;
        }
        pre = root;
        inorder(root.right);
    }
}
