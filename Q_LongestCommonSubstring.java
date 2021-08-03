/**
 * @author wmy
 * @date 2021/6/13 21:45
 */
/*
描描述
给定两个字符串str1和str2,输出两个字符串的最长公共子串
题目保证str1和str2的最长公共子串存在且唯一。
示例1
输入：
"1AB2345CD","12345EF"
返回值：
"2345"
 */
public class Q_LongestCommonSubstring {
    /**
     * longest common substring
     * <p>
     * 参考：https://blog.csdn.net/ggdhs/article/details/90713154
     *
     * @param str1 string字符串 the string
     * @param str2 string字符串 the string
     * @return string字符串
     */
    public String longestCommonSubstring(String str1, String str2) {
        // write code here
        //二维动态规划
        //dp[i][j]:str1[0:i]和str2[0:j]的最长公共子串
        //状态转移方程:
        // if(str1[i]==str[j]):
        //       dp[i][j] = dp[i-1][j-1]+1
        //else:
        //       dp[i][j]=0
        int maxLen = 0; //记录最长公共子串
        int idx = -1; //记录最长公共子串结尾索引
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
                    dp[i][j] = 0;
                }
                if (dp[i][j] > maxLen) {
                    maxLen = dp[i][j];
                    idx = i;
                }
            }
        }
        return str1.substring(idx - maxLen, idx);
    }

    public static void main(String[] args) {
        Q_LongestCommonSubstring app = new Q_LongestCommonSubstring();
        String str1 = "1AB2345CD";
        String str2 = "12345EF";
        String res = app.longestCommonSubstring(str2, str1);
        System.out.println(res);

    }
}
