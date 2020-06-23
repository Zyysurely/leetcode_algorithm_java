class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution_2 {
    public TreeNode findLargeTargetInBST(TreeNode root, int target) {
        if(root == null) return null;
        if(root.val <= target) return findLargeTargetInBST(root.right, target);
        else{
            TreeNode cur = findLargeTargetInBST(root.left, target);
            return cur.val <= target ? root : cur;
        }
    }
}