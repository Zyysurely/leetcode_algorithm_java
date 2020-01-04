import java.util.*;

class Solution_6 {
    // 自己写的方法，击败了33%的用户。。。。想的太复杂了，可以直接用动态数组解决的。。。。。
    public void printMatrix(int row, int column, char[][] arr) {
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
    public String convert(String s, int numRows) {
        if(s==null || s.length() == 0) return "";
        if(numRows<=1 || numRows>=s.length()) return s;
        int len = s.length();
        int numColumn = ((len-numRows)/(2*numRows-2))*(numRows-1) + 1;
        int l = (len-numRows)%(2*numRows-2);
        if(l !=0 ){
            if(l <= numRows-1) {
                numColumn += l;
            } else {
                numColumn += numRows-1;
            }
        }
        
        char[][] li = new char[numRows][numColumn];
        for(int i=0; i< numRows; i++){
            for(int j=0 ;j<numColumn; j++) {
                li[i][j] = ' ';
            }
        }
        boolean down = true;
        int col = 0;
        int i=0;
        while(i<s.length() && col <= numColumn) {
            if(down){
                int index = 0;
                while(i<s.length() && index < numRows) {
                    li[index][col] = s.charAt(i);
                    printMatrix(numRows, numColumn, li);
                    i++;
                    index++;
                }
                col++;
            } else {
                int index = numRows - 2;
                while(i<s.length() && index >0) {
                    li[index][col] = s.charAt(i);
                    index--;
                    col++;
                    i++;
                }
            }
            if(down == true){
                down = false;
            } else {
                down = true;
            }
        }
        StringBuilder res = new StringBuilder();
        for(i=0; i< numRows; i++){
            for(int j=0 ;j<numColumn; j++) {
                if(li[i][j]!=' ') {
                    res.append(li[i][j]);
                }
            }
        }
        return res.toString();
    }
    
    public String convert_nice(String s, int numRows) {
        if(s==null||s.length()==0) return "";
        if(numRows < 2) return s;
        ArrayList<StringBuilder> li = new ArrayList<StringBuilder>();
        for(int i = 0; i < numRows; i++) li.add(new StringBuilder());
        int index = 0;
        int flag = -1;
        int i=0;
        while(i<s.length()) {
            li.get(index).append(s.charAt(i));
            if(index == 0 || index == numRows-1){
                flag = -flag;
            }
            index += flag;
            i++;
        }
        StringBuilder res = new StringBuilder();
        for(i=0;i<numRows;i++){
            res.append(li.get(i));
        }
        return res.toString();
    }
    public static void main(String[] args) {
        Solution_6 solu = new Solution_6();
        String s = new String("ABCDE");
        System.out.println(solu.convert(s, 2));
    }
    
}