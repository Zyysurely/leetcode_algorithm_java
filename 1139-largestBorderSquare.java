class Solution_1139 {
    public int largest1BorderedSquare(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        int[][][] dp = new int[row+1][col+1][2];
        int res = 0;
        // 0 up 1 left
        for(int i=1; i<=row; i++) {
            for(int j=1; j<=col; j++) {
                if(grid[i-1][j-1] == 0) continue;
                dp[i][j][0] = dp[i-1][j][0] + 1;
                dp[i][j][1] = dp[i][j-1][1] + 1; // 按照边的长度dp
                int min = Math.min(dp[i][j][0], dp[i][j][1]);
                for(int k=0; k<min; k++) {
                    // 判断另外两边的长度
                    if(dp[i-k][j][1]>= k+1 && dp[i][j-k][0] >= k+1) res = Math.max(res, k+1);
                }
            }
        }
        return res*res;
    }
}