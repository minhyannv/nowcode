import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

/**
 * @author wmy
 * @date 2021/6/13 21:45
 */
/*
描述
给出一个整数数组，请在数组中找出两个加起来等于目标值的数，
你给出的函数twoSum 需要返回这两个数字的下标（index1，index2），需要满足 index1 小于index2.。注意：下标是从1开始的
假设给出的数组中只存在唯一解
例如：
给出的数组为 {20, 70, 110, 150},目标值为90
输出 index1=1, index2=2

示例1
输入：
[3,2,4],6
返回值：
[2,3]
说明：
因为 2+4=6 ，而 2的下标为2 ， 4的下标为3 ，又因为 下标2 < 下标3 ，所以输出[2,3]
 */
public class Q_SumofTwoNum {
    /**
     * @param numbers int整型一维数组
     * @param target  int整型
     * @return int整型一维数组
     */
    public int[] twoSum(int[] numbers, int target) {
        // write code here
        int len = numbers.length;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (hashMap.containsKey(target - numbers[i])) {
                return new int[]{hashMap.get(target - numbers[i]) + 1, i + 1};
            } else {
                hashMap.put(numbers[i], i);
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        Q_SumofTwoNum app = new Q_SumofTwoNum();
        int[] numbers = {3, 2, 4};
        int target = 6;
        int[] res = app.twoSum(numbers, target);
        System.out.println(Arrays.toString(res));

    }
}
