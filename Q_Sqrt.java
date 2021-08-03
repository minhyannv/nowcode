import java.sql.Time;

/**
 * @author wmy
 * @date 2021/6/12 15:13
 */
/*
描述
实现函数 int sqrt(int x).
计算并返回x的平方根（向下取整）
示例1
输入：
2
返回值：
1

 */
public class Q_Sqrt {
//    /**
//     * @param x int整型
//     * @return int整型
//     * 解题思路：平方数等于若干个连续奇数和
//     */
//    public int sqrt(int x) {
//        // write code here
//        int i = 1;
//        int j = 0;
//        while (x >= 0) {
//            x -= i;
//            j += 1;
//            i += 2;
//        }
//        return j - 1;
//    }

    /**
     * @param x int整型
     * @return int整型
     * 解题思路：牛顿迭代法
     */
    public int sqrt(int x) throws InterruptedException {
        // write code here
        if (x == 0) {
            return 0;
        }
        long m = x;
        while (m * m > x) {
            m = (m + x / m) / 2;
        }
        return (int) m;
    }

    public static void main(String[] args) throws InterruptedException {
        Q_Sqrt app = new Q_Sqrt();
        int x = 1518991037;
        int res = app.sqrt(x);
        System.out.println(res);
    }
}
