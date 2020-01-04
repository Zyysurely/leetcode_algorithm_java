import java.util.*;

class Solution_207 {
    // 有向图无环的问题，这x个也是拓扑排序的例子                                                                                                                                                                                                                                                                                                               
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses == 0) return true;
        int[] dp = new int[numCourses];
        Queue<Integer> queue = new LinkedList<Integer>();
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        // 存入度和临接表
        for(int i=0; i<prerequisites.length; i++) {
            dp[prerequisites[i][0]] += 1;
            ArrayList<Integer> temp = map.get(prerequisites[i][1]);
            if(temp == null) {
                temp = new ArrayList<Integer>();
                temp.add(prerequisites[i][0]);
                map.put(prerequisites[i][1], temp);
            } else {
                temp.add(prerequisites[i][0]);
            }
        }
        // 有哪些入口
        for(int i=0; i<numCourses; i++) {
            if(dp[i] == 0) {queue.add(i);}
        }
        // 宽度优先遍历
        while(queue.peek()!=null) {
            int val = queue.poll();
            if(map.get(val) == null) continue;
            for(int i=0; i<map.get(val).size(); i++) {
                dp[map.get(val).get(i)]--;
                if(dp[map.get(val).get(i)] == 0) queue.add(map.get(val).get(i));
            }
        }
         for(int i=0; i<numCourses; i++) {
            if(dp[i] != 0) return false;
        }
        return true;
    }
}