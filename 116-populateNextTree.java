/*
// Definition for a Node.
*/
import java.util.*;

// 这个是个完美二叉树，叶子节点均在最后一层
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
class Solution_116 {
    // 层次遍历呗，效果比较差，而且用的不是常数空间
    public Node connect_level(Node root) {
        if(root == null) return null;
        Node pre = null;
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while(!queue.isEmpty()){
            int count = queue.size();
            while(count>0) {
                Node tmp = queue.poll();
                if(pre!=null) {
                    pre.next = tmp;
                }
                pre = tmp;
                if(tmp.left!=null) {
                    queue.add(tmp.left);
                }
                if(tmp.right!=null) {
                    queue.add(tmp.right);
                }
                count--;
            }
            pre.next = null;
            pre = null;
        }
        return root;
    }

    // 递归解法，从上到下，从左到右的思想
    public Node connect_split(Node root) {
        if(root == null) return null;
        if(root.left != null){
            root.left.next = root.right;
        }
        if(root.next != null && root.right!= null) {
            root.right.next = root.next.left;
        }
        connect_split(root.left);
        connect_split(root.right);
        return root;
    }
}