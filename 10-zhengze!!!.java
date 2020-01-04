class Solution_10 {
    public boolean isMatch(String s, String p) {
        return matchHelper(0, 0, s, p);
    }

    // 剑指offer上的递归做法，效率比较低
    public boolean matchHelper(int index, int pIndex, String s, String p) {
        if(index >= s.length() && pIndex >= p.length()) return true;
        if(index < s.length() && pIndex >= p.length()) return false;
        if(pIndex < p.length()-1 && p.charAt(pIndex+1) == '*') {
            if((index < s.length()) && (p.charAt(pIndex) == s.charAt(index) || p.charAt(pIndex) == '.')) {
                return matchHelper(index+1, pIndex+2, s, p) || matchHelper(index, pIndex+2, s, p) || matchHelper(index+1, pIndex, s, p);
            } else {
                return matchHelper(index, pIndex+2, s, p);
            }
        }
        if((index < s.length()) && (p.charAt(pIndex) == s.charAt(index) || p.charAt(pIndex) == '.')) return matchHelper(index+1, pIndex+1, s, p);
        return false;
    }

    // 动态规划算法
    public boolean isMatch_dp(String s, String p) {
        if(s == null || p == null) return false;
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];//s的前i个能否被p的前j个匹配
        dp[0][0] = true;
        // 初始化
        for(int i=0; i<p.length(); i++) {
            if(p.charAt(i) == '*' && dp[0][i-1]) {
                dp[0][i+1] = true;
            }
        }
        // 每个用前i个和前j个匹配
        for(int i=0; i<s.length(); i++) {
            for(int j=0; j<p.length(); j++) {
                if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
                    dp[i+1][j+1] = dp[i][j];
                }
                if(p.charAt(j) == '*') {  // 表示任意匹配前j-1个0到多次
                    if(p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) != '.') {
                        dp[i+1][j+1] = dp[i+1][j-1]; // 把那两个跳过
                    } else {
                        dp[i+1][j+1] = dp[i+1][j-1] || dp[i+1][j] || dp[i][j+1];
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}