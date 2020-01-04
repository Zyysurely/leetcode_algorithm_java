class Solution_240 {
    // 这种数组最大的好处就是可以随机访问，从右上角开始访问起
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if(row == 0) return false;
        int col = matrix[0].length;
        if(col == 0) return false;
        int r = 0, index=col-1;
        while(index>=0 && r<row) {
            if(matrix[r][index] == target) {
                return true;
            } else if(matrix[r][index] > target) {
                index--;
            } else {
                r++;
            }
        }
        return false;
    }
}