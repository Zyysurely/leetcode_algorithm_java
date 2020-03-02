class Solution_offer_47 {
    public int maxValuePresent(int[][] nums) {
        int[] dp = new int[nums[0].length];
        dp[0] = nums[0][0];
        for(int i=1; i<nums[0].length; i++) dp[i] += dp[i-1] + nums[0][i];
        for(int i=1; i<nums.length; i++) {
            for(int j=0; j<nums[0].length; j++) {
                if(j == 0) dp[j] += nums[i][j];
                dp[j] = Math.max(dp[j], dp[j-1]) + nums[i][j];
            }
        }
        return dp[nums[0].length-1];
    }
}