
class Solution_offer_49 {
    public int uglyNum(int n) {
        int i2=0, i3=0, i5=0;
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i=1; i<n; i++) {
            int next2 = dp[i2]*2, next3 = dp[i3]*3, next5 =dp[i5]*5;
            dp[i] = Math.min(next2, Math.min(next3, next5));
            if(dp[i] == next2) i2++;
            if(dp[i] == next3) i3++;
            if(dp[i] == next5) i5++;
        }
        return dp[n-1];
    }
}