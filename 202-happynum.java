

class solution_202 {
        // 快慢指针解决，是环形会追上
        public boolean isHappy(int n) {
            int slow = n;
            int fast = n;
            boolean start = true;
            while(start || slow!=fast) {
                start = false;
                slow = squareSum(slow);
                fast = squareSum(fast);
                fast = squareSum(fast);
            }
            if(fast == 1) return true;
            return false;    
        }
    
        private int squareSum(int n) {
            int sum = 0;
            int res = 0;
            while(n>0) {
                res += (n%10) * (n%10);
                n = n/10;
            }
            return res;
        }
}
// 因为非快乐数不能到1，并且一直循环，所以是有个环的