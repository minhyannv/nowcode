import java.util.Arrays;
import java.util.Stack;

/**
 * @author wmy
 * @date 2021/6/13 21:45
 */
/*
描述
给定一个可能含有重复值的数组 arr，找到每一个 i 位置左边和右边离 i 位置最近且值比 arr[i] 小的位置。返回所有位置相应的信息。位置信息包括：两个数字 L 和 R，如果不存在，则值为 -1，下标从 0 开始。
示例1
输入：
[3,4,1,5,6,2,7]
返回值：
[[-1,2],[0,2],[-1,-1],[2,5],[3,5],[2,-1],[5,-1]]
*/
public class Q_FoundMonotoneStack {
//    /**
//     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
//     * 第一种方法：时间复杂度 O(n^2)
//     * @param nums int一维数组
//     * @return int二维数组
//     */
//    public int[][] foundMonotoneStack(int[] nums) {
//        // write code here
//        int len = nums.length;
//        int[][] res = new int[len][2];
//        for (int i = 0; i < len; i++) {
//            int left = i, right = i;
//            while (left >= 0 && nums[left] >= nums[i]) {
//                left--;
//            }
//            if (left < 0) {
//                left = -1;
//            }
//            while (right < len && nums[right] >= nums[i]) {
//                right++;
//            }
//            if (right >= len) {
//                right = -1;
//            }
//            res[i] = new int[]{left, right};
//        }
//        return res;
//    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 第二种方法：单调栈，时间复杂度 O(n)
     *
     * @param nums int一维数组
     * @return int二维数组
     */
    public int[][] foundMonotoneStack(int[] nums) {
        // write code here
        int len = nums.length;
        int[][] res = new int[len][2];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            //出栈比当前节点大的元素
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                stack.pop();
            }
            //栈为空，则左边没有比nums[i]小的数
            if (stack.isEmpty()) {
                res[i][0] = -1;
            } else {
                //栈不为空，则栈顶元素是从右往左第一个比nums[i]小的数
                res[i][0] = stack.peek();
            }
            stack.push(i);
        }
        stack.clear(); //清空栈
        for (int i = len - 1; i >= 0; i--) {
            //出栈比当前节点大的元素
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                stack.pop();
            }
            //栈为空，则左边没有比nums[i]小的数
            if (stack.isEmpty()) {
                res[i][1] = -1;
            } else {
                //栈不为空，则栈顶元素是从左往右往左第一个比nums[i]小的数
                res[i][1] = stack.peek();
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        Q_FoundMonotoneStack app = new Q_FoundMonotoneStack();
        int[] nums = {3, 4, 1, 5, 6, 2, 7};
        int[][] res = app.foundMonotoneStack(nums);
        System.out.println(Arrays.deepToString(res));

    }
}
