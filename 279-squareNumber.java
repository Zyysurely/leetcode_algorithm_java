class Solution_279 {
    // 跟硬币找零钱是一样的做法
    public int numSquares(int n) {
        int[] dp = new int[n+1]; // 组成n需要的最小的完全平方数的个数
        dp[0] = 0;
        for(int i=1; i<=n; i++) {
            dp[i] = i;  //最坏就是全部为1
            for(int j=1; j*j<=i; j++) {   // 可选的平方数
                dp[i] = Math.min(dp[i], dp[i-j*j]+1);
            }
        }
        return dp[n];
    }
}