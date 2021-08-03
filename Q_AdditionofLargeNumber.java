import java.util.Stack;

/**
 * @author wmy
 * @date 2021/6/13 21:45
 */
/*
描述
以字符串的形式读入两个数字，编写一个函数计算它们的和，以字符串形式返回。
（字符串长度不大于100000，保证字符串仅由'0'~'9'这10种字符组成）
示例1
输入：
"1","99"
返回值：
"100"
说明：
1+99=100 
 */
public class Q_AdditionofLargeNumber {
//    /**
//     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
//     * 计算两个数之和
//     * 方法1
//     * @param s string字符串 表示第一个整数
//     * @param t string字符串 表示第二个整数
//     * @return string字符串
//     */
//    public String solve(String s, String t) {
//        // write code here
//        int len_s = s.length();
//        int len_t = t.length();
//        StringBuffer sb_s = new StringBuffer(s);
//        sb_s.reverse();
//        StringBuffer sb_t = new StringBuffer(t);
//        sb_t.reverse();
//        if (len_s > len_t) {
//            return fun(sb_s, sb_t, len_s, len_t);
//
//        } else {
//            return fun(sb_t, sb_s, len_t, len_s);
//        }
//    }
//
//    private String fun(StringBuffer max_str, StringBuffer min_str, int max_str_len, int min_str_len) {
//        StringBuffer sb = new StringBuffer();
//        int flag = 0;
//        for (int i = 0; i < min_str_len; i++) {
//            int sum = (max_str.charAt(i) - '0') + (min_str.charAt(i) - '0');
//            sum += flag;
//            flag = sum / 10;
//            sum = sum % 10;
//            sb.append(sum);
//        }
//        for (int i = min_str_len; i < max_str_len; i++) {
//            int sum = max_str.charAt(min_str_len) - '0';
//            sum += flag;
//            flag = sum / 10;
//            sum = sum % 10;
//            sb.append(sum);
//        }
//        if (flag == 1) {
//            sb.append(1);
//        }
//        return sb.reverse().toString();
//    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 计算两个数之和
     * 方法2
     *
     * @param s string字符串 表示第一个整数
     * @param t string字符串 表示第二个整数
     * @return string字符串
     */
    public String solve(String s, String t) {
        // write code here
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            stack1.push(c - '0');
        }
        for (char c : t.toCharArray()) {
            stack2.push(c - '0');
        }
        int flag = 0;//进位
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int a = !stack1.isEmpty() ? stack1.pop() : 0;
            int b = !stack2.isEmpty() ? stack2.pop() : 0;
            sb.append((a + b + flag) % 10);
            flag = (a + b + flag) / 10;
        }
        if (flag == 1) {
            sb.append(flag);
        }
        return sb.reverse().toString();
    }


    public static void main(String[] args) {
        Q_AdditionofLargeNumber app = new Q_AdditionofLargeNumber();
        String s = "9";
        String t = "99999999999999999999999999999999999999999999999999999999999994";
        String res = app.solve(s, t);
        System.out.println(res);

    }
}
