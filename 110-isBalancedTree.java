/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution_110 {
    boolean flag = true;
    public boolean isBalanced(TreeNode root) {
        depth(root);
        return flag;
    }
    
    public int depth(TreeNode root) {
        if(root == null) return 0;
        int left = depth(root.left);
        int right = depth(root.right);
        if(Math.abs(left-right) > 1) {flag = false; return -1;} else {
        return 1+Math.max(left, right);}
    }
    
}