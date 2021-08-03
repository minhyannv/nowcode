import java.util.Arrays;

/**
 * @author wmy
 * @date 2021/6/13 21:45
 */
/*
描述
从0,1,2,...,n这n+1个数中选择n个数，找出这n个数中缺失的那个数，要求O(n)尽可能小。
示例1
输入：
[0,1,2,3,4,5,7]
复制
返回值：
6
复制
示例2
输入：
[0,2,3]
复制
返回值：
1
复制
*/
public class Q_MissingNumber {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * 找缺失数字
     *
     * @param a int整型一维数组 给定的数字串
     * @return int整型
     * <p>
     * <p>
     * 二分法
     */
    public int solve(int[] a) {
        // write code here
        int left = 0;
        int right = a.length;
        while (left < right) {
            int middle = (left + right) / 2;
            if (a[middle] == middle) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        return left;
    }


    public static void main(String[] args) {
        Q_MissingNumber app = new Q_MissingNumber();
        int[] a = {0, 1, 2, 3, 4, 5, 7};
        int res = app.solve(a);
        System.out.println(res);

    }
}
