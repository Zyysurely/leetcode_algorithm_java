import java.util.Arrays;

public class solution {
    // 插入排序
    public void insertSort(int[] arr) {
        for(int i=1; i<arr.length; i++) {
            int temp = arr[i];
            int j = i-1;
            while( j>=0 && arr[j]>temp ){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }

    // 归并排序（分治思想）
    // public void mergeSort()

    // main函数执行
    public static void main(String[] args) {
        int[] arr = new int[] {3, 2, 1};
        solution solu = new solution();
        solu.insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
