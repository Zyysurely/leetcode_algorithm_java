// 这就是类似于求二进制中有多少个1的那一题

class Solution_338 {
    public int[] countBits(int num) {
        int[] res = new int[num+1];
        res[0] = 0;
        for(int i=1; i<=num; i++) {
            res[i] = res[(i-1)&i]+1;
        }
        return res;
    }
}