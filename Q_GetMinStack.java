import java.util.*;

/**
 * @author wmy
 * @date 2021/6/11 16:46
 */

/*
描述
实现一个特殊功能的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作。
示例1
输入：
[[1,3],[1,2],[1,1],[3],[2],[3]]
复制
返回值：
[1,2]
复制
 */
public class Q_GetMinStack {
    /**
     * return a array which include all ans for op3
     *
     * @param op int整型二维数组 operator
     * @return int整型一维数组
     */
    public int[] getMinStack(int[][] op) {
        // write code here
        ArrayList<Integer> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>(); //栈
        Stack<Integer> min_stack = new Stack<>(); //单调栈
        for (int[] ints : op) {
            if (ints[0] == 1) { //入栈
                stack.push(ints[1]);
                if (min_stack.isEmpty() || min_stack.peek() > ints[1]) {
                    min_stack.push(ints[1]);
                }
            } else if (ints[0] == 2) { //出栈
                if (stack.pop().equals(min_stack.peek())) {
                    min_stack.pop();
                }
            } else { //查询最小值
                res.add(min_stack.peek());
            }
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }

    public static void main(String[] args) {
        Q_GetMinStack app = new Q_GetMinStack();
        int[][] op = {{1, 3}, {1, 2}, {1, 1}, {3}, {2}, {3}};
        int[] res = app.getMinStack(op);
        System.out.println(Arrays.toString(res));
    }
}
