import java.util.Arrays;

/**
 * @author wmy
 * @date 2021/6/13 21:45
 */
/*
描述
给定一个数组，请你编写一个函数，返回该数组排序后的形式。
示例1
输入：
[5,2,3,1,4]
复制
返回值：
[1,2,3,4,5]
示例2
输入：
[5,1,6,2,5]
返回值：
[1,2,5,5,6]
 */
public class Q_MySort {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 将给定数组排序
     *
     * @param arr int整型一维数组 待排序的数组
     * @return int整型一维数组
     */
    public int[] MySort(int[] arr) {
        // write code here
        QuickSort(arr, 0, arr.length - 1);
        return arr;
    }

    private void QuickSort(int[] arr, int left, int right) {
        if (left < right) {
            int middle = partition(arr, left, right);
            QuickSort(arr, left, middle - 1);
            QuickSort(arr, middle + 1, right);
        }
    }

    private int partition(int[] arr, int left, int right) {
        int pivot = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= pivot) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = pivot;
        return left;
    }

    public static void main(String[] args) {
        Q_MySort app = new Q_MySort();
        int[] arr = {5, 1, 6, 2, 5};
        int[] res = app.MySort(arr);
        System.out.println(Arrays.toString(res));

    }
}
