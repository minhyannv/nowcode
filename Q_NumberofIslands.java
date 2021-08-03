/**
 * @author wmy
 * @date 2021/6/13 21:45
 */
/*
描述
给一个01矩阵，1代表是陆地，0代表海洋， 如果两个1相邻，那么这两个1属于同一个岛。我们只考虑上下左右为相邻。
岛屿: 相邻陆地可以组成一个岛屿（相邻:上下左右） 判断岛屿个数。
示例1
输入：
[[1,1,0,0,0],[0,1,0,1,1],[0,0,0,1,1],[0,0,0,0,0],[0,0,1,1,1]]
返回值：
3
*/
public class Q_NumberofIslands {
    /**
     * 判断岛屿数量
     *
     * @param grid char字符型二维数组
     * @return int整型
     */
    public int solve(char[][] grid) {
        // write code here
        int rows = grid.length;
        int cols = grid[0].length;
        int res = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j, rows, cols);
                    res++;
                }
            }
        }
        return res;
    }

    public void dfs(char[][] grid, int i, int j, int rows, int cols) {
        if (i < 0 || i >= rows || j < 0 || j >= cols) {
            return;
        }
        if (grid[i][j] == '1') {
            grid[i][j] = '0';
            dfs(grid, i - 1, j, rows, cols);
            dfs(grid, i + 1, j, rows, cols);
            dfs(grid, i, j - 1, rows, cols);
            dfs(grid, i, j + 1, rows, cols);
        }
    }

    public static void main(String[] args) {
        Q_NumberofIslands app = new Q_NumberofIslands();
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'0', '1', '0', '1', '1'},
                {'0', '0', '0', '1', '1'},
                {'0', '0', '0', '0', '0'},
                {'0', '0', '1', '1', '1'}
        };
        int res = app.solve(grid);
        System.out.println(res);

    }
}
