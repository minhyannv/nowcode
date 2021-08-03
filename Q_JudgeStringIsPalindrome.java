/**
 * @author wmy
 * @date 2021/6/13 21:45
 */
/*
描述
给定一个字符串，请编写一个函数判断该字符串是否回文。如果回文请返回true，否则返回false。
示例1
输入：
"absba"
复制
返回值：
true
复制
示例2
输入：
"ranko"
复制
返回值：
false
复制
示例3
输入：
"yamatomaya"
复制
返回值：
false
复制
示例4
输入：
"a"
复制
返回值：
true
复制
备注：
字符串长度不大于1000000，且仅由小写字母组成
 */
public class Q_JudgeStringIsPalindrome {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param str string字符串 待判断的字符串
     * @return bool布尔型
     */
    public boolean judge(String str) {
        // write code here
        int len = str.length();
        for (int i = 0; i < len / 2; i++) {
            if (str.charAt(i) != str.charAt(len - 1 - i))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Q_JudgeStringIsPalindrome app = new Q_JudgeStringIsPalindrome();
        String str = "abba";
        boolean res = app.judge(str);
        System.out.println(res);

    }
}
