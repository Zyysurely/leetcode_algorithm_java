// 动态规划思想，和62，63如出一辙
class Solution_64 {
    public int minPathSum(int[][] grid) {
        if(grid.length==0 || grid[0].length==0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int[] res = new int[n];
        int sum = 0;
        for(int i=0; i<n; i++) {
            sum += grid[0][i];
            res[i] = sum;
        }
        for(int i=1; i<m; i++) {
            res[0] += grid[i][0];
            for(int j=1; j<n; j++) {
               res[j] = Math.min(res[j-1], res[j]) + grid[i][j];
            }
        }
        return res[n-1];
    }
}