class Solution_5 {
    // 动态规划算法
    public String longestPalindrome_DP(String s) {
        if(s==null || s.length()==0) return "";
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        dp[0][0] = true;
        int maxLen = 1;
        String res = s.substring(0, 1);
        for(int r=1; r<len; r++){
            for(int l=0; l<r; l++){
                if((s.charAt(r) == s.charAt(l)) && (r-l<=2||dp[l+1][r-1])){
                    dp[l][r] = true;
                    if(r-l+1 > maxLen){
                        res = s.substring(l, r+1);
                        maxLen = r-l+1;
                    }
                }
            }
        }
        return res;
    }

    // 马拉车算法
    public String longestPalindrome_Manacher(String s) {
        if(s==null||s.length()==0) return "";
        String sDiv = divideStr_Manacher(s);
        int len = sDiv.length();
        int[] p = new int[len];
        int id=0;
        int maxDis = 0;
        int resLength = 1;
        String res = s.substring(0,1);
        for(int i=0;i<len;i++){
            if(i<maxDis){
                p[i] = Integer.min(p[2*id - i], maxDis-i);
            } else {
                p[i] = 1;
            }
            while(i-p[i]>=0&&i+p[i]<len&&sDiv.charAt(i-p[i]) == sDiv.charAt(i+p[i])){
                p[i]++;
            }
            if(i+p[i] > maxDis){
                maxDis = i+p[i];
                id = i;
            }
            if(p[i]-1 > resLength){
                resLength = p[i]-1;
                res = sDiv.substring(i-p[i]+1, i+p[i]).replace("#", "");
            }
        }
        return res;
    }
    public String divideStr_Manacher(String s){
        StringBuilder res = new StringBuilder();
        int len = s.length();
        res.append('#');
        for(int i=0; i<len; i++){
            res.append(s.charAt(i));
            res.append('#');
        }
        return res.toString();
    }
    
    // 中心扩展算法(目前最快的方法)
    public String longestPalindrome_Mid(String s) {
        if(s==null||s.length()==0) return "";
        int[] range = new int[2];
        for(int i=0; i<s.length(); i++){
            midAppend_Mid(s, i, range);
        }
        return s.substring(range[0], range[1]+1);
        
    }
    public void midAppend_Mid(String s, int low, int[] range){
        int high = low;
        // 与中心相等处扩展
        while(high<s.length()-1 && s.charAt(high+1)==s.charAt(low)){
            high++;
        }
        while(low>0 && high<s.length()-1 && s.charAt(low-1) == s.charAt(high+1)) {
            low--;
            high++;
        }
        if(high-low>range[1] - range[0]){
            range[0] = low;
            range[1] = high;
        }
    }
    
    // public static void main(String[] args) {
    //     Solution_5 solu = new Solution_5();
    //     // String s= solu.longestPalindrome("ccc");
    //     // System.out.println(s);
    // }
}