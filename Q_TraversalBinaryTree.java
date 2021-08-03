import java.util.ArrayList;
import java.util.Stack;

/**
 * @author wmy
 * @date 2021/6/12 15:13
 */
/*
描述
描述
分别按照二叉树先序，中序和后序打印所有的节点。
示例1
输入：
{1,2,3}
返回值：
[[1,2,3],[2,1,3],[2,3,1]]
 */
public class Q_TraversalBinaryTree {


    private final ArrayList<Integer> preorderRes = new ArrayList<>();
    private final ArrayList<Integer> inorderRes = new ArrayList<>();
    private final ArrayList<Integer> postorderRes = new ArrayList<>();

    /**
     * @param root TreeNode类 the root of binary tree
     * @return int整型二维数组
     */
    public int[][] threeOrders(TreeNode root) {
        // write code here
        int[][] res = new int[3][];
        preorderTraversalRecursive(root);
        inorderTraversalRecursive(root);
        postorderTraversalRecursive(root);
        res[0] = preorderRes.stream().mapToInt(value -> value).toArray(); //ArrayList转基本类型数组
        res[1] = inorderRes.stream().mapToInt(value -> value).toArray(); //ArrayList转基本类型数组
        res[2] = postorderRes.stream().mapToInt(value -> value).toArray(); //ArrayList转基本类型数组
        return res;

    }

    /**
     * 前序遍历(根左右)
     * 非递归实现方式：栈,每次先入栈右子节点，再入栈左子节点
     */
    public void preorderTraversalNonRecursive(TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack<>(); //初始化栈
        stack.push(treeNode);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            preorderRes.add(temp.val);
            if (temp.right != null) { //先入栈右子节点，再入栈左子节点
                stack.push(temp.right);
            }
            if (temp.left != null) {
                stack.push(temp.left);
            }
        }
    }

    /**
     * 前序遍历(根左右)
     * 递归实现方式
     */
    public void preorderTraversalRecursive(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        this.preorderRes.add(treeNode.val);
        preorderTraversalRecursive(treeNode.left);
        preorderTraversalRecursive(treeNode.right);
    }

    /**
     * 中序遍历(左根右)
     * 递归实现方式
     */
    public void inorderTraversalRecursive(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        inorderTraversalRecursive(treeNode.left);
        this.inorderRes.add(treeNode.val);
        inorderTraversalRecursive(treeNode.right);
    }


    /**
     * 后序遍历(左右根)
     * 递归实现方式
     */
    public void postorderTraversalRecursive(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        postorderTraversalRecursive(treeNode.left);
        postorderTraversalRecursive(treeNode.right);
        this.postorderRes.add(treeNode.val);
    }

    public static void main(String[] args) {
        Q_TraversalBinaryTree app = new Q_TraversalBinaryTree();
        TreeNode root = new TreeNode(1);
        TreeNode l = new TreeNode(2);
        TreeNode r = new TreeNode(3);
        TreeNode l_l = new TreeNode(4);
        TreeNode l_r = new TreeNode(5);
        TreeNode r_l = new TreeNode(6);
        TreeNode r_r = new TreeNode(7);
        root.left = l;
        root.right = r;
        l.left = l_l;
        l.right = l_r;
        r.left = r_l;
        r.right = r_r;
        int[][] res = app.threeOrders(root);
        for (int[] re : res) {
            for (int i : re) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

    }
}
