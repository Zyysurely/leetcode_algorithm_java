
// 先找到父节点，再一直向左找到root，因为左必存在，返回也必须返回root，也就是最左的
class Solution_156 {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        return helper(null, root);
    }
    public TreeNode helper(TreeNode parent, TreeNode node) {
        if(node == null)
            return parent;
        TreeNode ret = helper(node, node.left);
        if(parent != null)
            node.left = parent.right;
        else 
            node.left = null;
        node.right = parent;
        return ret;
    }
}