
/**
 * @author wmy
 * @date 2021/6/13 21:45
 */
/*
描述
给定一个整数数组nums，按升序排序，数组中的元素各不相同。
nums数组在传递给search函数之前，会在预先未知的某个下标 t（0 <= t <= nums.length-1）上进行旋转，让数组变为[nums[t], nums[t+1], ..., nums[nums.length-1], nums[0], nums[1], ..., nums[t-1]]。
比如，数组[0,2,4,6,8,10]在下标3处旋转之后变为[6,8,10,0,2,4]
现在给定一个旋转后的数组nums和一个整数target，请你查找这个数组是不是存在这个target，如果存在，那么返回它的下标，如果不存在，返回-1
示例1
输入：
[6,8,10,0,2,4],10

返回值：
2

示例2
输入：
[6,8,10,0,2,4],3

返回值：
-1

示例3
输入：
[2],1

返回值：
-1

*/
public class Q_TragetNumberofRotationArray {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param nums   int整型一维数组
     * @param target int整型
     * @return int整型
     */
    public int search(int[] nums, int target) {
        // write code here
        int len = nums.length;
        if (len == 0) {
            return -1;
        }
        //step1:寻找旋转索引
        int i = 0;
        for (; i < len - 1; i++) {
            if (nums[i + 1] < nums[i]) {
                break;
            }
        }
        //判断目标数据在哪个区间
        if (target <= nums[i] && target >= nums[0]) {
            //左区间
            return binarySearch(nums, 0, i, target);
        } else {
            //右区间
            return binarySearch(nums, i + 1, len - 1, target);
        }
    }

    public int binarySearch(int[] nums, int left, int right, int target) {
        if (left > right) {
            return -1;
        }
        int middle = (left + right) / 2;
        if (nums[middle] == target) {
            return middle;
        } else if (nums[middle] < target) {
            return binarySearch(nums, middle + 1, right, target);
        } else {
            return binarySearch(nums, left, middle - 1, target);
        }
    }

    public static void main(String[] args) {
        Q_TragetNumberofRotationArray app = new Q_TragetNumberofRotationArray();
        int[] nums = {1};
        int target = 0;
        int res = app.search(nums, target);
        System.out.println(res);

    }
}
