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

class Solution_257 {
    List<String> res = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null) return res;
        dfs(root, "");
        return res;
    }

    void dfs(TreeNode root, String s) {
        // 到叶节点才是一条路
        if(root.left == null && root.right == null) {res.add(s+root.val);return;}
        if(root.left!=null){
            dfs(root.left, s+root.val+"->");}
        if(root.right!=null){
            dfs(root.right, s+root.val+"->");}
    }
}