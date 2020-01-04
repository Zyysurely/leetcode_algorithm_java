import java.util.*;


class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }

class Solution_145 {
    List<Integer> res = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        postOrder(root);
        return res;
    }

    // 递归算法
    void postOrder(TreeNode root) {
        if(root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        res.add(root.val);
    }

    // 非递归算法
    public List<Integer> postorderTraversal_2(TreeNode root) {
        Stack<TreeNode> cur = new Stack<>();
        if(root!=null) cur.push(root);
        TreeNode pre = null;
        while(!cur.isEmpty()) {
            TreeNode c = cur.peek();
            if((c.left==null && c.right==null) || (pre != null && (pre == c.left || pre == c.right))) {
                res.add(c.val);
                pre = c;
                cur.pop();
            } else {
                if(c.right != null) cur.push(c.right);
                if(c.left != null) cur.push(c.left);
            }

        }
        return res;
    }
}