/**
 * @author wmy
 * @date 2021/6/13 21:45
 */
/*
描述
请写出一个高效的在m*n矩阵中判断目标值是否存在的算法，矩阵具有如下特征：
每一行的数字都从左到右排序
每一行的第一个数字都比上一行最后一个数字大
例如：
对于下面的矩阵：
[
    [1,   3,  5,  9],
    [10, 11, 12, 30],
    [230, 300, 350, 500]
]
要搜索的目标值为3，返回true；
示例1
输入：
[[1,3,5,9],[10,11,12,30],[230, 300, 350, 500]],3
返回值：
true

*/
public class Q_SearchMatrix {
    /**
     * @param matrix int整型二维数组
     * @param target int整型
     * @return bool布尔型
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // write code here
        int rows = matrix.length;
        int cols = matrix[0].length;
        int i = 0;
        while (i < rows && matrix[i][0] <= target) {
            i++;
        }
        i--;
        if (i < 0) {
            return false;
        }
        int left = 0, right = cols - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (matrix[i][middle] == target) {
                return true;
            } else if (matrix[i][middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Q_SearchMatrix app = new Q_SearchMatrix();
//        int[][] matrix = {{1, 3, 5, 9}, {10, 11, 12, 30}, {230, 300, 350, 500}};
//        int target = 3;
        int[][] matrix = {{1}};
        int target = 0;
        boolean res = app.searchMatrix(matrix, target);
        System.out.println(res);

    }
}
