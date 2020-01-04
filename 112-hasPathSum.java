// Definition for a binary tree node.
 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

// 递归思想需要注意
class Solution_112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        if(root.left==null && root.right == null) return root.val-sum==0;
        return hasPathSum(root.left, sum-root.val)||hasPathSum(root.right, sum-root.val);
    }
    
}