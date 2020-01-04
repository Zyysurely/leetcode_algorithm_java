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

class Solution_437 {
    int psum;
    // 但是效率会比较差，毕竟每个点都要递归一次，nlogn的时间复杂度
    // 双重递归，先递归每个节点，再以每个节点为root递归找符合的路，还是用全局变量比较好
    public int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;
        rootWalk(root, sum);
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        return psum;
    }
    // 先序遍历
    public void rootWalk(TreeNode root, int sum) {
        if(root == null) return;
        if(root.val == sum) {psum++;}
        rootWalk(root.left, sum-root.val);
        rootWalk(root.right, sum-root.val);
    }

    ///----------------
    // 类似于求多项式前n项和
    public int pathSum_2(TreeNode root, int sum) {
        if(root == null) return 0;
        HashMap<Integer, Integer> path = new HashMap<Integer, Integer>();
        path.put(0, 1);
        rootWalk(root, sum, path, 0);
        return psum;
    }
    // 求多项式和
    public void rootWalk(TreeNode root, int sum, HashMap<Integer, Integer> path, int count) {
        if(root == null) return;
        count += root.val;
        if(path.containsKey(count-sum)) psum+=path.get(count-sum);
        // 需要回溯，因为当这个为底的走完了，会回到这个点的母节点
        path.put(count, path.getOrDefault(count, 0) + 1);
        rootWalk(root.left, sum, path, count);
        rootWalk(root.right, sum, path, count);
        path.put(count, path.get(count)-1);
    }
}