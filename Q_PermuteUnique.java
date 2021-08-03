import java.util.*;

/**
 * @author wmy
 * @date 2021/6/13 21:45
 */
/*
描述
给出一组可能包含重复项的数字，返回该组数字的所有排列。
示例1
输入：
[1,1,2]
返回值：
[[1,1,2],[1,2,1],[2,1,1]]
 */
public class Q_PermuteUnique {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        int len = num.length;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        // 排序（升序或者降序都可以），排序是剪枝的前提
        Arrays.sort(num);
        boolean[] used = new boolean[len];
        // 使用 Deque 是 Java 官方 Stack 类的建议
        Deque<Integer> path = new ArrayDeque<>(len);
        dfs(num, len, 0, used, path, res);
        return res;
    }

    private void dfs(int[] num, int len, int depth, boolean[] used, Deque<Integer> path, ArrayList<ArrayList<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; ++i) {
            if (used[i]) {
                continue;
            }
            // 剪枝条件：i > 0 是为了保证 nums[i - 1] 有意义
            // 写 !used[i - 1] 是因为 nums[i - 1] 在深度优先遍历的过程中刚刚被撤销选择
            if (i > 0 && num[i] == num[i - 1] && !used[i - 1]) {
                continue;
            }
            path.addLast(num[i]);
            used[i] = true;

            dfs(num, len, depth + 1, used, path, res);
            // 回溯部分的代码，和 dfs 之前的代码是对称的
            used[i] = false;
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        Q_PermuteUnique app = new Q_PermuteUnique();
        int[] num = {1, 1, 2};
        ArrayList<ArrayList<Integer>> res = app.permuteUnique(num);
        System.out.println(res);

    }
}
