class Solution_offer_5 {
    public String FillSpace(String s) {
        int originLen = s.length();
        StringBuilder res = new StringBuilder(s);
        int i=0;
        while(i<originLen) {
            if(s.charAt(i) == ' ') {
                res.append("  ");
            }
            i++;
        }
        int j = res.length()-1;
        i--;
        while(i >= 0 && i<j) {
            char cur = res.charAt(i);
            if(cur != ' ') {
                res.setCharAt(j, cur);
                j--;
            } else {
                res.setCharAt(j, '%');
                res.setCharAt(j-1, '2');
                res.setCharAt(j-2, '0');
                j -= 3;
            }
            i--;
        }
        return res.toString();
    }
}