class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;
    TreeNode(int x) {val = x;}
}

class Solution_offer_68 {
    public TreeNode leastCommonAncestor(TreeNode root, TreeNode node1, TreeNode node2) {
        if(root == null) return null;
        if(root == node1) return node1;
        if(root == node2) return node2;
        TreeNode left = leastCommonAncestor(root.left, node1, node2);
        TreeNode right = leastCommonAncestor(root.right, node1, node2);
        if(left != null && right != null) return root;
        if(left == null) return right;
        if(right == null) return left;
        return null;
    }
}