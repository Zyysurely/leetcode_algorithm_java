class Solution_offer_58 {
    // 先分个翻转，再全部翻转
    public String reverseStr(String str) {
        if(str.length() == 0) return "";
        char[] s = str.toCharArray();
        int start = 0;
        for(int i=0; i<s.length; i++) {
            if(s[i] == ' ')
            {reverse(s, start, i); start = i+1;}
        }
        reverse(s, 0, s.length-1);
        return new String(s);
    }
    private void reverse(char[] s, int i, int j) {
        while(i<j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;j--;
        }
    }

    // 左旋转
    public String leftRotateStr(String str, int k) {
        if(k > str.length()) k=k%str.length();
        char[] s = str.toCharArray();
        reverse(s, 0, k-1);
        reverse(s, k, s.length-1);
        reverse(s, 0, s.length-1);
        return new String(s);
    }
}