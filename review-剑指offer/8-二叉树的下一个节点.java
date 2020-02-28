class TreeNode {
    TreeNode left;
    TreeNode right;
    TreeNode father; // 指向父节点的指针
    int val;
    TreeNode(int x) {val = x;}
} 

class Solution_offer_8 {
    public TreeNode NextTreeNode(TreeNode t) {
        // 右子树不为空
        if(t.right != null) {
            TreeNode cur = t.right;
            while(cur.left!= null) {
                cur = cur.left;
            }
            return cur;
        } else {
            // 是祖先的左子树时
            while(t.father != null) {
                if(t == t.father.left) return t.father;
                t = t.father;
            }
        }
        return null;
    }
}