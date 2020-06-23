import java.util.*;

class Solution_188 {
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if(len == 0) return 0;
        if(k>len/2) { // 可以无限交易，贪心算法
            int res = 0;
            for(int i=0; i<len-1; i++) {
                if(prices[i+1] > prices[i]) res+=prices[i+1]-prices[i];
            }
            return res;
        }
        int[] with = new int[k+1]; // 第i天手上有股票
        int[] without = new int[k+1];
        Arrays.fill(with, -Integer.MAX_VALUE);
        for(int i=0; i<len; i++) {  //状态法
            for(int j=1; j<k+1; j++) {
                with[j] = Math.max(with[j], without[j-1]-prices[i]);
                without[j] = Math.max(without[j], with[j]+prices[i]);
            }
        }
        return without[k];
    }
}