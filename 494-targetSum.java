class Solution_494 {
    public int findTargetSumWays(int[] nums, int S) {
        // 转成01背包问题
        int len = nums.length;
        if(len == 0) return -1;
        int sum = 0;
        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
        }
        // 不是对应的数量时
        if(sum < S || (sum+S)%2!=0) return 0;
        int l = (S+sum)/2;
        int[] dp = new int[l+1];
        dp[0] = 1;
        // 每个只能选一次的01背包问题
        for(int i=0; i<nums.length; i++) {
            // 从后往前是不重复的选择
            for(int j=l; j>=nums[i]; j--) {
                dp[j] += dp[j-nums[i]];
            }
        }
        return dp[l];
    }

    // 最慢的递归，2的n次方
    int res = 0;
    public int findTargetSumWays_dfs(int[] nums, int S) {
        // 转成01背包问题
        int len = nums.length;
        if(len == 0) return 0;
        // dfs解决
        dfs(nums, 0, 0, S);
        return res;
    }

    public void dfs(int[] nums, int index, int sum, int s) {
        if(index == nums.length) {
            if(sum == s) res++;
            return;}// 必须全部参与进来
        dfs(nums, index+1, sum-nums[index], s);
        dfs(nums, index+1, sum+nums[index], s);
    }
}