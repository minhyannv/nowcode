import java.util.HashMap;

/**
 * @author wmy
 * @date 2021/6/13 21:45
 */
/*
描述
数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组[1,2,3,2,2,2,5,4,2]。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。你可以假设数组是非空的，并且给定的数组总是存在多数元素。1<=数组长度<=50000
示例1
输入：
[1,2,3,2,2,2,5,4,2]
复制
返回值：
2
复制
示例2
输入：
[3,3,3,3,2,2,2]
复制
返回值：
3
复制
示例3
输入：
[1]
复制
返回值：
1
复制
 */
public class Q_MoreThanHalfNum {
//    /**
//     * 第一种方法：hash表方法
//     *
//     * @param array
//     * @return
//     */
//    public int MoreThanHalfNum_Solution(int[] array) {
//        HashMap<Object, Integer> hashMap = new HashMap<>();
//        int len = array.length;
//        for (int j : array) {
//            int num = hashMap.getOrDefault(j, 0) + 1;
//            if (num > len / 2) {
//                return j;
//            } else {
//                hashMap.put(j, num);
//            }
//        }
//        return array[0];
//    }

    /**
     * 第二种方法：投票方法
     *
     * @param array
     * @return
     */
    public int MoreThanHalfNum_Solution(int[] array) {
        int candidate = array[0];
        int count = 1;
        int len = array.length;
        for (int i = 1; i < len; i++) {
            if (array[i] != candidate) {
                if (count > 1) {
                    count--;
                } else {
                    candidate = array[i];
                }
            } else {
                count++;
                if (count > len / 2) {
                    return candidate;
                }
            }
        }
        return candidate;
    }

    public static void main(String[] args) {
        Q_MoreThanHalfNum app = new Q_MoreThanHalfNum();
        int[] array = {3, 3, 3, 3, 2, 2, 2};
        int res = app.MoreThanHalfNum_Solution(array);
        System.out.println(res);

    }
}
