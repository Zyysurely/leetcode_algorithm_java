class NumMatrix_204 {
    static int[][] sum = null;
    public NumMatrix(int[][] matrix) {
        if(matrix.length < 1) return;
        sum = new int[matrix.length][matrix[0].length+1];
        for(int i=0; i<matrix.length; i++) {
            int add = 0;
            for(int j=1; j<=matrix[0].length; j++) {
                add += matrix[i][j-1];
                sum[i][j] = add;
            }
        }
    }
    // 因为是多次sumRegion，所以要用动态规划来计算
    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(row1 > row2 || col1 > col2 || sum == null) return 0;
        int res = 0;
        for(int i=row1; i<=row2; i++) {
            res += sum[i][col2+1] - sum[i][col1];
        }
        return res;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */