import java.util.*;

class Solution_394 {
    // 这种括号的对应问题，直接可以考虑到用栈来实现
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        int i=0;
        while(i<s.length()) {
            char t = s.charAt(i);
            if(t == ']') {
                String str = "";
                // 把纯字母形成顺序字符串
                while(!stack.peek().equals("[")){
                    str = stack.pop() + str;
                }
                stack.pop();
                String count = "";
                while(stack.size()>0 && stack.peek().charAt(0)<='9' && stack.peek().charAt(0)>='0') {
                    count = stack.pop() + count;
                }
                int k = Integer.parseInt(count);
                String help = "";
                for(int j=0; j<k; j++) {
                    help=help+str;
                }
                // 将一个括号解决，并生成字符串压入栈
                stack.push(help);
            } else {
                stack.push(""+t);
            }
            i++;
        }
        String res = "";
        while(stack.size()!=0) {
            res = stack.pop()+res;
        }
        return res; 
    }
}