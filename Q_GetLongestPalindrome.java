/**
 * @author wmy
 * @date 2021/6/13 21:45
 */
/*
描述
对于一个字符串，请设计一个高效算法，计算其中最长回文子串的长度。
给定字符串A以及它的长度n，请返回最长回文子串的长度。

示例1
输入：
"abc1234321ab",12
返回值：
7
 */
public class Q_GetLongestPalindrome {
    public int getLongestPalindrome(String A, int n) {
        // write code here
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, Math.max(judgeOdd(A, i, n), judgeEven(A, i, i + 1, n)));
        }
        return res;

    }

    /**
     * 计算以索引i为中心的最长回文串
     *
     * @param A
     * @param i
     * @param n
     * @return
     */
    public int judgeOdd(String A, int i, int n) {
        int flag = 0;
        while ((i - flag) >= 0 && (i + flag) < n) {
            if (A.charAt(i - flag) == A.charAt(i + flag)) {
                flag += 1;
            } else {
                break;
            }
        }
        return 1 + (flag - 1) * 2;
    }

    /**
     * 计算以索引i，j为中心的最长回文串
     *
     * @param A
     * @param i
     * @param j
     * @param n
     * @return
     */
    public int judgeEven(String A, int i, int j, int n) {
        int flag = 0;
        while ((i - flag) >= 0 && (j + flag) < n) {
            if (A.charAt(i - flag) == A.charAt(j + flag)) {
                flag += 1;
            } else {
                break;
            }
        }
        return flag * 2;
    }

    public static void main(String[] args) {
        Q_GetLongestPalindrome app = new Q_GetLongestPalindrome();
        String A = "aa44aa";
        int n = 6;
        int res = app.getLongestPalindrome(A, n);
        System.out.println(res);

    }
}
