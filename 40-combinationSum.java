import java.util.*;

class Solution_40 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(candidates.length == 0) return res;
        // 先排序再回溯剪枝
        Arrays.sort(candidates);       
        helper(0, candidates, target, new ArrayList<Integer>());
        return res;
    }
    public void helper(int index, int[] candidates, int target, List<Integer> cur) {
        if(target == 0) {
            res.add(new ArrayList<Integer>(cur));
            return;
        }
        for(int i=index; i<candidates.length; i++) {
            // 让同一层级不出现相同的元素，并且用i!=index避免把所有的情况都消除了
            if(i!=index && candidates[i] == candidates[i-1]) continue;
            if(candidates[i] <= target) {
                cur.add(candidates[i]);
                helper(i+1, candidates, target-candidates[i], cur);
                cur.remove(cur.size()-1);
            }
        }
    }
}