import java.util.Stack;

/**
 * @author wmy
 * @date 2021/6/12 15:13
 */
/*
判断给定的链表中是否有环。如果有环则返回true，否则返回false。
你能给出空间复杂度的解法么？
 */
public class Q_StackSimulationQueue {

    Stack<Integer> stack1 = new Stack<Integer>(); //存储入队列的数据
    Stack<Integer> stack2 = new Stack<Integer>();//存储出队列的数据

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.size() == 0) { //如果stack2为空，则将stack1的数据全部出栈到stack2
            while (stack1.size() != 0) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        Q_StackSimulationQueue app = new Q_StackSimulationQueue();
        app.push(1);
        app.push(2);
        app.push(3);
        System.out.println(app.pop());
        app.push(4);
        System.out.println(app.pop());
        System.out.println(app.pop());
        System.out.println(app.pop());
    }
}
