/**
 * @author wmy
 * @date 2021/6/13 21:45
 */
/*
描述
给定一个数组arr，返回子数组的最大累加和
例如，arr = [1, -2, 3, 5, -2, 6, -1]，所有子数组中，[3, 5, -2, 6]可以累加出最大的和12，所以返回12.
题目保证没有全为负数的数据
[要求]
时间复杂度为O(n)O(n)，空间复杂度为O(1)O(1)

示例1
输入：
[1, -2, 3, 5, -2, 6, -1]
返回值：
12

 */
public class Q_MaxWater {
    /**
     * max water
     *
     * @param arr int整型一维数组 the array
     * @return long长整型
     */
    public long maxWater(int[] arr) {
        // write code here
        //TODO
        return -1;
    }

    public static void main(String[] args) {
        Q_MaxWater app = new Q_MaxWater();
        int[] arr = {1, 3, 5, 2, 2};
        long res = app.maxWater(arr);
        System.out.println(res);

    }
}
