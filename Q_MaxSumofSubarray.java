/**
 * @author wmy
 * @date 2021/6/13 21:45
 */
/*
描述
给定一个数组arr，返回子数组的最大累加和
例如，arr = [1, -2, 3, 5, -2, 6, -1]，所有子数组中，[3, 5, -2, 6]可以累加出最大的和12，所以返回12.
题目保证没有全为负数的数据
[要求]
时间复杂度为O(n)O(n)，空间复杂度为O(1)O(1)

示例1
输入：
[1, -2, 3, 5, -2, 6, -1]
返回值：
12

 */
public class Q_MaxSumofSubarray {
    /**
     * max sum of the subarray
     *
     * @param arr int整型一维数组 the array
     * @return int整型
     * <p>
     * 动态规划：状态转移方程
     * dp[i]:（0-i）下标对应的以i下标为结尾的子数组的最大累加值
     * if dp[i-1]<0:
     * dp[i] = arr[i]
     * else
     * dp[i] = dp[i-1]+arr[i]
     */
    public int maxsumofSubarray(int[] arr) {
        // write code here
        int res = Integer.MIN_VALUE;
        int len = arr.length;
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            if (i == 0) {
                dp[i] = arr[i];
            } else {
                if (dp[i - 1] < 0) {
                    dp[i] = arr[i];
                } else {
                    dp[i] = dp[i - 1] + arr[i];
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        Q_MaxSumofSubarray app = new Q_MaxSumofSubarray();
        int[] arr = {1, 3, 5, 2, 2};
        int res = app.maxsumofSubarray(arr);
        System.out.println(res);

    }
}
