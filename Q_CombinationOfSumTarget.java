import java.util.ArrayList;

/**
 * @author wmy
 * @date 2021/6/13 21:45
 */
/*
描述
给出一组候选数\ C C 和一个目标数\ T T，找出候选数中起来和等于\ T T 的所有组合。
\ C C 中的每个数字在一个组合中只能使用一次。
注意：
题目中所有的数字（包括目标数\ T T ）都是正整数
组合中的数字 (a_1, a_2, … , a_ka
1
​
 ,a
2
​
 ,…,a
k
​
 ) 要按非递增排序 (a_1 \leq a_2 \leq … \leq a_ka
1
​
 ≤a
2
​
 ≤…≤a
k
​
 ).
结果中不能包含重复的组合
组合之间的排序按照索引从小到大依次比较，小的排在前面，如果索引相同的情况下数值相同，则比较下一个索引。
示例1
输入：
[100,10,20,70,60,10,50],80
复制
返回值：
[[10,10,60],[10,20,50],[10,70],[20,60]]
复制
说明：
给定的候选数集是[100,10,20,70,60,10,50]，目标数是80
 */
public class Q_CombinationOfSumTarget {
    ArrayList<Integer> t = new ArrayList<Integer>();
    ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();

    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        dfs(0, num);
        return ans;
    }

    public void dfs(int cur, int[] num) {
        if (cur == num.length) {
            ans.add(new ArrayList<Integer>(t));
            return;
        }
        t.add(num[cur]);
        dfs(cur + 1, num);
        t.remove(t.size() - 1);
        dfs(cur + 1, num);
    }


    public static void main(String[] args) {
        Q_CombinationOfSumTarget app = new Q_CombinationOfSumTarget();
        int[] num = {100, 10, 20, 70, 60, 10, 50};
        int target = 80;
        ArrayList<ArrayList<Integer>> res = app.combinationSum2(num, target);
        System.out.println(res);
    }
}
