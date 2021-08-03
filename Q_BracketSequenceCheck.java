import java.util.Stack;

/**
 * @author wmy
 * @date 2021/6/13 21:45
 */
/*
描述
给出一个仅包含字符'(',')','{','}','['和']',的字符串，判断给出的字符串是否是合法的括号序列
括号必须以正确的顺序关闭，"()"和"()[]{}"都是合法的括号序列，但"(]"和"([)]"不合法。
示例1
输入：
"["
返回值：
false
示例2
输入：
"[]"
返回值：
true
 */
public class Q_BracketSequenceCheck {
//    /**
//     * 比较蠢的方法
//     *
//     * @param s string字符串
//     * @return bool布尔型
//     */
//    public boolean isValid(String s) {
//        // write code here
//        Stack<Character> stack = new Stack<>();
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) == '{' || s.charAt(i) == '[' || s.charAt(i) == '(') {
//                stack.push(s.charAt(i));
//            } else if (s.charAt(i) == '}') {
//                if (stack.size() == 0) {
//                    return false;
//                }
//                char c = stack.pop();
//                if (c != '{') {
//                    return false;
//                }
//            } else if (s.charAt(i) == ']') {
//                if (stack.size() == 0) {
//                    return false;
//                }
//                char c = stack.pop();
//                if (c != '[') {
//                    return false;
//                }
//            } else if (s.charAt(i) == ')') {
//                if (stack.size() == 0) {
//                    return false;
//                }
//                char c = stack.pop();
//                if (c != '(') {
//                    return false;
//                }
//            }
//        }
//        return stack.size() <= 0;
//    }

    /**
     * 改进的方法
     *
     * @param s string字符串
     * @return bool布尔型
     */
    public boolean isValid(String s) {
        // write code here
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {
        Q_BracketSequenceCheck app = new Q_BracketSequenceCheck();
        String s = "]";
        boolean res = app.isValid(s);
        System.out.println(res);

    }
}
