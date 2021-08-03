/**
 * @author wmy
 * @date 2021/6/13 21:45
 */
/*
描描述
给定两个字符串str1和str2,输出两个字符串的最长公共子序列长度
示例1
输入：
"1AB2345CD","12345EF"
返回值：
5
 */
public class Q_LengthofLongestCommonSubsequence {
    /**
     * longest common subsequence
     * <p>
     * 参考：https://blog.csdn.net/ggdhs/article/details/90713154
     *
     * @param str1 string字符串 the string
     * @param str2 string字符串 the string
     * @return string字符串
     */
    public int longestCommonSubsequence(String str1, String str2) {
        // write code here
        //二维动态规划
        //dp[i][j]:str1[0:i]和str2[0:j]的最长公共子序列
        //状态转移方程:
        // if(str1[i]==str[j]):
        //       dp[i][j] = dp[i-1][j-1]+1
        //else:
        //       dp[i][j]=max(dp[i-1][j],dp[i,j-1])

        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            char c1 = str1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char c2 = str2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        Q_LengthofLongestCommonSubsequence app = new Q_LengthofLongestCommonSubsequence();
        String str1 = "1AB2345CD";
        String str2 = "12345EF";
        int res = app.longestCommonSubsequence(str2, str1);
        System.out.println(res);

    }
}
