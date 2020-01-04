import java.util.*;

class Solution_15 {
    // 从配对思路上考虑，注意去重
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0; i<nums.length-2; i++) {
            if(i==0 || (i>0 && nums[i] != nums[i - 1])) {
                int cur = nums[i];
                int first = i+1;
                int last = nums.length-1;

                while(first<last) {
                    int sum = nums[first] + nums[last] + cur;
                    if(sum == 0) {
                        res.add(Arrays.asList(cur, nums[first], nums[last]));
                        while(first<last && nums[first] == nums[first+1]) first++;
                        while(first<last && nums[last] == nums[last-1]) last--;
                        first++;
                        last--;
                    } else if(sum < 0) {
                        while(first<last && nums[first]==nums[first+1]) first++;
                        first++;
                    } else {
                        while(first<last && nums[last]==nums[last-1]) last--;
                        last--;
                    }
                }
            }
        }
        return res;
    }
}