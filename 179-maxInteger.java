import java.util.*;

// 主要是排序器的写法
class Solution_179 {
    public String largestNumber(int[] nums) {
        if(nums==null || nums.length==0) return "";
        String[] str = new String[nums.length];
        for(int i=0; i<nums.length; i++) {
            str[i] = String.valueOf(nums[i]);
        }
        //重写排序规则 12-14ms
       // Arrays.sort(strArr, new Comparator<String>() {
       //     @Override
       //     public int compare(String o1, String o2) {
       //         //继承此方法的时候，要自定义比较器，conpareTo方法返回值为1(升序),0，-1(降序)。
       //         //返回正值 交换；负值不交换
       //         return (o2 + o1).compareTo((o1 + o2));
       //     }
       // });
       // 按照整数的方向应该是逆序的，主要的时间复杂度是在排序上
       Arrays.sort(str, (o1, o2) -> (o2+o1).compareTo(o1+o2));
       StringBuilder res = new StringBuilder();
       for(String item : str) {
           res.append(item);
       }
       String l = res.toString();
       if(l.charAt(0) == '0') return "0";
       return l;
    }
}