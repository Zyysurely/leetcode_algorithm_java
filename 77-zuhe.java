import java.util.*;

class Solution_77 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        if(n<1 || k<1 || n<k) return res;
        List<Integer> cur = new ArrayList<>();
        next(1, n, k, cur);
        return res;
    }
    void next(int min, int max, int k, List<Integer> cur) {
        if(k==0) {
            res.add(new ArrayList<Integer>(cur));
            return ;
        }
        // 按照数组拼接并回溯的思想
        // 主要是max-k+1是一个优化的点，因为剩下的必须大于等于k，加上这个剪枝之后，有更好的优化
        for(int i=min; i<=max-k+1; i++) {
            cur.add(i);
            next(i+1, max, k-1, cur);
            cur.remove(cur.size()-1);
        }
    } 
}