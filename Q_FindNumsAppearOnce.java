import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author wmy
 * @date 2021/6/13 21:45
 */
/*
描述
一个整型数组里除了两个数字只出现一次，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
示例1
输入：
[1,4,1,6]
复制
返回值：
[4,6]
说明：
返回的结果中较小的数排在前面
*/
public class Q_FindNumsAppearOnce {
//    /**
//     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
//     *
//     * @param array int整型一维数组
//     * @return int整型一维数组
//     *
//     * 第一种方法：hash
//     */
//    public int[] FindNumsAppearOnce(int[] array) {
//        // write code here
//        HashSet<Integer> hashSet = new HashSet<>();
//        for (int i : array) {
//            if (!hashSet.contains(i)) {
//                hashSet.add(i);
//            } else {
//                hashSet.remove(i);
//            }
//        }
//        int[] res = new int[2];
//        int i = 0;
//        for (Integer integer : hashSet) {
//            res[i++] = integer;
//        }
//        return res;
//    }

//    /**
//     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
//     *
//     * @param array int整型一维数组
//     * @return int整型一维数组
//     * <p>
//     * 第二种方法：位运算
//     */
//    public int[] FindNumsAppearOnce(int[] array) {
//        // write code here
//        int[] res = new int[32];
//        int temp = 0;
//        for (int num : array) {
//            temp ^= num;
//        }
//        int k = 0; //二进制位末尾第一个为1的数
//        while (true) {
//            if ((temp & 1) == 0) {
//                k++;
//                temp = temp >> 1;
//            } else {
//                break;
//            }
//        }
//        //数组分组
//        ArrayList<Integer> group1 = new ArrayList<>();
//        ArrayList<Integer> group2 = new ArrayList<>();
//        for (int num : array) {
//            if (((num >> k) & 1) == 0) {
//                group1.add(num);
//            } else {
//                group2.add(num);
//            }
//        }
//        //分别计算两个只出现一次的数
//        int num1 = 0;
//        for (Integer integer : group1) {
//            num1 ^= integer;
//        }
//        int num2 = 0;
//        for (Integer integer : group2) {
//            num2 ^= integer;
//        }
//        if (num1 > num2) {
//            return new int[]{num2, num1};
//        } else {
//            return new int[]{num1, num2};
//
//        }
//    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param array int整型一维数组
     * @return int整型一维数组
     * <p>
     * 第二种方法：位运算(优化)
     */
    public int[] FindNumsAppearOnce(int[] array) {
        // write code here
        int n = 0; //step1:计算所有元素异或结果
        for (int num : array) {
            n ^= num;
        }

        int m = 1; //step2:从右到左寻找二进制位值为1的位置:两个单独出现的数字若在m位相异，则在x中第m位为1（从右往左数）
        while ((m & n) == 0) {
            m <<= 1;
        }
        int a = 0, b = 0; //step3:分组异或
        for (int num : array) {
            if ((num & m) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return a > b ? new int[]{b, a} : new int[]{a, b};
    }

    public static void main(String[] args) {
        Q_FindNumsAppearOnce app = new Q_FindNumsAppearOnce();
        int[] array = {1, 4, 1, 6, 2, 3, 2, 3};
        int[] res = app.FindNumsAppearOnce(array);
        System.out.println(Arrays.toString(res));

    }
}
