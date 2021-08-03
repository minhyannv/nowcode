/**
 * @author wmy
 * @date 2021/6/13 21:45
 */
/*
描述
请写一个整数计算器，支持加减乘三种运算和括号。
示例1
输入：
"1+2"

返回值：
3

示例2
输入：
"(2*(3-4))*5"

返回值：
-10

示例3
输入：
"3+2*3*4-1"

返回值：
26

 */
public class Q_ExpressionEvaluation {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 返回表达式的值
     *
     * @param s string字符串 待计算的表达式
     * @return int整型
     */
    public int solve(String s) {
        // write code here

        return -1;
    }

    public static void main(String[] args) {
        Q_ExpressionEvaluation app = new Q_ExpressionEvaluation();
        String s = "(2*(3-4))*5";
        int res = app.solve(s);
        System.out.println(res);

    }
}
