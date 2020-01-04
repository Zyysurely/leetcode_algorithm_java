import java.util.*;

// 也可以用动态规划算法来完成，类似于换硬币问题
class Solution_39 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        helper(new ArrayList<Integer>(), candidates, 0, target);
        return res;
    }
    
    public void helper(ArrayList<Integer> cur, int[] candidates, int index, int target) {
        // 递归的时候还是需要找最底的情况做底
        if(target < 0) return;
        if(target == 0) {
            res.add(new ArrayList<Integer>(cur)); //新开辟空间
            return;
        }
        for(int i=index; i<candidates.length; i++) {
            if(candidates[i] <= target){
                cur.add(candidates[i]);
                helper(cur, candidates, i, target-candidates[i]);
                cur.remove(cur.size()-1);
            }
        }
    }
}