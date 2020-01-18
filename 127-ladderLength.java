import java.util.*;

// 也就是广度优先遍历的概念
class Solution_127 {
    // BFS加上只有距离为1，之间才会有边的存在，也就是两点之间的最短路径。参考树的层次遍历
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<String>();
        queue.add(beginWord);
        // 记忆化搜索，哪个点走过了
        boolean[] marked = new boolean[wordList.size()];
        int layer = 1;
        while(!queue.isEmpty()) {
            layer++;
            int size = queue.size();
            while(size > 0) {
                String cur = queue.poll();
                for(int i=0; i<wordList.size(); i++) {
                    if(marked[i]) continue;
                    String s = wordList.get(i);
                    if(isConnected(cur, s)) {
                        if(s.equals(endWord)) return layer;
                        queue.add(s);
                        marked[i] = true;
                    }
                }
                size--;
            }
        }
        return 0;
    }

    boolean isConnected(String s, String t) {
        int len = s.length();
        if(t.length() != len) return false;
        int diff = 0;
        for(int i=0; i<len; i++) {
            if(s.charAt(i) != t.charAt(i)) {
                if(diff != 0) return false;
                diff++;
            }
        }
        return true;
    }
    
}