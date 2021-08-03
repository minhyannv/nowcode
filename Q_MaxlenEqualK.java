import java.util.HashMap;
import java.util.Map;

/**
 * @author wmy
 * @date 2021/6/13 21:45
 */
/*
描述
给定一个无序数组arr, 其中元素可正、可负、可0。给定一个整数k，求arr所有子数组中累加和为k的最长子数组长度
示例1
输入：
[1,-2,1,1,1],0
复制
返回值：
3
复制
复制
 */
public class Q_MaxlenEqualK {
    /**
     * max length of the subarray sum = k
     *
     * @param arr int整型一维数组 the array
     * @param k   int整型 target
     * @return int整型
     * <p>
     * [1,-2,1,1,1],0
     */
    public int maxlenEqualK(int[] arr, int k) {
        // write code here
        if (arr == null || arr.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        int len = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum - k)) {
                len = Math.max(i - map.get(sum - k), len);
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return len;
    }

    public static void main(String[] args) {
        Q_MaxlenEqualK app = new Q_MaxlenEqualK();
        int[] arr = {1,-2,1,1,1};
        int k = 0;
        int res = app.maxlenEqualK(arr, k);
        System.out.println(res);
    }
}
