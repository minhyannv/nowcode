import com.sun.org.apache.regexp.internal.RE;

import java.util.Arrays;

/**
 * @author wmy
 * @date 2021/6/11 16:46
 */

/*
描述
给定一个无序数组，包含正数、负数和0，要求从中找出3个数的乘积，使得乘积最大，要求时间复杂度：O(n)，空间复杂度：O(1)。
示例1
输入：
[3,4,1,2]
复制
返回值：
24
复制
 */
public class Q_MaximumProductofThreeNumbers {
//    /**
//     * 最大乘积
//     * <p>
//     * 第一种方法：
//     * 首先将数组排序。
//     * <p>
//     * 如果数组中全是非负数，则排序后最大的三个数相乘即为最大乘积；如果全是非正数，则最大的三个数相乘同样也为最大乘积。
//     * <p>
//     * 如果数组中有正数有负数，则最大乘积既可能是三个最大正数的乘积，也可能是两个最小负数（即绝对值最大）与最大正数的乘积。
//     * <p>
//     * 作者：LeetCode-Solution
//     * 链接：https://leetcode-cn.com/problems/maximum-product-of-three-numbers/solution/san-ge-shu-de-zui-da-cheng-ji-by-leetcod-t9sb/
//     * 来源：力扣（LeetCode）
//     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
//     *
//     * @param A int整型一维数组
//     * @return long长整型
//     */
//    public long solve(int[] A) {
//        // write code here
//        int len = A.length;
//        Arrays.sort(A);
//        return Math.max(A[0] * A[1] * A[len - 1], A[len - 3] * A[len - 2] * A[len - 1]);
//    }

    /**
     * 最大乘积
     * <p>
     * 第二种方法：
     * 一次遍历找到max1,max2,max3,min1,min2
     * 然后求max(max1*max2*max3,min1*min2*max1)
     *
     * @param A int整型一维数组
     * @return long长整型
     */
    public long solve(int[] A) {
        // write code here
        long max1 = Long.MIN_VALUE, max2 = Long.MIN_VALUE, max3 = Long.MIN_VALUE;
        long min1 = Long.MAX_VALUE, min2 = Long.MAX_VALUE;
        for (int num : A) {
            if (num > max1) {
                max3 = max2;//更新第三大的值
                max2 = max1;//更新第二大的值
                max1 = num; //更新最大值
            } else if (num > max2) {
                max3 = max2;//更新第三大的值
                max2 = num;//更新第二大的值
            } else if (num > max3) {
                max3 = num;//更新第三大的值
            }
            if (num < min1) {
                min2 = min1;//更新第二小的值
                min1 = num;//更新最小值
            } else if (num < min2) {
                min2 = num;//更新第二小的值
            }
        }
        long res1 = max1 * max2 * max3;
        long res2 = min1 * min2 * max1;
        return Math.max(res1, res2);
    }

    public static void main(String[] args) {
        Q_MaximumProductofThreeNumbers app = new Q_MaximumProductofThreeNumbers();
        int[] A = {3, 4, 1, 2};
        long res = app.solve(A);
        System.out.println(res);
    }
}
