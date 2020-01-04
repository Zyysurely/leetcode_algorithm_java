import java.util.*;

class Solution_139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        // 背包问题，前i-1个是否包括在在其中
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(int i=0; i<wordDict.size(); i++) {
            map.put(wordDict.get(i), 0);
        }
        boolean[] dp = new boolean[len+1];
        Arrays.fill(dp, false);
        dp[0] = true;
        for(int i=1; i<=len; i++) {
            for(int j=0; j<i; j++) {
                if(dp[j] && map.containsKey(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }
}