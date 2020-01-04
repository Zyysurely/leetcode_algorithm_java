
// 动态规划思想，从后往前
class Solution_739 {
    public int[] dailyTemperatures(int[] T) {
        if(T.length == 0) return T;
        int[] res = new int[T.length];
        res[T.length-1] = 0;
        for(int i=T.length-2; i>=0; i--) {
            for(int j = i+1; j<T.length; j+=res[j]) {
                if(T[i] < T[j]) {
                    res[i] = j-i;
                    break;
                } else if(res[j] == 0) {
                    res[i] = 0;
                    break;
                }
            }
        }
        return res;
    }
}