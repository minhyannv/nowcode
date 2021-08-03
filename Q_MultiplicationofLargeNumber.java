import java.util.Arrays;
import java.util.Stack;

/**
 * @author wmy
 * @date 2021/6/13 21:45
 */
/*
描述
以字符串的形式读入两个数字，编写一个函数计算它们的乘积，以字符串形式返回。
（字符串长度不大于10000，保证字符串仅由'0'~'9'这10种字符组成）
示例1
输入：
"11","99"
返回值：
"1089"
说明：
11*99=1089
 */
public class Q_MultiplicationofLargeNumber {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param s string字符串 第一个整数
     * @param t string字符串 第二个整数
     * @return string字符串
     */
    public String solve(String s, String t) {
        // write code here
        int sLen = s.length();
        int tLen = t.length();
        if ("0".equals(s) || "0".equals(t)) {
            return "0";
        }
        int[] arr = new int[sLen + tLen - 1];
        for (int i = 0; i < sLen; i++) {
            for (int j = 0; j < tLen; j++) {
                arr[i + j] += (s.charAt(i) - '0') * (t.charAt(j) - '0');
            }
        }
        StringBuilder sb = new StringBuilder();
        int flag = 0;
        for (int k = sLen + tLen - 2; k >= 0; k--) {
            sb.append((arr[k] + flag) % 10);
            flag = (arr[k] + flag) / 10;
        }

        if (flag != 0) {
            sb.append(flag);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Q_MultiplicationofLargeNumber app = new Q_MultiplicationofLargeNumber();
        String s = "9";
        String t = "9";
        String res = app.solve(s, t);
        System.out.println(res);

    }
}
