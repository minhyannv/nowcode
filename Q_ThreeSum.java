import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * @author wmy
 * @date 2021/6/13 21:45
 */
/*
描述
给出一个有n个元素的数组S，S中是否有元素a,b,c满足a+b+c=0？找出数组S中所有满足条件的三元组。
注意：
三元组（a、b、c）中的元素必须按非降序排列。（即a≤b≤c）
解集中不能包含重复的三元组。
例如，给定的数组 S = {-10 0 10 20 -10 -40},解集为(-10, -10, 20),(-10, 0, 10)
0 <= S.length <= 1000
示例1
输入：
[0]
返回值：
[]
示例2
输入：
[-2,0,1,1,2]
返回值：
[[-2,0,2],[-2,1,1]]
示例3
输入：
[-10,0,10,20,-10,-40]
返回值：
[[-10,-10,20],[-10,0,10]]
 */
public class Q_ThreeSum {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int len = num.length;
        if (len < 3) {
            return res;
        }
        Arrays.sort(num);
        for (int i = 0; i < len; i++) {
            if (num[i] > 0) { //优化
                break;
            }
            if (i > 0 && num[i] == num[i - 1]) {
                continue;// 去重
            }
            int j = i + 1;
            int k = len - 1;
            while (j < k) {
                int sum = num[i] + num[j] + num[k];
                if (sum == 0) {
                    ArrayList<Integer> arrayList = new ArrayList<>();
                    arrayList.add(num[i]);
                    arrayList.add(num[j]);
                    arrayList.add(num[k]);
                    res.add(arrayList);
                    while (j < k && num[j] == num[j + 1]) { //去重
                        j++;
                    }
                    while (j < k && num[k] == num[k - 1]) { //去重
                        k--;
                    }
                    j++;
                    k--;
                } else if (sum > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Q_ThreeSum app = new Q_ThreeSum();
        int[] num = {-2, 0, 0, 2, 2};
        ArrayList<ArrayList<Integer>> res = app.threeSum(num);
        System.out.println(res);

    }
}
