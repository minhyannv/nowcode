import java.util.*;

/**
 * @author wmy
 * @date 2021/6/12 15:13
 */
/*
描述
给定一个整型数组 arrarr 和一个整数 k(k>1)k(k>1)。
已知 arrarr 中只有 1 个数出现一次，其他的数都出现 kk 次。
请返回只出现了 1 次的数。
示例1
输入：
[5,4,1,1,5,1,5],3
返回值：
4
 */
public class Q_FoundOnceNumber {
//    /**
//     * 使用hashmap
//     *
//     * @param arr
//     * @param k
//     * @return
//     */
//    public int foundOnceNumber(int[] arr, int k) {
//        // write code here
//        HashMap<Integer, Integer> hashMap = new HashMap<>();
//        for (int i : arr) {
//            hashMap.put(i, hashMap.getOrDefault(i, 0) + 1);
//        }
//        Set<Integer> set = hashMap.keySet();
//        for (int num : set) {
//            if (hashMap.get(num) == 1) {
//                return num;
//            }
//        }
//        return Integer.MIN_VALUE;
//    }

    /**
     * 使用位运算
     *
     * @param arr
     * @param k
     * @return
     */
    public int foundOnceNumber(int[] arr, int k) {
        // write code here
        int result = 0;
        if (k % 2 == 0) { //如果k等于偶数，相同数字的偶数次异或运算为0，最终剩下的即为出现一次的数
            for (int num : arr) {
                result ^= num;
            }
        } else { //如果k等于奇数，则出现一次的数对应二进制位即为所有数对应二进制比特位累加结果模k的值(值不为0，则取1)
            for (int i = 0; i < 32; i++) {
                int target = 0; //存储第i位二进制位数的和
                for (int num : arr) {
                    //(num >> i) & 1：第i位二进制位的值；&1：求最后一位比特位的值
                    target = target + ((num >> i) & 1);
                }

                if (target % k != 0) {// 如果target%k！=0，则目标数第i位比特位的值是1
                    result = result | (1 << i);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Q_FoundOnceNumber app = new Q_FoundOnceNumber();
        int[] arr = {5, 4, 1, 1, 5, 1, 5};
        int k = 3;
        int res = app.foundOnceNumber(arr, k);
        System.out.println(res);

    }
}
