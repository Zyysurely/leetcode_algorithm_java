/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    // 转成lcs算法，就是一个找节点的问题，也就是遍历的问题
    public TreeNode lowestCommonAncestor_LCS(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestor_LCS(root.left, p, q);
        TreeNode right = lowestCommonAncestor_LCS(root.right, p, q);
        if(left != null && right != null){
            return root;
        } else if(left != null){
            return left;
        } else {
            return right;
        }
    }


    // 相交链表问题
    List<List<TreeNode>> res = new ArrayList<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        path(root, p, q, new ArrayList<TreeNode>());
        int l = res.get(0).size();
        int r = res.get(1).size();
        int i=0;
        TreeNode com = null;
        while(i<l && i<r) {
            if(res.get(0).get(i) != res.get(1).get(i)) {com = res.get(0).get(i-1); break;}
            i++;
        }
        if(i == l) com = res.get(0).get(l-1);
        if(i == r) com = res.get(1).get(r-1);
        return com;
    }

    public void path(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> li) {
        if(root == null) return;
        li.add(root);
        if(root == p || root == q) {
            res.add(new ArrayList<TreeNode>(li));
        }
        path(root.left, p, q, li);
        path(root.right, p, q, li);
        // 回溯路径删除
        li.remove(li.size()-1);
    }
}