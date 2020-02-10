class Solution_714 {
    public int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        if(len == 0) return 0;
        int[] with = new int[len];
        int[] without = new int[len];
        with[0] = -prices[0];  // 一开始就小于购买了
        for(int i=1; i<len; i++) {
            with[i] = Math.max(with[i-1], without[i-1] - prices[i]);
            without[i] = Math.max(without[i-1], with[i-1] + prices[i] - fee);
        }
        return without[len-1];
    }

    public int maxProfit_better(int[] prices, int fee) {
        int len = prices.length;
        if(len == 0) return 0;
        int price = prices[0], res=0;
        for(int n:prices) {
            if(n<price) price = n;  // 找谷底
            else if(n>price+fee) {
                res += n-price-fee;
                price = n-fee;
            }
        }
        return res;
    }
}