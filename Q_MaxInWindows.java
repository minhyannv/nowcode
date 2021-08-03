import java.util.*;

/**
 * @author wmy
 * @date 2021/6/13 21:45
 */
/*
例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。

窗口大于数组长度的时候，返回空
示例1
输入：
[2,3,4,2,6,2,5,1],3
返回值：
[4,4,6,6,6,5]
 */
public class Q_MaxInWindows {
//    /**
//     * 暴力求解
//     * @param num
//     * @param size
//     * @return
//     *//*
//    public ArrayList<Integer> maxInWindows(int[] num, int size) {
//        ArrayList<Integer> res = new ArrayList<Integer>();
//        int len = num.length;
//        if (size > len || size == 0) {
//            return res;
//        }
//        int left = 0, right = size - 1;
//        while (right < len) {
//            res.add(getMaxValue(num, left, right));
//            left++;
//            right++;
//        }
//        return res;
//    }
//
//    public int getMaxValue(int[] num, int left, int right) {
//        int max = Integer.MIN_VALUE;
//        for (int i = left; i <= right; i++) {
//            max = Math.max(num[i], max);
//        }
//        return max;
//    }*/

    /**
     * 双端队列
     *
     * @param num
     * @param size
     * @return
     */
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        int len = num.length;
        if (size > len || size == 0) {
            return res;
        }
        Deque<Integer> deque = new LinkedList<>(); //双端队列，按照值递减存储索引
        for (int i = 0; i < len; i++) {
            //将当前元素值和队尾元素值比较，如果大于队尾元素值，则持续移除队尾元素值,最后将当前元素索引放入队尾
            while (!deque.isEmpty() && num[i] > num[deque.getLast()]) {
                deque.pollLast();
            }
            deque.addLast(i);
            while (deque.getFirst() < i - size + 1) { //删除队首越界的索引
                deque.pollFirst();
            }
            if (i >= size - 1) {
                res.add(num[deque.getFirst()]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Q_MaxInWindows app = new Q_MaxInWindows();
        int[] num = {2, 3, 4, 2, 6, 2, 5, 1};
        int size = 3;
        ArrayList<Integer> res = app.maxInWindows(num, size);
        System.out.println(res);

    }
}
