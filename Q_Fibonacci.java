import java.util.Arrays;

/**
 * @author wmy
 * @date 2021/6/13 21:45
 */
/*
描述
大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0，第1项是1）。
n\leq 39n≤39

示例1
输入：
4
返回值：
3
 */
public class Q_Fibonacci {
    public int Fibonacci(int n) {
        // 0 1 1 2 3 5 ...
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            if (i == 0) {
                dp[i] = 0;
            } else if (i == 1) {
                dp[i] = 1;
            } else {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Q_Fibonacci app = new Q_Fibonacci();
        int n = 4;
        int res = app.Fibonacci(n);
        System.out.println(res);

    }
}
