/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution_543 {
    int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        depth(root);
        return res;
    }
    // 不一定过根节点，是所以过所有节点的时候都比较一次
    public int depth(TreeNode root) {
        if(root == null) return 0;
        int l =depth(root.left), r=depth(root.right);
        res = Math.max(res, l+r);
        return Math.max(l, r)+1;
    }
}