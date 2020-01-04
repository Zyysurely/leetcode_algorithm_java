class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution_404 {
    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        inOrder(root);
        return sum;
    }
    void inOrder(TreeNode root) {
        if(root == null) return;
        inOrder(root.left);
        if(root.left != null && root.left.left==null && root.left.right == null) sum += root.left.val;
        inOrder(root.right);
    }

}