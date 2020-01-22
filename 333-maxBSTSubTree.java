/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution_333 {
    public int largestBSTSubtree(TreeNode root) {
        if(root == null) return 0;
        if(isBST(root)) return numOfNode(root);
        int l = largestBSTSubtree(root.left);
        int r = largestBSTSubtree(root.right);
        return Math.max(l, r);
    }

    boolean isBST(TreeNode root) {
        if(root==null) return true;
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    boolean isBST(TreeNode root, int min, int max) {
        if(root==null) return true;
        if(root.val>min && root.val<max && isBST(root.left, min, root.val) && isBST(root.right, root.val, max)) return true;
        return false;
    }

    int numOfNode(TreeNode root) {
        if(root == null) return 0;
        return numOfNode(root.left)+numOfNode(root.right)+1;
    }
}