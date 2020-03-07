
class Solution_offer_12 {
    public boolean hasPath(char[][] matrix, String path) {
        if(matrix.length == 0 || matrix[0].length == 0) return false;
        if(path.length() == 0) return true;
        boolean[][] marked = new boolean[matrix.length][matrix[0].length];
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                if(helper(matrix, i, j, path, 0, marked)) return true;
            }
        }
        return false;
    }

    private boolean helper(char[][] matrix, int i, int j, String path, int way, boolean[][] marked) {
        if(i<0 || i>=matrix.length || j<0 || j>=matrix[0].length || marked[i][j] || matrix[i][j] != path.charAt(way)) return false;
        if(way == path.length()) return true;
        marked[i][j] = true;
        if(!marked[i][j] && matrix[i][j] == path.charAt(way)) {
            return helper(matrix, i+1, j, path, way+1, marked) ||
                    helper(matrix, i-1, j, path, way+1, marked) ||
                    helper(matrix, i, j+1, path, way+1, marked) ||
                    helper(matrix, i, j-1, path, way+1, marked);
        }
        marked[i][j] = false;
        return false;
    }
}