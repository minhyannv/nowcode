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
public class Q_FindKth_Heap {
    /**
     * 参考：https://www.cnblogs.com/jingmoxukong/p/4303826.html
     *
     * @param a
     * @param n
     * @param K
     * @return
     */
    public int findKth(int[] a, int n, int K) {
        // write code here
        heapSort(a, n, K);
        return a[n - K];
    }

    public void HeapAdjust(int[] array, int parent, int length) {
        int temp = array[parent]; // temp保存当前父节点
        int child = 2 * parent + 1; // 先获得左孩子

        while (child < length) {
            // 如果有右孩子结点，并且右孩子结点的值大于左孩子结点，则选取右孩子结点
            if (child + 1 < length && array[child] < array[child + 1]) {
                child++;
            }

            // 如果父结点的值已经大于孩子结点的值，则直接结束
            if (temp >= array[child])
                break;

            // 把孩子结点的值赋给父结点
            array[parent] = array[child];

            // 选取孩子结点的左孩子结点,继续向下筛选
            parent = child;
            child = 2 * child + 1;
        }

        array[parent] = temp;
    }

    public void heapSort(int[] list, int n, int K) {
        // 循环建立初始堆
        for (int i = n / 2; i >= 0; i--) {
            HeapAdjust(list, i, n);
        }
        // 进行n-1次循环，完成排序
        for (int i = n - 1; i > 0; i--) {
            // 最后一个元素和第一元素进行交换
            int temp = list[i];
            list[i] = list[0];
            list[0] = temp;
            // 筛选 R[0] 结点，得到i-1个结点的堆
            HeapAdjust(list, 0, i);
            if (n - i == K) { //只排序K次
                return;
            }
        }
    }


    public static void main(String[] args) {
        Q_FindKth_Heap app = new Q_FindKth_Heap();
        int[] a = {10, 10, 9, 9, 8, 7, 5, 6, 4, 3, 4, 2};
        int n = 12;
        int K = 3;
        int res = app.findKth(a, n, K);
        System.out.println(res);

    }
}
