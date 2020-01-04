class Solution_122 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len == 0) return 0;
        int max = 0;
        for(int i=1; i<len; i++) {
            int pro =  prices[i] - prices[i-1];
            if(pro > 0) {
                max += pro;
            } 
        }
        return max;
    }
}