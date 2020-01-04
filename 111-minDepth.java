/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// 最小深度的时候注意，当左子树或者右子树为空的时候不构成子树的比较
class Solution_111 {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right != null) {
            return 1+minDepth(root.right);
        }
        if(root.right == null && root.left != null) {
            return 1+minDepth(root.left);
        }
        return 1+Math.min(minDepth(root.left), minDepth(root.right));
    }
}