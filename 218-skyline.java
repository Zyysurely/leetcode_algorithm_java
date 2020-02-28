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
