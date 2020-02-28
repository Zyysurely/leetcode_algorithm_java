class Solution_offer_4 {
    public boolean findNumInMatrix(int[][] matrix, int num) {
        int n = matrix.length;
        if(n == 0) return false;
        int m = matrix[0].length;
        if(m == 0) return false;
        int i=0, j=m-1;
        while(i < n && j>=0) {
            if(num == matrix[i][j]) return true;
            if(num > matrix[i][j]) i++;
            else j--;
        }
        return false;
    }
}