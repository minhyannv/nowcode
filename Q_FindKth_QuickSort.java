import com.sun.org.apache.regexp.internal.RE;

/**
 * @author wmy
 * @date 2021/6/13 21:45
 */
/*
描述
有一个整数数组，请你根据快速排序的思路，找出数组中第K大的数。
给定一个整数数组a,同时给定它的大小n和要找的K(1<=K<=n)，请返回第K大的数(包括重复的元素，不用去重)，保证答案存在。
示例1
输入：
[1,3,5,2,2],5,3
返回值：
2
示例2
输入：
[10,10,9,9,8,7,5,6,4,3,4,2],12,3
返回值：
9
说明：
去重后的第3大是8，但本题要求包含重复的元素，不用去重，所以输出9 
 */
public class Q_FindKth_QuickSort {
    /**
     * @param a
     * @param n
     * @param K
     * @return
     */
    public int findKth(int[] a, int n, int K) {
        // write code here
        return findKth(a, 0, n - 1, K);
    }

    /**
     * 方法重载
     *
     * @param a
     * @param left
     * @param right
     * @param K
     * @return
     */
    private int findKth(int[] a, int left, int right, int K) {
        int pivot = partition(a, left, right);
        if (pivot == K - 1) {
            return a[pivot];
        } else if (pivot < K - 1) {
            return findKth(a, pivot + 1, right, K);
        } else {
            return findKth(a, left, pivot - 1, K);
        }
    }

    /**
     * 一次快排
     *
     * @param a
     * @param left
     * @param right
     * @return
     */
    int partition(int[] a, int left, int right) {
        int pivot = a[left];
        while (left < right) {
            while ((left < right && a[right] <= pivot)) {
                right--;
            }
            a[left] = a[right];
            while (left < right && a[left] >= pivot) {
                left++;
            }
            a[right] = a[left];
        }
        a[left] = pivot;
        return left;
    }

    public static void main(String[] args) {
        Q_FindKth_QuickSort app = new Q_FindKth_QuickSort();
        int[] a = {1, 3, 5, 2, 2};
        int n = 5;
        int K = 3;
        int res = app.findKth(a, n, K);
        System.out.println(res);

    }
}
