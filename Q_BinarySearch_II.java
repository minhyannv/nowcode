import java.util.Stack;

/**
 * @author wmy
 * @date 2021/6/12 15:13
 */
/*
描述
请实现有重复数字的升序数组的二分查找
给定一个 元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的第一个出现的target，如果目标值存在返回下标，否则返回 -1
示例1
输入：
[1,2,4,4,5],4
返回值：
2
说明：
从左到右，查找到第1个为4的，下标为2，返回2
示例2
输入：
[1,2,4,4,5],3
返回值：
-1
示例3
输入：
[1,1,1,1,1],1
返回值：
0
 */
public class Q_BinarySearch_II {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * 如果目标值存在返回下标，否则返回 -1
     *
     * @param nums   int整型一维数组
     * @param target int整型
     * @return int整型
     */
    public int search(int[] nums, int target) {
        // write code here
        if (nums.length == 0) {
            return -1;
        }
        int len = nums.length;
        int left = 0, right = len - 1, middle = -1;
        while (left < right) {
            middle = (left + right) / 2;
            if (nums[middle] < target) {
                left = middle + 1;
            } else if (nums[middle] == target) {
                right = middle;
            } else {
                right = middle - 1;
            }
        }
        if (nums[right] == target) { //while 结束时 left=right,如果nums[right]=target,说明是最先出现的target,否则不存在
            return right;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        Q_BinarySearch_II app = new Q_BinarySearch_II();
        int[] nums = {-2, -2, -2, -2, -2};
        int target = -2;
        int res = app.search(nums, target);
        System.out.println(res);
    }
}
