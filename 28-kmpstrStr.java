class Solution_28 {
    // kmp算法 也就是haystack.indexOf(needle)
    public int strStr(String haystack, String needle) {
        int len = haystack.length();
        if(needle.length() == 0) return 0;
        if(len == 0) return -1;
        // 空字符串对应的结果一定为0
        // KMP算法
        int[] next = getNext(needle);
        int j=0, i=0;
        while(i<len) {
            if(j !=-1 && haystack.charAt(i) != needle.charAt(j)) {
                j = next[j];
            } else {
                j++;
                i++;
            }
            if(j == needle.length()) return i-j;
        }
        return -1;
    }
    
    public int[] getNext(String needle) {
        int len = needle.length();
        int[] next  = new int[len+1];
        next[0] = -1;
        next[1] = 0;
        for(int j=2; j<len; j++) {
            int k = next[j-1];
            while(k != -1) {
                if(needle.charAt(k) == needle.charAt(j-1)) {
                    next[j] = k+1;
                    break;
                } else {
                    k = next[k];
                }
                next[j] = 0;
            }

        }
        return next;
    }
}