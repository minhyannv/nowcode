import java.util.Arrays;

/**
 * @author wmy
 * @date 2021/6/13 21:45
 */
/*
描述
写出一个程序，接受一个字符串，然后输出该字符串反转后的字符串。（字符串长度不超过1000）
示例1
输入：
"abcd"
返回值：
"dcba"
 */
public class Q_InvertString {
    /**
     * 反转字符串
     *
     * @param str string字符串
     * @return string字符串
     */
    public String solve(String str) {
        // write code here
        int len = str.length();
        char[] strToChar = str.toCharArray();
        for (int i = 0; i < len / 2; i++) {
            char temp = strToChar[i];
            strToChar[i] = strToChar[len - i - 1];
            strToChar[len - i - 1] = temp;
        }
        return String.valueOf(strToChar);
    }

    public static void main(String[] args) {
        Q_InvertString app = new Q_InvertString();
        String str = "abcde";
        String res = app.solve(str);
        System.out.println(res);

    }
}
