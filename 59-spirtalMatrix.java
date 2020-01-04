// 细心即可，每个圈的路径都是一样的，所有套了四个while
class Solution_59 {
    public int[][] generateMatrix(int n) {
        int[][] a = new int[n][n];
        int index = 1, level = 0;
        while(index <= n*n && level < n) {
            // 从左到右
            for(int k=level; k<n-level; k++){
                a[level][k] = index; index++;
            }
            
            // 从上到下
            for(int k=level+1; k<n-level; k++){
                a[k][n-1-level] = index; index++;
            }
            
            //从右到左
            for(int k=n-2-level; k>=level; k--){
                a[n-1-level][k] = index; index++;
            }
            
             //从下到上
            for(int k=n-2-level; k>level; k--){
                a[k][level] = index; index++;
            }
            level ++;
        }
        return a;
    }
}