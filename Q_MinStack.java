import java.util.Stack;

/**
 * @author wmy
 * @date 2021/6/11 16:46
 */
public class Q_MinStack {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();
    public void push(int node) {
        stack.push(node);
        if(minStack.isEmpty() || node <= minStack.peek()){
            minStack.push(node);
        }
    }

    public void pop() {
        if (!stack.isEmpty()) {
            if (stack.pop().equals(minStack.peek())) {
                minStack.pop();
            }
        }
    }

    public int top() {
        if (!stack.isEmpty()) {
            return stack.peek();
        } else {
            return Integer.MIN_VALUE;
        }
    }

    public int min() {
        if (!minStack.isEmpty()) {
            return minStack.peek();
        } else {
            return Integer.MIN_VALUE;
        }
    }

    public static void main(String[] args) {
        Q_MinStack app = new Q_MinStack();
        app.push(-1);
        app.push(2);
        System.out.println(app.min());
        System.out.println(app.top());
        app.pop();
        app.push(1);
        System.out.println(app.min());
        System.out.println(app.top());
    }
}
