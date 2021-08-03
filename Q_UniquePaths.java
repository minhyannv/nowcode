/**
 * @author wmy
 * @date 2021/6/13 21:45
 */
/*
描述
一个机器人在m×n大小的地图的左上角（起点）。
机器人每次向下或向右移动。机器人要到达地图的右下角（终点）。
可以有多少种不同的路径从起点走到终点？

备注：m和n小于等于100,并保证计算结果在int范围内

示例1
输入：
2,1
复制
返回值：
1
复制
示例2
输入：
2,2
复制
返回值：
2
复制
*/
public class Q_UniquePaths {
    /**
     * @param m int整型
     * @param n int整型
     * @return int整型
     * <p>
     *
     * 动态规划
     */
    public int uniquePaths(int m, int n) {
        // write code here
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Q_UniquePaths app = new Q_UniquePaths();
        int m = 2;
        int n = 2;
        int res = app.uniquePaths(m, n);
        System.out.println(res);

    }
}
