import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author wmy
 * @date 2021/6/12 15:13
 */
/*
描述
操作给定的二叉树，将其变换为源二叉树的镜像。
比如：    源二叉树
            8
           /  \
          6   10
         / \  / \
        5  7 9 11
        镜像二叉树
            8
           /  \
          10   6
         / \  / \
        11 9 7  5
示例1
输入：
{8,6,10,5,7,9,11}
复制
返回值：
{8,10,6,11,9,7,5}
复制
 */
public class Q_MirrorOfTreeNode {
//    /**
//     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
//     *
//     * @param pRoot TreeNode类
//     * @return TreeNode类
//     *
//     * 后序遍历递归方式
//     */
//    public TreeNode Mirror(TreeNode pRoot) {
//        // write code here
//        if (pRoot == null)
//            return null;
//        TreeNode left = Mirror(pRoot.left);
//        TreeNode right = Mirror(pRoot.right);
//        pRoot.left = right;
//        pRoot.right = left;
//        return pRoot;
//    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param pRoot TreeNode类
     * @return TreeNode类
     * <p>
     * 非递归方式
     */
    public TreeNode Mirror(TreeNode pRoot) {
        // write code here
        if (pRoot == null)
            return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.remove();
            TreeNode temp = treeNode.left;
            treeNode.left = treeNode.right;
            treeNode.right = temp;
            if (treeNode.left != null) {
                queue.add(treeNode.left);
            }
            if (treeNode.right != null) {
                queue.add(treeNode.right);
            }
        }
        return pRoot;
    }

    public static void main(String[] args) {
        Q_MirrorOfTreeNode app = new Q_MirrorOfTreeNode();
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
        TreeNode res = app.Mirror(root);
        System.out.println(res);

    }
}
