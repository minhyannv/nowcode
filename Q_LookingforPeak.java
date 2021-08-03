/**
 * @author wmy
 * @date 2021/6/13 21:45
 */
/*
描述
山峰元素是指其值大于或等于左右相邻值的元素。给定一个输入数组nums，任意两个相邻元素值不相等，数组可能包含多个山峰。找到索引最大的那个山峰元素并返回其索引。

假设 nums[-1] = nums[n] = -∞。

示例1
输入：
[2,4,1,2,7,8,4]
复制
返回值：
5
复制
 */
public class Q_LookingforPeak {
    /**
     * 寻找最后的山峰
     *
     * @param a int整型一维数组
     * @return int整型
     */
    public int solve(int[] a) {
        // write code here
        int len = a.length;
        for (int i = len - 1; i >= 0; i--) {
            if (i == len - 1) {
                if (a[i] > a[i - 1]) {
                    return i;
                }
            } else if (i == 0) {
                if (a[i] > a[i + 1]) {
                    return i;
                }
            } else {
                if (a[i] > a[i + 1] && a[i] > a[i - 1]) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Q_LookingforPeak app = new Q_LookingforPeak();
        int[] a = {2, 4, 1, 2, 7, 8, 4};
        int res = app.solve(a);
        System.out.println(res);

    }
}
