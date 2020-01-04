import java.util.*;

class Solution_406 {
    // 先从大到小排序，再插入
    public int[][] reconstructQueue(int[][] people) {
        // 重排
        Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);
        LinkedList<int[]> res = new LinkedList<>();

        for(int i=0; i<people.length; i++) {
            res.add(people[i][1], people[i]);
        }
        return res.toArray(people);
    }
}