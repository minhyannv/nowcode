/**
 * @author wmy
 * @date 2021/6/11 16:46
 */

/*
描述
给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
你有注意到翻转后的整数可能溢出吗？因为给出的是32位整数，则其数值范围为[−2^{31}, 2^{31} − 1][−2
31
 ,2
31
 −1]。翻转可能会导致溢出，如果反转后的结果会溢出就返回 0。

示例1
输入：
12
复制
返回值：
21
复制
示例2
输入：
-123
复制
返回值：
-321
复制
示例3
输入：
10
复制
返回值：
1
复制
示例4
输入：
1147483649
复制
返回值：
0
复制
 */
public class Q_ReverseNumber {
    /**
     * @param x int整型
     * @return int整型
     */
    public int reverse(int x) {
        // write code here
        long res = 0;
        while (x != 0) {
            res = res * 10 + (x % 10);
            x = x / 10;
        }
        if (res > Math.pow(2, 31) - 1 || res < -Math.pow(2, 31)) {
            res = 0;
        }
        return (int) res;
    }

    public static void main(String[] args) {
        Q_ReverseNumber app = new Q_ReverseNumber();
        int x = 2123456789;
        int res = app.reverse(x);
        System.out.println(res);
    }
}
