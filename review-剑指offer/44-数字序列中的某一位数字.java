

class Solution_offer_44 {
    public int someDigit(int index) {
        if(index < 0) return -1;
        int pace = 1;
        while(true) {
            int amount = pace == 1 ? 10 : (int) Math.pow(10, pace-1) * 9;
            int total = amount * pace;
            if(index < total) return getDigitAtIndex(index, pace);
            index -= total;
            pace ++ ;
        }
    }

    private int getBeginNumberOfPlace(int place) {
        if (place == 1)
            return 0;
        return (int) Math.pow(10, place - 1);
    }


    private int getDigitAtIndex(int index, int place) {
        int beginNumber = getBeginNumberOfPlace(place);
        int shiftNumber = index / place;
        String number = (beginNumber + shiftNumber) + "";
        int count = index % place;
        return number.charAt(count) - '0';
    }
}