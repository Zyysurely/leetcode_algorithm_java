class Solution_647 {
    // 应当还用中心扩展法解决此类回文串的问题
    public int countSubstrings(String s) {
        int res=0;
        for(int i=0; i<s.length(); i++) {
            res += count(s, i, i) + count(s, i, i+1); //奇数扩展以及偶数扩展
        }
        return res;
    }
    
    public int count(String s, int left, int right) {
        int count = 0;
        while(left>=0&&right<s.length()) {
            if(s.charAt(left) != s.charAt(right)){
                return count;
            }
            count++;
            left--;
            right++;
        }
        return count;
    }
}