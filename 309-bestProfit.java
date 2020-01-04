class Solution_309 {
    // 首先想到的是三个维度，买入，卖出和冷冻
    // 也可以降成两个维度，持有和未持有股票
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len == 0) return 0;
        int[] hold = new int[len];
        int[] notHold = new int[len];
        hold[0] = 0-prices[0];
        for(int i=1; i<len; i++) {
            notHold[i] = Math.max(notHold[i-1], hold[i-1] + prices[i]);
            if(i < 2) hold[i] = Math.max(hold[i-1], 0-prices[i]);
            else hold[i] = Math.max(hold[i-1], notHold[i-2]-prices[i]);
        }
        // 最后一天一定是卖出
        return notHold[len-1];
    }
}