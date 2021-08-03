import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * @author wmy
 * @date 2021/6/13 21:45
 */
/*
描述
给定数组arr，设长度为n，输出arr的最长递增子序列。（如果有多个答案，请输出其中 按数值(注：区别于按单个字符的ASCII码值)进行比较的 字典序最小的那个）
示例1
输入：
[2,1,5,3,6,4,8,9,7]
返回值：
[1,3,4,8,9]
示例2
输入：
[1,2,8,6,4]
返回值：
[1,2,4]
说明：
其最长递增子序列有3个，（1，2，8）、（1，2，6）、（1，2，4）其中第三个 按数值进行比较的字典序 最小，故答案为（1，2，4）   
 */
public class Q_LongestIncreasingSubsequence {
//    /**
//     * retrun the longest increasing subsequence
//     *
//     * @param arr int整型一维数组 the array
//     * @return int整型一维数组
//     * <p>
//     * 动态规划：
//     * dp[i]:下标i位结尾的最长递增子序列长度
//     * 状态转移方程：
//     * dp[i] = max(dp[j]+1,dp[i])
//     * 超时
//     */
//    public int[] LIS(int[] arr) {
//        // write code here
//        int len = arr.length;
//        int maxLen = 0;
//        int[] dp = new int[len];
//        Arrays.fill(dp, 1);
//        for (int i = 0; i < len; i++) {
//            for (int j = 0; j < i; j++) {
//                if (arr[i] > arr[j]) {
//                    dp[i] = Math.max(dp[j] + 1, dp[i]);
//                    maxLen = Math.max(dp[i], maxLen);
//                }
//            }
//        }
//        int[] res = new int[maxLen];
//        int idx = len - 1;
//        while (maxLen > 0) {
//            while (dp[idx] != maxLen) {
//                idx--;
//            }
//            res[maxLen - 1] = arr[idx];
//            idx--;
//            maxLen--;
//        }
//        return res;
//    }

    /**
     * retrun the longest increasing subsequence
     *
     * @param arr int整型一维数组 the array
     * @return int整型一维数组
     * 贪心+二分查找
     * 参考：https://blog.nowcoder.net/n/843a7ed318984a36946ac7b01b5f00d9
     */
    public int[] LIS(int[] arr) {
        // write code here
        int len = arr.length;
        int[] tail = new int[len];
        int[] nums = new int[len];
        int currentIdx = 0;
        tail[0] = arr[0];
        for (int i = 1; i < len; i++) {
            if (tail[currentIdx] < arr[i]) {
                tail[++currentIdx] = arr[i];
                nums[i] = currentIdx;
            } else {
                //二分查找tail中第一个大于arr[i]的数,并替换之
                int left = 0;
                int right = currentIdx;
                while (left < right) {
                    int middle = (left + right) / 2;
                    if (tail[middle] < arr[i]) {
                        left = middle + 1;
                    } else {
                        right = middle;
                    }
                }
                tail[left] = arr[i];
                nums[i] = left;
            }
        }
        int[] res = new int[currentIdx + 1];
        for (int i = len - 1; i >= 0; --i) {
            if (nums[i] == currentIdx) {
                res[currentIdx] = arr[i];
                --currentIdx;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Q_LongestIncreasingSubsequence app = new Q_LongestIncreasingSubsequence();
        int[] arr = {2, 1, 5, 3, 6, 4, 8, 9, 7};
        int[] res = app.LIS(arr);
        System.out.println(Arrays.toString(res));

    }
}
