/**
 * @author wmy
 * @date 2021/6/13 21:45
 */
/*
描述
在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
[
  [1,2,8,9],
  [2,4,9,12],
  [4,7,10,13],
  [6,8,11,15]
]
给定 target = 7，返回 true。

给定 target = 3，返回 false。


示例1
输入：
7,[[1,2,8,9],[2,4,9,12],[4,7,10,13],[6,8,11,15]]
复制
返回值：
true
复制
说明：
存在7，返回true
示例2
输入：
3,[[1,2,8,9],[2,4,9,12],[4,7,10,13],[6,8,11,15]]
复制
返回值：
false
复制
说明：
不存在3，返回false
*/
public class Q_FindNumberFromMatrix {
    public boolean Find(int target, int[][] array) {
        int rows = array.length;
        int cols = array[0].length;
        int i = 0;
        int j = cols - 1;
        while (i < rows && j >= 0) {
            if (array[i][j] == target) {
                return true;
            } else if (array[i][j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Q_FindNumberFromMatrix app = new Q_FindNumberFromMatrix();
        int target = 3;
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        boolean res = app.Find(target, matrix);
        System.out.println(res);

    }
}
