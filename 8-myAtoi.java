class Solution_8 {
    public int myAtoi(String str) {
        if(str == null||str.length() == 0) return 0;
        long num = 0;
        int add = 1;
        int i = 0;
        while(i<str.length()) {
            if(str.charAt(i) != ' '){
                break;
            }
            i++;
        }
        if(i<str.length() && (str.charAt(i) == '-' ||  str.charAt(i) == '+')) {
            if(str.charAt(i) == '-'){
                add = -1;
            }
            i++;
        }
        while(i<str.length()) {
            if(Character.isDigit(str.charAt(i))) {
                num = num*10 + add * ((str.charAt(i) - '0'));
                if(num > Integer.MAX_VALUE) return Integer.MAX_VALUE;
                else if(num < Integer.MIN_VALUE) {return Integer.MIN_VALUE;}
            } else {
                break;
            }
            i++;
        }
        if(num > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        else if(num < Integer.MIN_VALUE) {return Integer.MIN_VALUE;}
        return (int)num;
    }
}