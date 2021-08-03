/**
 * @author wmy
 * @date 2021/6/11 16:46
 */

/*
描述
输入一个整数，输出该数32位二进制表示中1的个数。其中负数用补码表示。
示例1
输入：
10
复制
返回值：
2
复制
 */
public class Q_NumberOf1 {
    /**
     * 把一个整数减去1，再和原整数做与运算，会把该整数最右边一个1变成0.那么一个整数的二进制有多少个1，就可以进行多少次这样的操作。
     *
     * @param n
     * @return
     */
    public int NumberOf1(int n) {
        int res = 0;
        while (n != 0) {
            res++;
            n &= n - 1;
        }
        return res;
    }

    public static void main(String[] args) {
        Q_NumberOf1 app = new Q_NumberOf1();
        int x = -1;
        int res = app.NumberOf1(x);
        System.out.println(res);
    }
}
