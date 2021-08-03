import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author wmy
 * @date 2021/6/13 21:45
 */
/*
描述
给定一个数组arr，返回arr的最长无重复元素子数组的长度，无重复指的是所有数字都不相同。
子数组是连续的，比如[1,3,5,7,9]的子数组有[1,3]，[3,5,7]等等，但是[1,3,7]不是子数组
示例1
输入：
[2,3,4,5]
返回值：
4
说明：
[2,3,4,5]是最长子数组    
示例2
输入：
[2,2,3,4,3]
返回值：
3
说明：
[2,3,4]是最长子数组    
示例3
输入：
[9]
返回值：
1
示例4
输入：
[1,2,3,1,2,3,2,2]
返回值：
3
说明：
最长子数组为[1,2,3]   
示例5
输入：
[2,2,3,4,8,99,3]
返回值：
5
说明：
最长子数组为[2,3,4,8,99] 
 */
public class Q_LongestNonRepeatingSubarray {
    /**
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public int maxLength(int[] arr) {
        // write code here
        int len = arr.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return 1;
        }
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int left = 0, right = 1;
        hashMap.put(arr[left], left);
        int res = 0;
        while (right < len) {
            if (hashMap.containsKey(arr[right])) {
                for(int i=left;i<hashMap.get(arr[right]);i++){
                    hashMap.remove(arr[i]);
                }
                left = hashMap.get(arr[right]) + 1;
                hashMap.remove(arr[right]);
                hashMap.put(arr[left], left);
            }
            hashMap.put(arr[right], right);
            res = Math.max(res, right - left + 1);
            right += 1;
        }
        return res;
    }

    public static void main(String[] args) {
        Q_LongestNonRepeatingSubarray app = new Q_LongestNonRepeatingSubarray();
        int[] arr = {2, 2, 3, 4, 3};
//        int[] arr = {2, 3, 4, 5};
//        int[] arr = {1, 2, 3, 1, 2, 3, 2, 2};
//        int[] arr = {3, 3, 2, 1, 3, 3, 3, 1};
        int res = app.maxLength(arr);
        System.out.println(res);

    }
}
