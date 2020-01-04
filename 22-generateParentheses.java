import java.util.*;

class Solution_22 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        String cur = new String();
        dfs(cur, n, n, res);
        return res;
    }
    

    // 深度优先遍历 + 减枝
    public void dfs(String cur, int left, int right, List<String> res) {
        if(left == 0 && right == 0) {
            res.add(cur);
            return;
        }
        // 剩下的左括号的树木要小于等于剩下的右括号的树木
        if(left > 0) dfs(cur+"(", left-1, right, res);
        if(right - 1 >= left) dfs(cur + ")", left, right-1, res);
    }

    // 深度优先遍历 + 减枝  这个是最好的方法
    public void dfs_2(String cur, int left, int right, List<String> res, int n) {
        if(left == n && right == n) {
            res.add(cur);
            return;
        }
        // 已有的左括号数目要大于等于右括号
        if(left < n) dfs_2(cur+"(", left+1, right, res, n);
        if(right < left) dfs_2(cur + ")", left, right+1, res, n);
    }  

    // 动态规划算法 dp[i] = "(" + dp[l] + ")" + dp[r]  ...... l+r = i
    public List<String> generateParenthesis_dp(int n) {
        List<String> res = new ArrayList<String>();
        if(n==0) return res;
        List<List<String>> dp = new ArrayList<>(n);
        List<String> cur  = new ArrayList<String>();
        cur.add("");
        dp.add(cur);
        
        for(int i=1; i<=n; i++) {
            cur = new ArrayList<String>();
            for(int j=0; j<i; j++) {
                List<String> left = dp.get(j);
                List<String> right = dp.get(i-1-j);
                for(String s1:left){
                    for(String s2:right) {
                        cur.add("(" + s1 + ")" + s2);
                    }
                }
            }
            dp.add(cur);
        }
        return dp.get(n);
    }
}