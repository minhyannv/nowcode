import java.util.*;

/**
 * @author wmy
 * @date 2021/6/12 15:13
 */
/*
描述
给定一棵二叉树(保证非空)以及这棵树上的两个节点对应的val值 o1 和 o2，请找到 o1 和 o2 的最近公共祖先节点。
注：本题保证二叉树中每个节点的val值均不相同。
示例1
输入：
[3,5,1,6,2,0,8,#,#,7,4],5,1
返回值：
3
 */
public class Q_LowestCommonAncestor {

    /**
     * 参考：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/solution/236-er-cha-shu-de-zui-jin-gong-gong-zu-xian-hou-xu/
     *
     * @param root TreeNode类
     * @param o1   int整型
     * @param o2   int整型
     * @return int整型
     */
    public int lowestCommonAncestor(TreeNode root, int o1, int o2) {
        return dfs(root, o1, o2).val;
    }

    public TreeNode dfs(TreeNode root, int o1, int o2) {
        if (root == null || root.val == o1 || root.val == o2) return root;
        TreeNode left = dfs(root.left, o1, o2);
        TreeNode right = dfs(root.right, o1, o2);
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }

    public static void main(String[] args) {
        Q_LowestCommonAncestor app = new Q_LowestCommonAncestor();
        TreeNode head = new TreeNode(1);
        TreeNode l = new TreeNode(2);
        TreeNode r = new TreeNode(3);
        TreeNode l_l = new TreeNode(4);
        TreeNode l_r = new TreeNode(5);
        TreeNode r_l = new TreeNode(6);
        TreeNode r_r = new TreeNode(7);
        head.left = l;
        head.right = r;
        l.left = l_l;
        l.right = l_r;
        r.left = r_l;
        r.right = r_r;
        int o1 = 3;
        int o2 = 4;
        int res = app.lowestCommonAncestor(head, o1, o2);
        System.out.println(res);
    }
}
