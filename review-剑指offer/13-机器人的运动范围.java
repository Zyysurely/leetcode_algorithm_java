
class Solution_offer_13 {
    int res;
    public int movingCount(int[][] matrix, int num) {
        if(matrix.length == 0 || matrix[0].length == 0) return 0;
        boolean[][] marked = new boolean[matrix.length][matrix[0].length];
        dfs(matrix, 0, 0, num, marked);
        return res;
    }

    private void dfs(int[][] matrix, int i, int j, int num, boolean[][] marked) {
        if(i<0 || i>=matrix.length || j<0 || j>=matrix[0].length || marked[i][j]) return;
        marked[i][j] = true;
        if(digitNum(i) + digitNum(j) != num) return;
        res ++;
        dfs(matrix, i+1, j, num, marked);
        dfs(matrix, i-1, j, num, marked);
        dfs(matrix, i, j+1, num, marked);
        dfs(matrix, i, j-1, num, marked);
    }

    private int digitNum(int num) {
        int res = 0;
        while(num != 0) {
            res += num%10;
            num /= 10;
        }
        return res;
    }
}