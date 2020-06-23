class Solution_547 {
    public int findCircleNum(int[][] M) {
        int row = M.length, col = M[0].length;
        int count = 0;
        boolean[] visited = new boolean[row];
        for(int i=0; i<row; i++) {
            if(!visited[i]) {
                dfs(M, visited, i);
                count++;
                }
        }
        return count;
    }

    public void dfs(int[][] M, boolean[] search, int i) {
        for(int j=0; j<M.length; j++) {
            if(!search[j] && M[i][j]==1){
                search[j] = true;
                dfs(M, search, j);
            }
        }
    }
}