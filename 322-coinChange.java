// 动态规划的凑硬币模型，注意内外层循环分别是什么，有多少种方法凑成这个钱，所以是组合问题并不是排列问题，不能重复，可以用排序后的dfs
import java.util.*;

class Solution_322 {
    // 动态规划思想，从底到上 
    public int coinChange(int[] coins, int amount) {
        if(coins.length == 0) return -1;
        if(amount == 0) return 0;
        int[] dp = new int[amount+1];
        Arrays.fill(dp, -1);
        for(int coin:coins ) {
            if(dp.length>coin){
                dp[coin] = 1;
            }
            for(int i=coin; i<=amount; i++) {
                if(dp[i] != -1 && dp[i-coin]!=-1) {
                    dp[i] = Math.min(dp[i], dp[i-coin]+1);} 
                else if(dp[i-coin] != -1) dp[i] = dp[i-coin]+1;
            }
        }
        return dp[amount];
    }

    // 贪心加减枝，也就是排序加dfs，画树状图就可以清晰看出
    int minValue;
    public int coinChange_dfs(int[] coins, int amount) {
        minValue =  Integer.MAX_VALUE;
        if(coins.length == 0) return -1;
        if(amount == 0) return 0;
        Arrays.sort(coins);
        useNext(0, amount, coins, coins.length-1);
        if(minValue == Integer.MAX_VALUE) return -1;
        return minValue;
    }
    public void useNext(int i, int amount, int[] coins, int n) {
        if(amount == 0) {
            minValue = Math.min(minValue, i);
            return ;
        }
        // 不用往下走了
        if(n<0 || i+amount/coins[n] >= minValue) return;
        for(int j=amount/coins[n]; j>=0; j--) { // 尽量使用大的。每个递归其实就是先用大的在补
            useNext(i+j, amount-coins[n]*j, coins, n-1);
        }
    }
}