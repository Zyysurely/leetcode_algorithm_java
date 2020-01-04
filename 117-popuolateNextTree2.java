
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

// 普通二叉树，找一层的最右边，从上到下，从右到左思考
class Solution_117 {
    public Node connect(Node root) {
        if(root == null) return null;
        if(root.left!=null){
            if(root.right!=null){
                root.left.next = root.right;
            } else {
                root.left.next = nextNode(root.next);
            }
        }
        if(root.right != null) {
            root.right.next = nextNode(root.next);
        }
        connect(root.right);
        connect(root.left);
        return root;
    }
    
    public Node nextNode(Node node) {
        if(node==null) return null;
        if(node.left!=null) return node.left;
        if(node.right!=null) return node.right;
        return nextNode(node.next);
    }
}