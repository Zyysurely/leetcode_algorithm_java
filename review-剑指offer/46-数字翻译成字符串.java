// import java.util.*;

class Solution_offer_46 {
    // List<List<Character>> res = new ArrayList<>();
    // List<Character> cur  = new ArrayList<>();
    // public List<List<Character>> translate(int[] nums) {
    //     if(nums.length == 0) return null;
    //     helper(nums, 0);
    //     return res;
    // }

    // private void helper(int[] nums, int index) {
    //     if(index == nums.length) res.add(new ArrayList<>(cur));
    //     cur.add(nums[index]-1+'a');
    //     helper(nums, index+1);
    //     cur.remove(cur.size()-1);
    //     if(index != nums.length-1 && nums[index] * 10 + nums[index] <= 26) {
    //         cur.add(nums[index] * 10 + nums[index]-1+'a');
    //         helper(nums, index+2);
    //         cur.remove(cur.size()-1);
    //     }
    // }

    // 多少种翻译方式，动态规划
    public int numofTranslate(int[] nums) {
        if(nums.length <= 1) return nums.length;
        // 前i位有多少种翻译方法
        int[] dp = new int[nums.length+1];
        dp[1] = 1;
        for(int i=2; i<=nums.length; i++) {
            dp[i] += dp[i-1];
            if(nums[i-1] == 0) continue;
            if(nums[i-1] + nums[i-2] * 10 <= 26) dp[i] += dp[i-2];
        }
        return dp[nums.length];
    }
}