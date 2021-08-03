import java.util.*;

/**
 * @author wmy
 * @date 2021/6/13 21:45
 */
/*
描述
现在有一个没有重复元素的整数集合S，求S的所有子集
注意：
你给出的子集中的元素必须按升序排列
给出的解集中不能出现重复的元素
示例1
输入：
[1,2,3]
复制
返回值：
[[],[1],[2],[3],[1,2],[1,3],[2,3],[1,2,3]]
复制
 */
public class Q_AllSubsetsOfSet {
    ArrayList<Integer> t = new ArrayList<Integer>();
    ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();

    public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        dfs(0, nums);
        return ans;
    }

    public void dfs(int cur, int[] nums) {
        if (cur == nums.length) {
            ans.add(new ArrayList<Integer>(t));
            return;
        }
        t.add(nums[cur]);
        dfs(cur + 1, nums);
        t.remove(t.size() - 1);
        dfs(cur + 1, nums);
    }

    public static void main(String[] args) {
        Q_AllSubsetsOfSet app = new Q_AllSubsetsOfSet();
        int[] S = {1, 2, 3};
        ArrayList<ArrayList<Integer>> res = app.subsets(S);
        System.out.println(res);
    }
}
