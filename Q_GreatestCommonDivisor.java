/**
 * @author wmy
 * @date 2021/6/13 21:45
 */
/*
描述
求出两个数的最大公约数，如果有一个自然数a能被自然数b整除，则称a为b的倍数，b为a的约数。几个自然数公有的约数，叫做这几个自然数的公约数。公约数中最大的一个公约数，称为这几个自然数的最大公约数。
示例1
输入：
3,6
复制
返回值：
3
复制
示例2
输入：
8,12
复制
返回值：
4
复制
 */
public class Q_GreatestCommonDivisor {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * 求出a、b的最大公约数。
     * gcd(a,b)=gcd(b,a%b)
     * if(a%b)==0
     * gcd=b;
     *
     * @param a int
     * @param b int
     * @return int
     */
    public int gcd(int a, int b) {
        // write code here
        if (a % b == 0) {
            return b;
        } else {
            return gcd(b, a % b);
        }
    }

    public static void main(String[] args) {
        Q_GreatestCommonDivisor app = new Q_GreatestCommonDivisor();
        int a = 8;
        int b = 12;
        int res = app.gcd(a, b);
        System.out.println(res);

    }
}
