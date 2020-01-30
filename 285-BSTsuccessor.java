/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution_285 {
    TreeNode pre = null;
    TreeNode res = null;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        inOrder(root, p);
        return res;
    }

    void inOrder(TreeNode root, TreeNode p) {
        if(root == null) return;
        inOrder(root.left, p);
        if(pre == p) {
            res = root;
        }
        pre = root;
        inOrder(root.right, p);
    }
}