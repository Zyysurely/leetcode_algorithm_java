import java.util.*;

class Solution_114 {
    // 采用后序遍历，递归，通过分解子问题画图求解
    public void flatten_split(TreeNode root) {
        if(root == null) return;
        flatten_split(root.right);
        flatten_split(root.left);
        TreeNode re = root.left;
        if(re != null){
            while(re.right != null) {
                re = re.right;
            }
            re.right = root.right;
            root.right = root.left;
            root.left = null;
        }
    }

    // 非递归算法用栈实现，用栈实现
    public void flatten_iter(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(root != null || !stack.isEmpty()) {
            while(root!=null) {
                stack.push(root);
                root = root.left;
            }
            
            if(!stack.isEmpty()) {
                TreeNode node = stack.pop();
                TreeNode tmp = node.right;
                node.right = node.left;
                node.left = null;
                // 保存node的右子树，把右子树加到最右边
                while(node.right!=null) node = node.right;
                node.right = tmp;
                root = tmp;
            }
        }
    }

}