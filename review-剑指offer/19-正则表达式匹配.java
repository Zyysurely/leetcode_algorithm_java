class Solution_offer_19 {
    public boolean match(char[] pattern, char[] str) {
        if(str.length == 0) return true;
        if(pattern.length == 0) return false;
        boolean[][] dp = new boolean[str.length+1][pattern.length+1];
        // *的初始化
        for(int i=1; i<=pattern.length; i++) {
            if(pattern[i-1] == '*') dp[0][i] = dp[0][i-2];
        }
        for(int i=1; i<=str.length; i++) {
            for(int j=1; j<=pattern.length; j++) {
                if(str[i-1] == pattern[j-1] || pattern[j-1] == '.') dp[i][j] = true;
                else if(pattern[j-1] == '*') {
                    if(str[i-2] == pattern[j-1]) {
                        dp[i][j] = dp[i-1][j-2] || dp[i][j-1] || dp[i][j-2];
                    } else {
                        dp[i][j] = dp[i][j-2];
                    }
                }
            }
        }
        return dp[str.length][pattern.length];
    }
}