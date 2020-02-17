class Solution_123 {
    public int maxProfit(int[] prices) {
        int firstBuy=Integer.MIN_VALUE;
        int firstSell=0;
        int SecBuy=Integer.MIN_VALUE;
        int SecSell=0;
        for(int price:prices) {
            firstBuy = Math.max(firstBuy, -price);
            firstSell = Math.max(firstSell, firstBuy+price);
            SecBuy = Math.max(SecBuy, firstSell-price);
            SecSell = Math.max(SecSell, SecBuy+price);
        }
        return SecSell;
    }
}