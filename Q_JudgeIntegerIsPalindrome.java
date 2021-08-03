/**
 * @author wmy
 * @date 2021/6/13 21:45
 */
/*
描述
在不使用额外的内存空间的条件下判断一个整数是否是回文数字
提示：
负整数可以是回文吗？（比如-1）
如果你在考虑将数字转化为字符串的话，请注意一下不能使用额外空间的限制
你可以将整数翻转。但是，如果你做过题目“反转数字”，你会知道将整数翻转可能会出现溢出的情况，你怎么处理这个问题？


示例1
输入：
121
复制
返回值：
true
复制
*/

public class Q_JudgeIntegerIsPalindrome {
    /**
     * @param x int整型
     * @return bool布尔型
     */
    public boolean isPalindrome(int x) {
        // write code here
        if (x < 0) {
            return false;
        }
        int m = x;
        int n = 0;
        while (x > 0) {
            n = n * 10 + x % 10;
            x = x / 10;
        }
        return m == n;
    }

    public static void main(String[] args) {
        Q_JudgeIntegerIsPalindrome app = new Q_JudgeIntegerIsPalindrome();
        int x = -2147447412;
        boolean res = app.isPalindrome(x);
        System.out.println(res);

    }
}
