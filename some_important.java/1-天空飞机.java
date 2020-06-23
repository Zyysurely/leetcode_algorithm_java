
import java.util.Comparator;
import java.util.List;
import java.util.*;

class interval {
    int start;
    int end;
}

class Solution_1 {
    public class Node {
        int time;
        int start;
        public Node(int start, int time) {
            this.start = start;
            this.time = time;
        }
    }

    class NodeComparator implements Comparator<Node> {
        @Override
        public int compare(Node a, Node b) {
            if(a.time != b.time) return a.time-b.time;
            return a.start - b.start; // 降落0在起飞1前面，起飞在后面
        }
    }

    public int airplaneInSky(List<interval> line) {
        if(line == null || line.size() == 0) return 0;
        int n = line.size();
        Node[] air = new Node[2*n];
        int i=0;
        for(interval l:line) {
            air[i++] = new Node(1, l.start);
            air[i++] = new Node(0, l.end);
        }
        Arrays.sort(air, new NodeComparator());
        int count=0, max=0;
        for(i=0; i<air.length; i++) {
            if(air[i].start == 1) count++;
            else count--;
            max = Math.max(max, count);
        }
        return max;
    }

}