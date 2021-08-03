import java.util.Arrays;
import java.util.Stack;

/**
 * @author wmy
 * @date 2021/6/13 21:45
 */
/*
描述
给定一个无序数组arr，找到数组中未出现的最小正整数
例如arr = [-1, 2, 3, 4]。返回1
arr = [1, 2, 3, 4]。返回5
[要求]
时间复杂度为O(n)O(n)，空间复杂度为O(1)O(1)

示例1
输入：
[-1,2,3,4]
复制
返回值：
1
复制
 */
public class Q_MinNumberdisappered {
//    /**
//     * return the min number
//     *
//     * @param arr int整型一维数组 the array
//     * @return int整型
//     * 第一种方法： O(nlogn)
//     */
//    public int minNumberdisappered(int[] arr) {
//        // write code here
//        int len = arr.length;
//        Arrays.sort(arr);
//        for (int i = 1; i < len; i++) {
//            if (arr[i] - 1 != arr[i - 1]) {
//                return arr[i] - 1;
//            }
//        }
//        return arr[len - 1] + 1;
//    }

    /**
     * return the min number
     *
     * @param arr int整型一维数组 the array
     * @return int整型
     * 第一种方法： O(n)
     */
    public int minNumberdisappered(int[] arr) {
        // write code here
        int m = 0;
        int n = Integer.MIN_VALUE;
        for (int num : arr) {
            if (m == 0 && num > 0) {
                m = num;
            } else if (num > 0 && num < m) {
                m = num;
            }
            if (num > 0) {
                n = Math.max(n, num);
            }
        }
        if (m == 1) {
            return n + 1;
        } else {
            return m - 1;
        }
    }

    public static void main(String[] args) {
        Q_MinNumberdisappered app = new Q_MinNumberdisappered();
        int[] arr = {1, 2, 3, 4};
        int res = app.minNumberdisappered(arr);
        System.out.println(res);

    }
}
