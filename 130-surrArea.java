class Solution_130 {
    public void solve(char[][] board) {
        if(board.length==0 || board[0].length == 0) return;
        int row = board.length;
        int col = board[0].length;
        for(int i=0; i<row; i++) {
            dfs(board, i, 0);
            dfs(board, i, col-1);
        }
        for(int i=0; i<col; i++) {
            dfs(board, 0, i);
            dfs(board, row-1, i);
        }
        for(int i=0; i<=row-1; i++) {
            for(int j=0; j<=col-1; j++) {
                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if(board[i][j] == '-'){
                    board[i][j] = 'O';
                } 
            }
        } 
    }
    
    public void dfs(char[][] board, int l, int r) {
        if(l<0 || r<0 || l>=board.length || r>= board[0].length || board[l][r]!='O') {
            return;
        }
        board[l][r] = '-';
        dfs(board, l-1, r);
        dfs(board, l+1, r);
        dfs(board, l, r-1);
        dfs(board, l, r+1);
        return;
    }
}