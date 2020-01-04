import java.util.*;

// 根据另一个旋转矩阵稍做修改
class Solution_54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if(matrix.length == 0) {
            return res;
        }
        int level = 0;
        int n = matrix[0].length;
        int m = matrix.length;
        int sum=n*m;
        while(res.size() <= sum) {
            
            if(res.size() >= sum) break;

            // 从左到右
            for(int k=level; k<n-level&&res.size() <= sum-1; k++){
                res.add(matrix[level][k]);
            }
            if(res.size() >= sum) break;

            
            // 从上到下
            for(int k=level+1; k<m-level&&res.size() <= sum-1; k++){
                res.add(matrix[k][n-1-level]);
            }
            if(res.size() >= sum) break;


            //从右到左
            for(int k=n-2-level; k>=level&&res.size() <= sum-1; k--){
                res.add(matrix[m-1-level][k]);
            }
            
            if(res.size() >= sum) break;
            
             //从下到上
            for(int k=m-2-level; k>level; k--){
                res.add(matrix[k][level]);
            }
            level ++;
        }
        return res;
    }
}