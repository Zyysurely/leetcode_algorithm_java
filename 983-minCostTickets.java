class Solution_983 {
    // 每一张票到最后一天才付款
    public int mincostTickets(int[] days, int[] costs) {
        if(days.length == 0) return 0;
        int[] dp = new int[366];
        for(int i=0; i<days.length; i++) {
            dp[days[i]] = -1; // 标记去旅行
        }
        for(int i=1; i<=365; i++) {
            if(dp[i] == 0) dp[i] = dp[i-1];
            else {
                int a = dp[i-1] + costs[0];
                int b, c;
                if(i-7>0) b = dp[i-7]+costs[1];
                else b = costs[1];
                if(i-30>0) c = dp[i-30]+costs[2];
                else c = costs[2];
                dp[i] = Math.min(a, Math.min(b, c));
            }
        }
        return dp[days[days.length-1]];
    }
}