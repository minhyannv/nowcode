import java.util.ArrayList;

/**
 * @author wmy
 * @date 2021/6/13 21:45
 */
/*
描述
给定一个m x n大小的矩阵（m行，n列），按螺旋的顺序返回矩阵中的所有元素。
示例1
输入：
[[1,2,3],[4,5,6],[7,8,9]]
复制
返回值：
[1,2,3,6,9,8,7,4,5]
复制
*/
public class Q_SpiralMatrix {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        if (matrix.length == 0) {
            return res;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;

        boolean[][] visited = new boolean[rows][cols];
        int i = 0, j = 0;
        while (i < rows && j < cols && !visited[i][j]) {
            while (j < cols && !visited[i][j]) {//向右走
//                System.out.print("[" + i + "," + j + "]" + " -> ");
                res.add(matrix[i][j]);
                visited[i][j] = true;
                j++;
            }
            j--;
            i++;
            while (i < rows && !visited[i][j]) {//向下走
//                System.out.print("[" + i + "," + j + "]" + " -> ");
                res.add(matrix[i][j]);
                visited[i][j] = true;
                i++;
            }
            i--;
            j--;
            while (j >= 0 && !visited[i][j]) {//向左走
//                System.out.print("[" + i + "," + j + "]" + " -> ");
                res.add(matrix[i][j]);
                visited[i][j] = true;
                j--;
            }
            j++;
            i--;
            while (i >= 0 && !visited[i][j]) {//向上走
//                System.out.print("[" + i + "," + j + "]" + " -> ");
                res.add(matrix[i][j]);
                visited[i][j] = true;
                i--;
            }
            i++;
            j++;
        }
        return res;
    }

    public static void main(String[] args) {
        Q_SpiralMatrix app = new Q_SpiralMatrix();
//        int[][] matrix = {
//                {1, 2, 3},
//                {4, 5, 6},
//                {7, 8, 9}
//        };
        int[][] matrix = {};
        ArrayList<Integer> res = app.spiralOrder(matrix);
        System.out.println(res);

    }
}
