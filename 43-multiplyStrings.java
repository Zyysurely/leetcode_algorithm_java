// 画图，数组实现，从后往前，坐标计算
class Solution_43 {
    public String multiply(String num1, String num2) {
        if(num1.length() == 0 || num2.length() == 0) return "0";
        StringBuilder res = new StringBuilder();
        int[] ret = new int[num1.length()+num2.length()];
        for(int i=num1.length()-1; i>=0; i--) {
            int val = num1.charAt(i) - '0';
            for(int j=num2.length()-1; j>=0; j--) {
                int sum = (num2.charAt(j) - '0') * val;
                sum += ret[i+j+1];
                ret[i+j+1] = sum%10;
                ret[i+j] += sum/10;
            }
        }
        int index = 0;
        while(index<ret.length-1 && ret[index]==0) {
            index++;
        }
        for(int i=index; i<ret.length; i++) {
            res.append(ret[i]);
        }
        return res.toString();
    }
}