import java.util.*;

class Solution_47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> one = new ArrayList<Integer>();
        for(int i=0; i<nums.length; i++) {
            one.add(nums[i]);
        }
        permute(res, one, 0, nums.length);
        return res;
    }
    
    public void permute(List<List<Integer>> res, List<Integer> one, int first, int n) {
        if(first == n) {
            res.add(new ArrayList<>(one));
        }
        // 加一个防止重复的flag即可
        HashMap<Integer, Boolean> visited = new HashMap<Integer, Boolean>();
        for(int i=first; i<n; i++) {
            if(!visited.containsKey(one.get(i))) {
                Collections.swap(one, first, i);
                permute(res, one, first+1, n);
                Collections.swap(one, first, i);
                visited.put(one.get(i), true);
            }
        }
    }
}