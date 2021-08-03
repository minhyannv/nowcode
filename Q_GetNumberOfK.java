import java.util.Arrays;

/**
 * @author wmy
 * @date 2021/6/13 21:45
 */
/*
描述
统计一个数字在升序数组中出现的次数。
示例1
输入：
[1,2,3,3,3,3,4,5],3
返回值：
4
*/
public class Q_GetNumberOfK {
    public int GetNumberOfK(int[] array, int k) {
        //step1:找到第一个出现的k
        int len = array.length;
        if (len == 0 || array[0] > k || array[len - 1] < k) {
            return 0;
        }
        int idx = binarySearch(array, k, 0, len - 1);
        if (idx == -1) {
            return 0;
        }
        //step2:前向后向扩展
        int i = 0, j = 0;
        while ((idx - i) >= 0 && array[idx] == array[idx - i]) {
            i++;
        }
        while ((idx + j) < len && array[idx] == array[idx + j]) {
            j++;
        }
        return i + j - 1;
    }

    public int binarySearch(int[] arr, int k, int left, int right) {
        if (left > right) {
            return -1;
        }
        int middle = (left + right) / 2;
        if (arr[middle] == k) {
            return middle;
        } else if (arr[middle] > k) {
            return binarySearch(arr, k, 0, middle - 1);
        } else {
            return binarySearch(arr, k, middle + 1, right);
        }
    }

    public static void main(String[] args) {
        Q_GetNumberOfK app = new Q_GetNumberOfK();
        int[] array = {1, 2, 3, 3, 3, 3, 4, 5};
        int k = 6;
        int res = app.GetNumberOfK(array, k);
        System.out.println(res);

    }
}
