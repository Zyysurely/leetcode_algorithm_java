import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution_106 {
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length == 0) return null;
        for(int i=0; i<inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(0, inorder.length-1, inorder, 0, postorder.length-1, postorder);
    }
    
    public TreeNode build(int inLeft, int inRight, int[] inorder, int postLeft, int postRight, int[] postorder) {
        System.out.print(inLeft);
        System.out.print(inRight);
        System.out.print(postLeft);
        System.out.print(postRight);
        System.out.println();
        if(inLeft>inRight || postRight<postLeft) return null;
        int pro = postorder[postRight];
        TreeNode root = new TreeNode(pro);
        int index = map.get(pro);
        root.left = build(inLeft, index-1, inorder, postLeft, postLeft + index - inLeft-1, postorder);
        root.right = build(index+1, inRight, inorder, postLeft + index - inLeft, postRight-1, postorder);
        return root;
    }

    public static void main(String[] args) {
        Solution_106 solu = new Solution_106();
        int[] A = new int[]{9,3,15,20,7};
        int[] B = new int[]{9,15,7,20,3};
        TreeNode s= solu.buildTree(A, B);
        System.out.println(s);
    }
}