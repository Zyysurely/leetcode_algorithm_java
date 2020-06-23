

class rotateImgae {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if(n == 0) return;
        if(matrix[0].length != n) return;
        for(int i=0; i<n/2; i++) {
            int l=i, r=n-i-1;
            while(l<n-i-1) {
                int temp = matrix[i][l];
                matrix[i][l] = matrix[r][i];
                matrix[r][i] = matrix[n-1-i][r];
                matrix[n-1-i][r] = matrix[l][n-1-i];
                matrix[l][n-1-i] = temp;
                l++;
                r--;
            }
        }
    }
}