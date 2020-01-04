class Solution {
    // LCS
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        if(len1 == 0 || len2 == 0) return 0;
        int[][] res = new int[len1+1][len2+1];
        for(int i=1; i<len1+1; i++) {
            for(int j=1; j<len2+1; j++) {
                if(text1.charAt(i-1) == text2.charAt(j-1)) {
                    res[i][j] = res[i-1][j-1]+1;
                } else {
                    res[i][j] = Math.max(res[i][j-1], res[i-1][j]);
                }
            }
        }
        return res[len1][len2];
    }
} 