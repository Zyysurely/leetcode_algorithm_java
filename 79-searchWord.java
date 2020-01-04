class Solution_79 {
    
    public boolean exist(char[][] board, String word) {
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(dfs(board, i, j, word, 0)) return true;
            }
        }
        return false;
    }

    // 深度优先遍历
    private boolean dfs(char[][] board, int i, int j, String word, int index) {
        if(index == word.length()) return true;
        if(i<0 || i==board.length || j<0 || j==board[i].length) return false;
        if(board[i][j] != word.charAt(index)) {
            return false;
        }
        // 做已访问过的标记，这样根据ascii码就不用加那些额外的空间了！！！！！
        board[i][j] <<= 2;
        if (dfs(board, i+1, j, word, index+1) 
        || dfs(board, i-1, j, word, index+1) 
        || dfs(board, i, j+1, word, index+1) 
        || dfs(board, i, j-1, word, index+1)) {
            return true;
        }
        board[i][j] >>= 2;
        return false;
    }
}