

class Solution_offer_67 {
    public int StrToInt(String str) {
        if(str.length() == 0) return 0;
        char first = str.charAt(0);
        int limit = - Integer.MAX_VALUE; // 这样变成一个方向的
        boolean negative = false;
        if(first == '-') limit = Integer.MIN_VALUE;
        else if(first != '+') return 0;
        int i=1, sum=0;
        limit = limit/10;
        while(i<str.length()) {
            int digit = str.charAt(i) - '0';
            if(digit <0 || digit > 9) return 0;
            if(sum < limit) return 0;
            sum = sum * 10;
            if(sum < limit + digit) return 0;
            sum -= digit;
        }
        return negative? sum : -sum;
    }
}