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
class Solution_272 {
    LinkedList<Integer> res = new LinkedList<>();
    TreeNode pre;
    boolean nearest = false;
    int count = 0;
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        if(root == null || k==0) return res;
        inOrder(root, k, target);
        int l=0, r=res.size()-1;
        while(r-l+1 > k) {
            if(Math.abs(res.peekFirst()-target) > Math.abs(res.peekLast()-target)) {
                res.pollFirst();l++;
            } else {
                res.pollLast();r--;
            }
        }
        return res;
    }
    private void inOrder(TreeNode root, int k, double target) {
        if(root == null) return;
        inOrder(root.left, k, target);
        if(!nearest && pre!=null && pre.val <= target && root.val >= target) {
            nearest = true;
            if(res.size() > k) {
                for(int i=0; i<res.size() - k; i++) res.pollLast();
            }
        }
        res.add(root.val);
        if(nearest) count++;
        if(count == k) return;
        inOrder(root.right, k, target);
    }
}