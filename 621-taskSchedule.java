
// 画图来理解，多个时钟周期
class Solution_621 {
    public int leastInterval(char[] tasks, int n) {
        int len = tasks.length;
        if(len == 0) return 0;
        int[] sum = new int[26];
        int max = 0;
        for(int i=0; i<tasks.length; i++) {
            sum[tasks[i] - 'A'] += 1;
            if(sum[tasks[i] - 'A'] > max) max = sum[tasks[i] - 'A'];
        }
        int maxSum = 0;
        for(int i=0; i<26; i++) {
            if(sum[i] == max) maxSum+=1;
        }
        int res = max*(n+1) - (n+1-maxSum);
        if(res<tasks.length) return tasks.length;
        return res;
    }
}