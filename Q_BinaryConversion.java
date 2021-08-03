import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

/**
 * @author wmy
 * @date 2021/6/13 21:45
 */
/*
描述
给定一个十进制数M，以及需要转换的进制数N。将十进制数M转化为N进制数
示例1
输入：
7,2
复制
返回值：
"111"
复制
 */
public class Q_BinaryConversion {
    /**
     * 进制转换
     *
     * @param M int整型 给定整数
     * @param N int整型 转换到的进制
     * @return string字符串
     */
    public String solve(int M, int N) {
        // write code here
        String s = "0123456789ABCDEF";
        boolean flag = false;
        if (M < 0) {
            flag = true;
            M = -M;
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (M != 0) {
            stringBuilder.append(s.charAt(M % N));
            M = M / N;
        }
        if (flag) {
            stringBuilder.append('-');
        }
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        Q_BinaryConversion app = new Q_BinaryConversion();
        int M = -4;
        int N = 3;
        String res = app.solve(M, N);
        System.out.println(res);

    }
}
