/**
 * @author wmy
 * @date 2021/6/13 21:45
 */
/*
描描述
给定两个字符串s1和s2,输出两个字符串的最长公共子序列长度
示例1
输入：
"1AB2345CD","12345EF"
返回值：
5
 */
public class Q_LongestCommonSubsequence {
    /**
     * longest common subsequence
     * <p>
     * 参考：https://blog.csdn.net/ggdhs/article/details/90713154
     * 二维动态规划（分两步进行）
     * <p>
     * 第一步：计算转移矩阵
     * dp[i][j]:s1[0:i]和s2[0:j]的最长公共子序列
     * 状态转移方程:
     * if(s1[i]==str[j]):
     * dp[i][j] = dp[i-1][j-1]+1
     * else:
     * dp[i][j]=max(dp[i-1][j],dp[i,j-1])
     * <p>
     * 第二步：往前回溯寻找最长子序列
     *
     * @param s1 string字符串 the string
     * @param s2 string字符串 the string
     * @return string字符串
     */
    public String LCS(String s1, String s2) {
        // write code here
        //step1
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            char c1 = s1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char c2 = s2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        //step2
        return getLongestCommonSubsequence(dp, s1, s2, m, n);
    }

    public String getLongestCommonSubsequence(int[][] dp, String s1, String s2, int m, int n) {
        int maxLen = dp[m][n];
        if (maxLen == 0) {
            return "-1";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int k = maxLen; k > 0; k--) {
            while (dp[m][n] == k) {
                if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
                    stringBuilder.append(s1.charAt(m - 1));
                    m--;
                    n--;
                } else {
                    if (dp[m - 1][n] == k) {
                        m--;
                    } else if (dp[m][n - 1] == k) {
                        n--;
                    }
                }
            }
        }
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        Q_LongestCommonSubsequence app = new Q_LongestCommonSubsequence();
        String s1 = "abc";
        String s2 = "def";
        String res = app.LCS(s2, s1);
        System.out.println(res);

    }
}
