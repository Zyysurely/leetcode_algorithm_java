/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Solution_563 {
    int res = 0;
    public int findTilt(TreeNode root) {
        if(root == null) return 0;
        preOrder(root);
        return res;
    }
    int preOrder(TreeNode root) {
        if(root == null) return 0;
        int l = preOrder(root.left);
        int r = preOrder(root.right);
        res += Math.abs(l-r);
        return l+r+root.val;
    }
}
// 就是后续遍历