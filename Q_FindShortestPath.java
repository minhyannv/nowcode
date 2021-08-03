import java.util.Arrays;

/**
 * @author wmy
 * @date 2021/6/13 21:45
 */
/*
描述
在一个有向无环图中，已知每条边长，求出1到n的最短路径，返回1到n的最短路径值。如果1无法到n，输出-1
示例1
输入：
5,5,[[1,2,2],[1,4,5],[2,3,3],[3,5,4],[4,5,5]]
复制
返回值：
9
备注：
两个整数n和m,表示图的顶点数和边数。
一个二维数组，一维3个数据，表示顶点到另外一个顶点的边长度是多少
每条边的长度范围[0,1000]。
注意数据中可能有重边
*/
public class Q_FindShortestPath {
    public static int MaxValue = 1000000;
    public int findShortestPath(int n, int m, int[][] graph) {
        // write code here
        int[][] arr = new int[n + 1][n + 1];
        for (int[] ints : arr) {
            Arrays.fill(ints, MaxValue);
        }
        for (int[] ints : graph) {
            arr[ints[0]][ints[1]] = Math.min(arr[ints[0]][ints[1]], ints[2]);
        }
        dijstra(arr, 1);
        return arr[1][n];
    }

    public static void dijstra(int[][] matrix, int source) {
        int[] visited = new int[matrix.length];
        String[] path = new String[matrix.length];
        visited[source] = 1;
        for (int i = 1; i < matrix.length; i++) {
            int min = Integer.MAX_VALUE;
            int index = -1;
            for (int j = 0; j < matrix.length; j++) {
                if (visited[j] == 0 && matrix[source][j] < min) {
                    min = matrix[source][j];
                    index = j;
                }
            }
            visited[index] = 1;
            for (int m = 0; m < matrix.length; m++) {
                if (visited[m] == 0 && matrix[source][index] + matrix[index][m] < matrix[source][m]) {
                    matrix[source][m] = matrix[source][index] + matrix[index][m];
                }
            }

        }
    }

    public static void main(String[] args) {
        Q_FindShortestPath app = new Q_FindShortestPath();
        int m = 5;
        int n = 5;
        int[][] graph = {{1, 2, 2}, {1, 4, 5}, {2, 3, 3}, {3, 5, 4}, {4, 5, 5}};
        int res = app.findShortestPath(m, n, graph);
        System.out.println(res);

    }
}
