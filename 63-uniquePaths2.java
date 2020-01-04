// 画图理解，每次其实记住两个数就行，行之间的重叠，跟字符串的加减乘除相似
class Solution_63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid.length == 0 || obstacleGrid[0].length==0) return 0;
        int m = obstacleGrid.length-1;
        int n = obstacleGrid[0].length-1;
        // System.out.println(m);
        // System.out.println(n);
        int[] help = new int[n+1];
        // Arrays.fill(help, 1);
        for(int i=0; i<=n; i++) {
            if(obstacleGrid[0][i] == 1) {
                help[i] = 0;
                break; //后面都是右边不可达的了
            } else {
                help[i] = 1;
            }
        }
        for(int i=1; i<=m; i++){
            if (obstacleGrid[i][0] == 1)
                help[0] = 0;  // 列的第一个为不可达
            for(int j=1; j<=n; j++) {
                if(obstacleGrid[i][j] == 1){
                    help[j] = 0;
                } else {
                    help[j] += help[j-1];
                }
            }
        }
        return help[n];
    }
}