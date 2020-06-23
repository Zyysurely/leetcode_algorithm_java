import java.util.*;

class Solution_218 {
    // 用一个堆实现扫描线法
    public class Node {
        int x;
        boolean start;
        int h;
        public Node(int x, boolean start, int h) {
            this.x = x;
            this.start = start;
            this.h = h;
        }
    }
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<Node> nodes = new ArrayList<>();
        PriorityQueue<Integer> pri = new PriorityQueue<Integer>((a1, a2)->a2 - a1);
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0; i<buildings.length; i++) {
            nodes.add(new Node(buildings[i][0], true, buildings[i][2]));
            nodes.add(new Node(buildings[i][1], false, buildings[i][2]));
        }
        Collections.sort(nodes, (a1, a2) -> a1.x-a2.x);

        int index=0, pre=0;
        while(index < nodes.size()) {
            Node cur = nodes.get(index);
            // 对于一个点的多个作用
            while(index < nodes.size() && nodes.get(index).x == cur.x) {
                Node in = nodes.get(index);
                if(in.start) {
                    pri.add(in.h);
                } else {
                    pri.remove(in.h);
                }
                index++;
            }
            Integer ch = pri.peek();
            if(ch == null) {
                ch=0;
            }
            if(ch != pre) {
                List<Integer> c = new ArrayList<>();
                c.add(cur.x);
                c.add(ch);
                res.add(c);
                pre = ch;
            }
        }
        return res;

    }
}


class Solution {
    public class Node{
        int x;
        boolean start;
        int h;
        public Node(int x, int h, boolean start) {
            this.x = x;
            this.h = h;
            this.start = start;
        }
    }
    public class NodeComparator implements Comparator<Node> {
        @Override
        public int compare(Node a, Node b) {
            if(a.x != b.x) return a.x-b.x;
            else {
                if(a.start != b.start) return a.start? -1 : 1;
                else return b.h-a.h;
            }
        }
    }

    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        if(buildings.length == 0) return res;
        Node[] node = new Node[2*buildings.length];
        int index = 0;
        for(int i=0; i<buildings.length; i++) {
            node[index++] = new Node(buildings[i][0], buildings[i][2], true);
            node[index++] = new Node(buildings[i][1], buildings[i][2], false);
        }
        Arrays.sort(node, new NodeComparator());
        PriorityQueue<Integer> pri = new PriorityQueue<Integer>((o1, o2) -> o2-o1);
        int pre = 0, i=0;
        while(i<node.length) {
            Node cr = node[i];
            while(i< node.length && cr.x == node[i].x) {
                cr = node[i];
                if(node[i].start) pri.add(node[i].h);
                else pri.remove(node[i].h);
                i++;
            }
            int cur = pri.peek()==null ? 0 :pri.peek();
            if(pre != cur) {
                List<Integer> c = new ArrayList<>();
                c.add(cr.x);
                c.add(cur);
                res.add(c);
                pre = cur;
            }
        }
        return res;
    }
}

//天际线问题