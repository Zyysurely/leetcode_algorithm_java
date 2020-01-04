class Solution_1155 {
    public int numRollsToTarget(int d, int f, int target) {
        int[][] res = new int[2][target+1];
        int flag = 0;
        for(int i=1; i<=f; i++) {
            if(i>target) break;
            res[0][i] = 1;
        }
        for(int i=2; i<=d; i++) {
            for (int l = 0; l < i; ++l)  
                res[1 - flag][l] = 0;
            for(int j=i; j<=target; j++) {
                res[1-flag][j] = 0;
                for(int k=1; k<=f && j-k>0; k++) {
                    res[1-flag][j] = (res[1-flag][j] + res[flag][j-k])%(1000000007);
                }
            }
            flag = 1-flag;
        }
        return res[flag][target];
    }
}