class Solution_198 {
    public int rob(int[] nums) {
        int len = nums.length;
        if(len == 0) return 0;
        if(len == 1) return nums[0];
        int[] dp = new int[len];
        int max = Math.max(nums[0], nums[1]);
        dp[0] = nums[0];
        dp[1] = nums[1];
        for(int i=2; i<len; i++) {
            if(i>2){
                dp[i] = nums[i] + Math.max(dp[i-2], dp[i-3]);}
            else dp[i] = nums[i] + dp[i-2];
            if(dp[i] > max) max = dp[i];
        }
        return max;
    }
}

// 抓住一个题目属性是最多空两格