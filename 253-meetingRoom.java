import java.util.*;

class Node {
    int start;
    int time;
    Node(int start, int time) {
        this.start = start; // start在后
        this.time = time;
    }
}

class NodeComparator implements Comparator<Node> {
    @Override
    public int compare(Node a, Node b) {
        if(a.time != b.time) return a.time-b.time;
        else return a.start - b.start;
    }
}

class Solution_253 {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        if(n<=1) return n;
        Node[] node = new Node[2*n];
        int index=0;
        for(int i=0; i<intervals.length; i++) {
            node[index++] = new Node(1, intervals[i][0]);
            node[index++] = new Node(0, intervals[i][1]);
        }
        Arrays.sort(node, new NodeComparator());
        int count=0, max=0;
        for(int i=0; i<node.length; i++) {
            if(node[i].start == 1) count++;
            else count--;
            max = Math.max(max, count);
        }
        return max;
    }
}