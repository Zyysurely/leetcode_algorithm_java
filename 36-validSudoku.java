class Solution_36 {
    private int[] rows = new int[9];
    private int[] columns = new int[9];
    private int[] boxes = new int[9];
    public boolean isValidSudoku(char[][] board) {
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                if(board[i][j] == '.') {continue;}
                int val = 1 << (board[i][j] - '1');
                int index = j/3 + 3*(i/3);
                // 如果没有重复，这三个每个异或的结果都应该为0
                if(((rows[i] | columns[j] | boxes[index]) & val) > 0) return false;
                rows[i] |= val;
                columns[j] |= val;
                boxes[index] |= val;
            }
        }
        return true;
    }
}