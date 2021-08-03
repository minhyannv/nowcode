/**
 * @author wmy
 * @date 2021/6/13 21:45
 */
/*
描述
给定一个 n * m 的矩阵 a，从左上角开始每次只能向右或者向下走，最后到达右下角的位置，路径上所有的数字累加起来就是路径和，输出所有的路径中最小的路径和。
示例1
输入：
[
[1,3,5,9],
[8,1,3,4],
[5,0,6,1],
[8,8,4,0]
]
返回值：
12
*/
public class Q_MinPathSumofMatrix {
    /**
     * @param matrix int整型二维数组 the matrix
     * @return int整型
     * <p>
     * dp[i][j]:下标i,j对应的最小和
     * 状态转移方程
     * dp[i][j] = min(dp[i-1][j]+matrix[i][j],dp[i][j-1]+matrix[i][j])
     */
    public int minPathSum(int[][] matrix) {
        // write code here
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = matrix[i][j];
                } else if (i == 0) {
                    dp[i][j] = dp[0][j - 1] + matrix[0][j];
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][0] + matrix[i][0];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] + matrix[i][j], dp[i][j - 1] + matrix[i][j]);
                }
            }
        }
        return dp[rows - 1][cols - 1];
    }

    public static void main(String[] args) {
        Q_MinPathSumofMatrix app = new Q_MinPathSumofMatrix();
        int[][] matrix = {{1, 3, 5, 9}, {8, 1, 3, 4}, {5, 0, 6, 1}, {8, 8, 4, 0}};
        int res = app.minPathSum(matrix);
        System.out.println(res);

    }
}
