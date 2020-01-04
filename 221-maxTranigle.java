class Solution_221 {
    // 动态规划，dp[i][j]为以i和j为右下脚的正方形的最大边长
    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        if(row == 0) return 0;
        int col = matrix[0].length;
        int max = 0;
        int[][] dp = new int[row+1][col+1];
        for(int i=1; i<=row; i++) {
            for(int j=1; j<=col;j++) {
                if(matrix[i-1][j-1] == '1') {
                    // 等于上、左、左上为右下脚的最小边长
                    dp[i][j] = 1+Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
                    if(dp[i][j] > max) max = dp[i][j];
                }
            }
        }
        return max*max;
    }
}