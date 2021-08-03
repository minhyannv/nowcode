import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author wmy
 * @date 2021/6/13 21:45
 */
/*
给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。

 

示例 1：

输入：nums = [1,2,3]
输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
示例 2：

输入：nums = [0,1]
输出：[[0,1],[1,0]]
示例 3：

输入：nums = [1]
输出：[[1]]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/permutations
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q_Permute {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] nums) {
        int len = nums.length;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        boolean[] used = new boolean[len];
        Deque<Integer> path = new ArrayDeque<>(len);
        dfs(nums, len, 0, used, path, res);
        return res;
    }

    private void dfs(int[] nums, int len, int depth, boolean[] used, Deque<Integer> path, ArrayList<ArrayList<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; ++i) {
            if (used[i]) {
                continue;
            }
            path.addLast(nums[i]);
            used[i] = true;
            dfs(nums, len, depth + 1, used, path, res);
            // 回溯部分的代码，和 dfs 之前的代码是对称的
            used[i] = false;
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        Q_Permute app = new Q_Permute();
        int[] num = {1, 3, 2};
        ArrayList<ArrayList<Integer>> res = app.permuteUnique(num);
        System.out.println(res);

    }
}
