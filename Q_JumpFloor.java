import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wmy
 * @date 2021/6/12 15:13
 */
/*
一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */
public class Q_JumpFloor {

    /**
     * 第n阶的跳法 = 第n-1阶的跳法+第n-2阶跳法
     * 动态规划 状态转移方程 dp[n] = dp[n-1]+dp[n-2]
     *
     * @param target
     * @return
     */
    public int jumpFloor(int target) {
        int[] dp = new int[target + 1];
        for (int i = 0; i <= target; i++) {
            if (i == 0) {
                dp[i] = 0;
            } else if (i == 1) {
                dp[i] = 1;
            } else if (i == 2) {
                dp[i] = 2;
            } else {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        Q_JumpFloor app = new Q_JumpFloor();
        int target = 10;
        int res = app.jumpFloor(target);
        System.out.println(res);
    }
}
