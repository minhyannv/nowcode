import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author wmy
 * @date 2021/6/12 15:13
 */
/*
描述
给定一个数组，找出其中最小的K个数。例如数组元素是4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。如果K>数组的长度，那么返回一个空的数组
示例1
输入：
[4,5,1,6,2,7,3,8],4
返回值：
[1,2,3,4]
 */
public class Q_GetLeastKNumbers {

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        int len = input.length;
        if (k > len) {
            return res;
        }
        quickSort(input, 0, len - 1);
        for (int i = 0; i < k; i++) {
            res.add(input[i]);
        }
        return res;
    }

    private void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(arr, left, right);
            quickSort(arr, left, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, right);
        }
    }

    private int partition(int[] arr, int left, int right) {
        // 设定基准值（pivot）
        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, pivot, index - 1);
        return index - 1;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Q_GetLeastKNumbers app = new Q_GetLeastKNumbers();
        int[] input = {4, 5, 1, 6, 2, 7, 3, 8};
        int k = 4;
        ArrayList<Integer> res = app.GetLeastNumbers_Solution(input, k);
        System.out.println(res);
    }
}
