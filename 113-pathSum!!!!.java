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
 // 回溯法的利用
class Solution_113 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        compare(root, sum, new ArrayList<Integer>());
        return res;
    }
    
    public void compare(TreeNode root, int sum, List<Integer> list) {
        if(root == null) return;
        list.add(root.val);
        if(root.left==null && root.right==null) {
            if(root.val == sum) {
                // 这里注意需要新建一个对象，否则后面指向会被清除
                res.add(new ArrayList<>(list));
            }
        }
        compare(root.left, sum-root.val, list); //左边结束后，如果返回，就把list左边的节点删除，之后再继续
        compare(root.right, sum-root.val, list);
        list.remove(list.size() - 1); //将访问的叶子节点删除
    }
}