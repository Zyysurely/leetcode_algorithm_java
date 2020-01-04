import java.util.*;

class Solution_78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for(int i=0; i<nums.length; i++) {
            int len = res.size();
            for(int j=0; j<len; j++) {
                ArrayList<Integer> tmp = new ArrayList<Integer>(res.get(j));
                tmp.add(nums[i]);
                res.add(tmp);
            }
        }
        return res;
    }
}