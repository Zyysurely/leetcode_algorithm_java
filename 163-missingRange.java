import java.util.*;

class Solution_163 {
    // 每次都把左边界修改截断，相当于为开头时的思考
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        long l=lower, r=upper;
        for(int i=0; i<nums.length; i++) {
            if(nums[i]-l == 1) {
                res.add(String.valueOf(l));
            } else if(nums[i]-l > 1) {
                res.add(l + "->" + (nums[i]-1));
            }
            l = (long) nums[i]+1;
        }
        if(l==r) res.add(String.valueOf(l));
        else if(l<r) res.add(l+"->"+r);
        return res;
    }
}