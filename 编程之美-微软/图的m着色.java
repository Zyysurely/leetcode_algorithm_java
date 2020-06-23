class Solution {
    int[] res;
    public int[] colorM(int[][] matrix, int m, int n) {
        if(matrix.length == 0 || matrix[0].length == 0) return res;;
        int[] res = new int[n];
        dfs(0, n, m, matrix);
        return res;
    }

    private boolean colored(int k, int[][] matrix) {
        for(int i=)
    }

    private void dfs(int k, int n, int m, int[][] matrix) {
        if(k == n+1) return;
        for(int i=1; i<=m; i++) {
            res[k] = i;
            if(!colored(k, matrix)) dfs(k+1, n, m, matrix);
            res[k] = 0;
        }
    }
}