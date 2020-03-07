
class Solution_offer_14 {
    public int integerBreak(int num) {
        if(num < 2) return num;
        if(num == 2) return 1;
        if(num == 3) return 2;
        int timesOf3 = num/3;
        if(num%3 == 1) timesOf3--;
        int timesOf2 = (num-timesOf3*3)/2;
        return (int) (Math.pow(3, timesOf3) * Math.pow(2, timesOf2));
    }
}