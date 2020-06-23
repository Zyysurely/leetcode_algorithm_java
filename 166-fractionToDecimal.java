import java.util.*;

class Solution_166 {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder res = new StringBuilder();
        if(denominator == 0 || numerator == 0) return "0";
        if((numerator < 0&& denominator>0)||(numerator > 0&& denominator<0)) res.append("-");
        long divisor=Math.abs(Long.valueOf(denominator)), divided = Math.abs(Long.valueOf(numerator));
        long reminder = divided % divisor;
        res.append(String.valueOf(divided/divisor));
        if(reminder == 0) return res.toString();
        res.append(".");
        Map<Long, Integer> map = new HashMap<>();
        while(reminder != 0) {
            if(map.containsKey(reminder)) {
                res.insert(map.get(reminder), "(");
                res.append(")");
                break;
            }
            map.put(reminder, res.length());
            reminder *= 10;
            res.append(String.valueOf(reminder/divisor));
            reminder = reminder%divisor;
        }
        return res.toString();
    }
}