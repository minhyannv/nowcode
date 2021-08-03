import java.util.Arrays;
import java.util.HashMap;

/**
 * @author wmy
 * @date 2021/6/13 21:45
 */
/*
描述
给定数组arr，arr中所有的值都为正整数且不重复。每个值代表一种面值的货币，每种面值的货币可以使用任意张，再给定一个aim，代表要找的钱数，求组成aim的最少货币数。
如果无解，请返回-1.
【要求】
时间复杂度O(n \times aim)O(n×aim)，空间复杂度On。
示例1
输入：
[5,2,3],20
复制
返回值：
4
复制
示例2
输入：
[5,2,3],0
复制
返回值：
0
复制
示例3
输入：
[3,5],2
复制
返回值：
-1
复制
 */
public class Q_MinMoney {
    /**
     * 最少货币数
     *
     * @param arr int整型一维数组 the array
     * @param aim int整型 the target
     * @return int整型
     */
    public int minMoney(int[] arr, int aim) {
        // write code here
        int[] dp = new int[aim + 1];
        Arrays.fill(dp, aim + 1);
        dp[0] = 0;
        for (int i = 1; i <= aim; i++) {
            for (int num : arr) {
                if (i - num >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - num] + 1);
                }
            }
        }
        return dp[aim] > aim ? -1 : dp[aim];
    }

    public static void main(String[] args) {
        Q_MinMoney app = new Q_MinMoney();
        int[] arr = {3, 2, 4};
        int aim = 6;
        int res = app.minMoney(arr, aim);
        System.out.println(res);
    }
}
