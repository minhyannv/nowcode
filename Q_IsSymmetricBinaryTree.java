import java.util.Stack;

/**
 * @author wmy
 * @date 2021/6/12 15:13
 */
/*
描述
给定一棵二叉树，判断其是否是自身的镜像（即：是否对称）
例如：下面这棵二叉树是对称的
1
/  \
2    2
/ \    / \
3 4  4  3
下面这棵二叉树不对称。
1
/ \
2   2
\    \
3    3
备注：
希望你可以用递归和迭代两种方法解决这个问题
示例1
输入：
{1,2,2}
复制
返回值：
true
复制
示例2
输入：
{1,2,3,3,#,2,#}
复制
返回值：
false
复制
 */
public class Q_IsSymmetricBinaryTree {

    /**
     * @param root TreeNode类
     * @return bool布尔型
     */
    public boolean isSymmetric(TreeNode root) {
        // write code here
        if (root == null) {
            return true;
        }
        return bfs(root.left, root.right);
    }

    boolean bfs(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return bfs(left.left, right.right) && bfs(left.right, right.left);
    }

    public static void main(String[] args) {
        Q_IsSymmetricBinaryTree app = new Q_IsSymmetricBinaryTree();
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
        boolean res = app.isSymmetric(root);
        System.out.println(res);

    }
}
