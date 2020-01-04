class Solution_121 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len == 0) return 0;
        int min = prices[0], max = 0;
        for(int i=1; i<len; i++){
            max = Math.max(max, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return max;
    }
}