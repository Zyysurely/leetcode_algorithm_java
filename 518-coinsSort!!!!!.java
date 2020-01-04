// 动态规划的凑硬币模型，注意内外层循环分别是什么，有多少种方法凑成这个钱，所以是组合问题并不是排列问题，不能重复，可以用排序后的dfs
class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for(int i=0; i<coins.length; i++) {
            for(int j=coins[i]; j<=amount; j++) {
                dp[j] += dp[j-coins[i]];
            }
        }
        return dp[amount];
    }
}