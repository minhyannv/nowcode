import java.util.Arrays;

/**
 * @author wmy
 * @date 2021/6/13 21:45
 */
/*
描述
输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
示例1
输入：
[1,2,3,4]
复制
返回值：
[1,3,2,4]
示例2
输入：
[2,4,6,5,7]
返回值：
[5,7,2,4,6]
*/
public class Q_ReOrderArray {
//    /**
//     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
//     *
//     * @param array int整型一维数组
//     * @return int整型一维数组
//     *
//     *空间暴力
//     */
//    public int[] reOrderArray(int[] array) {
//        // write code here
//        //step1:遍历一遍统计偶数个数
//        int odd = 0;
//        int len = array.length;
//        for (int num : array) {
//            if (num % 2 != 0) {
//                odd++;
//            }
//        }
//        //step2:新建数组，并将奇数偶数放到新数组指定位置
//        int[] res = new int[len];
//        int i = 0, j = odd;
//        for (int num : array) {
//            if (num % 2 != 0) {
//                res[i] = num;
//                i++;
//            } else {
//                res[j] = num;
//                j++;
//            }
//        }
//        return res;
//    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param array int整型一维数组
     * @return int整型一维数组
     * <p>
     * 双指针
     */
    public int[] reOrderArray(int[] array) {
        // write code here
        int len = array.length;
        int[] res = new int[len];
        int head = 0, tail = len - 1;
        int i = 0, j = len - 1;
        while (i < len && j >= 0) {
            if (array[i] % 2 == 1) {
                res[head] = array[i];
                head++;
            }
            i++;
            if (array[j] % 2 == 0) {
                res[tail] = array[j];
                tail--;
            }
            j--;
        }
        return res;
    }

    public static void main(String[] args) {
        Q_ReOrderArray app = new Q_ReOrderArray();
        int[] array = {1, 2, 3, 3, 3, 3, 4, 5};
        int[] res = app.reOrderArray(array);
        System.out.println(Arrays.toString(res));

    }
}
