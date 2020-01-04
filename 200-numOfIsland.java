class Solution_200 {
    public int numIslands(char[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) return 0;
        int count = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count ++;
                }
            }
        }
        return count;
    }
    
    public void dfs(char[][] grid, int i, int j) {
        if(i<0 || j<0 || i==grid.length || j == grid[0].length || grid[i][j] == '0' || grid[i][j] == '-') return;
        else grid[i][j] = '-';
        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
        dfs(grid, i, j-1);
        dfs(grid, i, j+1);
    }
}

// 这种二维度数组的查找问题，一般都是这种带标记的深度遍历问题
