class Solution_392 {
    public boolean isSubsequence(String s, String t) {
        int sLen=s.length(), tLen=t.length();
        boolean[][] dp = new boolean[sLen+1][tLen+1];
        dp[0][0] = true;
        for(int i=0; i<=tLen; i++) dp[0][i] = true;
        for(int i=1; i<=sLen; i++) {
            char c = s.charAt(i-1);
            for(int j=1; j<=tLen; j++) {
                dp[i][j] = dp[i][j-1];
                if(t.charAt(j-1) == c) dp[i][j] |= dp[i-1][j-1];
            }
        }
        return dp[sLen][tLen];
    }
}