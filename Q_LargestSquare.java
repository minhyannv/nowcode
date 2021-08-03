/**
 * @author wmy
 * @date 2021/6/13 21:45
 */
/*
描述
给定一个由0和1组成的2维矩阵，返回该矩阵中最大的由1组成的正方形的面积
示例1
输入：
[['1','0','1','0',0],['1','0','1','1',1],['1','1','1','1',1],['1','0','0','1',0]]
复制
返回值：
4
复制
*/
public class Q_LargestSquare {
    /**
     * 最大正方形
     *
     * @param matrix char字符型二维数组
     * @return int整型
     * <p>
     * 动态规划
     * dp[i][j]: 表示以 (i,j) 为右下角，且只包含 1 的正方形的边长最大值。
     */
    public int solve(char[][] matrix) {
        // write code here
        int rows = matrix.length;
        int cols = matrix[0].length;
        int res = 0;
        int[][] dp = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i - 1][j - 1]), dp[i][j - 1]) + 1;
                    }
                }
                res = Math.max(res, dp[i][j]);
            }
        }
        return res * res;
    }

    public static void main(String[] args) {
        Q_LargestSquare app = new Q_LargestSquare();
//        char[][] matrix = {
//                {'1', '0', '1', '1', '1', '1', '1', '0', '0', '0'},
//                {'1', '0', '1', '1', '1', '0', '0', '0', '0', '0'},
//                {'1', '0', '1', '0', '1', '1', '1', '0', '0', '0'},
//                {'1', '1', '0', '1', '1', '1', '1', '0', '1', '0'},
//                {'1', '1', '1', '1', '1', '1', '1', '1', '0', '0'},
//                {'1', '0', '1', '1', '1', '1', '1', '1', '1', '0'},
//                {'1', '0', '1', '1', '1', '1', '1', '1', '1', '0'},
//                {'1', '0', '1', '1', '1', '1', '1', '1', '1', '0'},
//                {'1', '1', '1', '1', '1', '1', '1', '1', '0', '0'},
//                {'1', '0', '1', '1', '0', '1', '1', '0', '0', '0'}
//        };
        char[][] matrix = {
                {'1', '1', '1', '1'},
                {'0', '1', '0', '1'}

        };
        int res = app.solve(matrix);
        System.out.println(res);

    }
}
