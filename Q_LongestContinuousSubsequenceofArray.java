import java.util.Arrays;
import java.util.HashMap;

/**
 * @author wmy
 * @date 2021/6/13 21:45
 */
/*
描述
给定无序数组arr，返回其中最长的连续序列的长度(要求值连续，位置可以不连续,例如 3,4,5,6为连续的自然数）
示例1
输入：
[100,4,200,1,3,2]
返回值：
4
示例2
输入：
[1,1,1]
返回值：
1
*/
public class Q_LongestContinuousSubsequenceofArray {
//    /**
//     * max increasing subsequence
//     * 第一种方法：排序+遍历
//     *
//     * @param arr int整型一维数组 the array
//     * @return int整型
//     */
//    public int MLS(int[] arr) {
//        // write code here
//        int maxLen = 1;
//        Arrays.sort(arr);
//        int len = arr.length - 1;
//        int i = 0;
//        int temp = 1;
//        while (i < len) {
//            if (arr[i] + 1 == arr[i + 1]) {
//                temp++;
//                i++;
//            } else if (arr[i] == arr[i + 1]) {
//                i++;
//            } else {
//                temp = 1;
//                i++;
//            }
//            maxLen = Math.max(maxLen, temp);
//        }
//        return maxLen;
//    }

    /**
     * max increasing subsequence
     * 第二种方法：hashmap
     * 参考：https://blog.nowcoder.net/n/7e7dd99b7ec24873a4e20a571ccf6a1a
     *
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public int MLS(int[] arr) {
        // write code here
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int num : arr) {
            if (!map.containsKey(num)) {
                int preLen = map.get(num - 1) == null ? 0 : map.get(num - 1);
                int nextLen = map.get(num + 1) == null ? 0 : map.get(num + 1);
                int curLen = preLen + 1 + nextLen;
                map.put(num, curLen);
                max = Math.max(max, curLen);
                //两端的数存现存连续序列长度
                map.put(num - preLen, curLen);
                map.put(num + nextLen, curLen);
            }
        }
        return max;
    }


    public static void main(String[] args) {
        Q_LongestContinuousSubsequenceofArray app = new Q_LongestContinuousSubsequenceofArray();
        int[] arr = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        int res = app.MLS(arr);
        System.out.println(res);

    }
}
