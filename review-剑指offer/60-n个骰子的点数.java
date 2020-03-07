class Solution_offer_60 {
    public int diceSum(int n) {
        final int face = 6;
        final int pointSum = n*6;
        int[][] dp = new int[n+1][pointSum+1];
        for(int i=1; i<=face; i++) dp[1][i] = 1;
        for(int i=2; i<=n; i++) {
            for(int j=i; j<=pointSum; j++) {
                for(int k=1; k<=face && k<=j; k++) {
                    dp[i][j] += dp[i-1][j-k];
                }
            }
        }
        return 0;
    }
}