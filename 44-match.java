class Solution_44 {
    public boolean isMatch(String s, String p) {
        int i=0, j=0;
        int istart=-1, jstart=-1;
        while(i<s.length()) {
            if(j<p.length() && (p.charAt(j)==s.charAt(i) || p.charAt(j) == '?')) {
                i++;
                j++;
            } else if(j<p.length() && p.charAt(j) == '*') {
                istart = i;
                jstart = j++;
            } else if(istart != -1) {
                i = ++istart;
                j = jstart+1;
            } else {
                return false;
            }
        }
        while(j<p.length() && p.charAt(j) == '*') j++;
        return j==p.length();
    }
}