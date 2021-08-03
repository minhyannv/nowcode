import java.util.ArrayList;
import java.util.Stack;

/**
 * @author wmy
 * @date 2021/6/12 15:13
 */
/*
描述
输入一棵二叉树，判断该二叉树是否是平衡二叉树。
在这里，我们只需要考虑其平衡性，不需要考虑其是不是排序二叉树
平衡二叉树（Balanced Binary Tree），具有以下性质：它是一棵空树或它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树。

注：我们约定空树是平衡二叉树。
示例1
输入：
{1,2,3,4,5,6,7}
复制
返回值：
true
复制
 */
public class Q_IsBalancedBinaryTree {

    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return true;
        }
        return dfs(root) != -1;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        } else {
            return Math.max(left, right) + 1;
        }
    }

    public static void main(String[] args) {
        Q_IsBalancedBinaryTree app = new Q_IsBalancedBinaryTree();
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
        boolean res = app.IsBalanced_Solution(root);
        System.out.println(res);

    }
}
