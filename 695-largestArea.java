// 这种都是dfs的问题
class Solution_695 {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    int area = dfs(grid, i, j);
                    max = Math.max(max, area);
                }
            }
        }
        return max;
    }

    public int dfs(int[][] grid,  int i, int j) {
        if(i>=grid.length || i<0 || j<0 || j>=grid[0].length || grid[i][j] == 0) return 0;
        grid[i][j] = 0;
        return dfs(grid,  i+1, j) + 
               dfs(grid,  i, j+1) + 
               dfs(grid,  i-1, j) + 
               dfs(grid,  i, j-1) + 1;
    }
}