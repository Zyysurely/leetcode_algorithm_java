import java.util.*;

class Solution_offer_29 {
    public List<Integer> printMatrix(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int l=0, r=matrix[0].length-1, u=0, d=matrix.length-1;
        while(l<=r && u<=d) {
            // 上右下左
            for(int i=l; i<=r; i++) res.add(matrix[u][i]);
            for(int i=u+1; i<=d; i++) res.add(matrix[i][r]);
            for(int i=r-1; i>=l; i--) res.add(matrix[d][i]);
            for(int i=d-1; i>u; i--) res.add(matrix[l][l]);
            l++; u++; r--; d--;
        }
        return res;
    }
}