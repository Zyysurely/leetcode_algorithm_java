class Solution_378 {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        if(n==0) return 0;
        // 二分思想，这个行列都是有序的
        int min=matrix[0][0], max=matrix[n-1][n-1];
        while(min < max) {
            int mid = (min + max)/2;
            int count = getCount(matrix, mid);
            if(count < k) min = mid+1;
            else max=mid;
        }
        return min;                                                                                                                                                
    }
    // 从右往左
    public int getCount(int[][] matrix, int mid) {
        int count = 0, row=0, col=matrix.length-1;
        while(row<matrix.length && col>=0) {
            if(matrix[row][col] <= mid) {count += col+1; row++;}
            else {col--;}
        }
        return count;
    }
}