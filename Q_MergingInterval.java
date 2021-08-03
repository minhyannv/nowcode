import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author wmy
 * @date 2021/6/13 21:45
 */
/*
描述
给出一组区间，请合并所有重叠的区间。
请保证合并后的区间按区间起点升序排列。
示例1
输入：
[[10,30],[20,60],[80,100],[150,180]]
复制
返回值：
[[10,60],[80,100],[150,180]]
复制
*/
public class Q_MergingInterval {

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> res = new ArrayList<>();
        int size = intervals.size();
        if (size == 0) {
            return res;
        }
        intervals.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
        for (int i = 1; i < size; i++) {
            if (intervals.get(i).start <= intervals.get(i - 1).end) {
                intervals.get(i).start = intervals.get(i - 1).start;
                intervals.get(i).end = Math.max(intervals.get(i - 1).end, intervals.get(i).end);
            } else {
                res.add(intervals.get(i - 1));
            }
        }
        res.add(intervals.get(size - 1));
        return res;
    }

    public static void main(String[] args) {
        Q_MergingInterval app = new Q_MergingInterval();
        int[][] matrix = {{10, 30}, {20, 60}, {80, 100}, {150, 180}};
        ArrayList<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(10, 30));
        intervals.add(new Interval(20, 60));
        intervals.add(new Interval(80, 100));
        intervals.add(new Interval(150, 180));
        ArrayList<Interval> res = app.merge(intervals);
        for (Interval re : res) {
            System.out.println(re.start + " " + re.end);
        }
    }
}
