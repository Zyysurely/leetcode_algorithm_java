import java.util.*;

class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;
    TreeNode(int x) {val = x;}
} 
class Solution_offer_7 {
    HashMap<Integer, Integer> in = new HashMap<>();
    public TreeNode RebuildBinaryTree(int[] preOrder, int[] inOrder) {
        if(preOrder.length != inOrder.length || preOrder.length == 0) return null;
        for(int i=0; i<inOrder.length; i++) {
            // 无重复
            in.put(inOrder[i], i);
        }
        return helper(0, preOrder.length-1, preOrder, 0, preOrder.length-1, inOrder);
    }

    public TreeNode helper(int preL, int preR, int[] preOrder, int inL, int inR, int[] inOrder) {
        if(preL > preR || inL > inR) return null;
        TreeNode cur = new TreeNode(preOrder[preL]);
        int spli = in.get(preOrder[preL]);
        cur.left = helper(preL+1, preL+spli-inL, preOrder, inL, spli-1, inOrder);
        cur.right = helper(preL+spli-inL+1, preR, preOrder, spli+1, inR, inOrder);
        return cur;
    }
}