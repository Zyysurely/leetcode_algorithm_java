/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution_337 {
    // 后序遍历dfs，递归思想就是到每个点考虑，抢劫还是不抢劫这个点 res,0是不抢劫，1是抢劫，
    int max = 0;
    public int rob(TreeNode root) {
        if(root == null) return 0;
        int[] res = postOrder(root);
        return Math.max(res[0], res[1]);
    }

    public int[] postOrder(TreeNode root) {
        if(root == null) return new int[2];
        int[] left = postOrder(root.left);
        int[] right = postOrder(root.right);
        int[] res = new int[2];
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]); // 因为这一层没有选，所以下一层可以选也可以不选
        res[1] = root.val + left[0] + right[0];// 这一层选了，下一层必须不选
        return res;
    }
    
}