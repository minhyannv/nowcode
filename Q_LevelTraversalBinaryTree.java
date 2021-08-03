import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wmy
 * @date 2021/6/12 15:13
 */
/*
描述
给定一个二叉树，返回该二叉树层序遍历的结果，（从左到右，一层一层地遍历）
例如：
给定的二叉树是{3,9,20,#,#,15,7},
该二叉树层序遍历的结果是
[
[3],
[9,20],
[15,7]
]
示例1
输入：
{1,2}
返回值：
[[1],[2]]
示例2
输入：
{1,2,3,4,#,#,5}
返回值：
[[1],[2,3],[4,5]]
 */
public class Q_LevelTraversalBinaryTree {

    /**
     * 用队列进行层寻遍历
     *
     * @param root TreeNode类
     * @return int整型ArrayList<ArrayList <>>
     */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // write code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                arrayList.add(treeNode.val);
                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
            }
            res.add(arrayList);
        }
        return res;
    }

    public static void main(String[] args) {
        Q_LevelTraversalBinaryTree app = new Q_LevelTraversalBinaryTree();
        TreeNode head = new TreeNode(1);
        TreeNode l = new TreeNode(2);
        TreeNode r = new TreeNode(3);
        TreeNode l_l = new TreeNode(4);
        TreeNode r_r = new TreeNode(5);
        head.left = l;
        head.right = r;
        l.left = l_l;
        r.right = r_r;
        ArrayList<ArrayList<Integer>> res = app.levelOrder(head);
        for (ArrayList<Integer> re : res) {
            System.out.println(re);
        }
    }
}
