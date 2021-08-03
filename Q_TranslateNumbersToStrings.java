import java.util.Stack;

/**
 * @author wmy
 * @date 2021/6/13 21:45
 */
/*
描述
有一种将字母编码成数字的方式：'a'->1, 'b->2', ... , 'z->26'。

现在给一串数字，返回有多少种可能的译码结果
示例1
输入：
"12"
复制
返回值：
2
复制
说明：
2种可能的译码结果（”ab” 或”l”）
示例2
输入：
"31717126241541717"
复制
返回值：
192
复制
说明：
192种可能的译码结果
 */
public class Q_TranslateNumbersToStrings {
    /**
     * 解码
     *
     * @param nums string字符串 数字串
     * @return int整型
     * <p>
     * <p>
     * 动态规划
     * if (nums[i-1]==0):
     * if(dp[i-2]=={1-2}:
     * dp[i]=dp[i-2]
     * else:
     * return 0
     * else if(nums[i-1]=={1-6}:
     * if(nums[i-2]=={1-2}:
     * dp[i]=dp[i-1]+dp[i-2]
     * else:
     * dp[i]=dp[i-1]
     * else if(nums[i-1]=={7-9}:
     * if(nums[i-2]==1:
     * dp[i]=dp[i-1]+dp[i-2]
     * else:
     * dp[i]=dp[i-1]
     */
    public int solve(String nums) {
        // write code here
        int len = nums.length();
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            if (i == 0) {
                if (nums.charAt(i) - '0' > 0) {
                    dp[i] = 1;
                    continue;
                } else {
                    return 0;
                }
            }
            if (nums.charAt(i) - '0' != 0) {
                dp[i] = dp[i - 1];
            }
            int temp = Integer.parseInt(nums.substring(i - 1, i + 1));
            if (temp >= 10 && temp <= 26) {
                if (i == 1) {
                    dp[i]++;
                } else {
                    dp[i] += dp[i - 2];
                }
            }
        }
        return dp[len - 1];
    }

    public static void main(String[] args) {
        Q_TranslateNumbersToStrings app = new Q_TranslateNumbersToStrings();
        String nums = "31717126241541717";
//        String nums = "100";
        int res = app.solve(nums);
        System.out.println(res);

    }
}
