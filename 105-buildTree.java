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

// 通过中序和前序查找建立树
class Solution_105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0) return null;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(map, 0, preorder.length-1, preorder, 0, inorder.length-1, inorder);     
    }
    
    // 如果每个加上找pro就是 n方，通过hashmap解决了这个问题。
    public TreeNode build(HashMap<Integer, Integer> map, int preLeft, int preRight, int[] preorder, int inLeft, int inRight, int[] inorder) {
        if(preLeft > preRight || inLeft > inRight) {
            return null;
        }
        int pro = preorder[preLeft];
        int inIndex = inLeft;
        inLeft = map.get(pro);
        TreeNode root = new TreeNode(pro);
        root.left = build(map, preLeft+1, preLeft+inLeft-inIndex, preorder, inIndex, inLeft-1,inorder);
        root.right = build(map, preLeft+inLeft-inIndex+1, preRight, preorder, inLeft+1, inRight, inorder);
        return root;
    }
    public static void main(String[] args) {
        Solution_105 solu = new Solution_105();
        int[] A = new int[]{3,9,20,15,7};
        int[] B = new int[]{9,3,15,20,7};
        TreeNode s= solu.buildTree(A, B);
        System.out.println(s);
    }
    
}