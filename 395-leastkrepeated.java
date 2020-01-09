class Solution_395 {
    public int longestSubstring(String s, int k) {
        if(k==0 || s.length()==0) return 0;
        return count(s, k, 0, s.length()-1);
    }

    // 以不到k个的为断点进行分治
    int count(String s, int k, int first, int last) {
        if(last - first + 1 < k) return 0;
        int[] sum = new int[26];
        for(int i=first; i<=last; i++) {
            sum[s.charAt(i) - 'a'] ++;
        }
        int i=first, j=last;
        // 去头去尾操作
        while(j-i+1>=k && sum[s.charAt(i) - 'a']<k) {
            i++;
        }
        while(j-i+1>=k && sum[s.charAt(j) - 'a']<k) {
            j--;
        }
        if(j-i+1<k) return 0;
        for(int index=i; index<j; index++) {
            if(sum[s.charAt(index)-'a'] < k) {
                return Math.max(count(s, k, i, index-1), count(s, k, index+1, j));
            }
        }
        return j-i+1;
    }
}