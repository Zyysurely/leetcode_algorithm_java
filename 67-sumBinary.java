class Solution_67 {
    public String addBinary(String a, String b) {
        int length1 = a.length()-1;
        int length2 = b.length()-1;
        StringBuilder res = new StringBuilder();
        int add = 0;
        while(length1 >= 0 && length2 >= 0) {
            int sum = a.charAt(length1) - '0' + b.charAt(length2) - '0' + add;
            add = sum/2;
            res.append(String.valueOf(sum%2));
            length1--;
            length2--;
        }
        int len = -1;
        String s = null;
        if(length1 >= 0) {
            len = length1;
            s = a;
        }
        else if(length2 >= 0) {
            len = length2;
            s = b;
        }
        if(len >= 0) {
            while(len >= 0) {
                int sum = s.charAt(len) - '0' + add;
                add = sum/2;
                res.append(String.valueOf(sum%2));
                len--;
            }
        }
        if(add != 0) res.append("1");
        return res.reverse().toString();
    }
}