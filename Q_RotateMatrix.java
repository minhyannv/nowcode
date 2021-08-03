import java.util.Arrays;

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
->
[
[8,5,8,1],
[8,0,1,3],
[4,6,3,5],
[0,1,4,9]
]
1:[0,0]->[0,3]
3:[0,1]->[1,3]
5:[0,2]->[2,3]
9:[0,3]->[3,3]
8:[1,0]->[0,2]
1:[1,1]->[1,2]
3:[1,2]->[2,2]
4:[1,3]->[3,2]

规则: x[i][j] =x[j][row-i]

返回值：
12
*/
public class Q_RotateMatrix {
    public int[][] rotateMatrix(int[][] mat, int n) {
        // write code here
        int[][] res = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res[j][n - i - 1] = mat[i][j];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Q_RotateMatrix app = new Q_RotateMatrix();
        int[][] mat = {{1, 3, 5, 9}, {8, 1, 3, 4}, {5, 0, 6, 1}, {8, 8, 4, 0}};
        int n = 4;
        int[][] res = app.rotateMatrix(mat, n);

    }
}
