/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution_104 {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        if(l >= r){
            return l+1; 
        } else {
            return r+1;
        }
    }
}