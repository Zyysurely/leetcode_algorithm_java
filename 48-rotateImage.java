class Solution_48 {
    public void rotate(int[][] matrix) { // n*n的大小的矩阵，从外层到内层
        int n = matrix.length;
        if(n == 0||n == 1) return;
        for(int i=0; i<n/2; i++) {
            int p = i;
            int q = n-1-i;
            while(p < n-1-i){            // 新矩阵第一行从第一个到倒数第二个
                int tmp = matrix[i][p];  // 左上
                matrix[i][p] = matrix[q][i]; // 左下到左上
                matrix[q][i] = matrix[n-1-i][q]; // 右下到左下
                matrix[n-1-i][q] = matrix[p][n-1-i]; // 右上到右下
                matrix[p][n-1-i] = tmp; // 左上到右上
                p++;
                q--;
            }
        }
    }
}