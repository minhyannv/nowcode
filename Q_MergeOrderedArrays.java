import com.sun.javaws.exceptions.BadVersionResponseException;

import java.util.Stack;

/**
 * @author wmy
 * @date 2021/6/12 15:13
 */
/*
描述
给出一个整数数组 和有序的整数数组 ，请将数组 合并到数组 中，变成一个有序的升序数组
注意：
1.可以假设 数组有足够的空间存放 数组的元素， 和 中初始的元素数目分别为 和 ，的数组空间大小为 +
2.不要返回合并的数组，返回是空的，将数组 的数据合并到里面就好了
3.数组在[0,m-1]的范围也是有序的

例1:
A: [1,2,3,0,0,0]，m=3
B: [2,5,6]，n=3
合并过后A为:
A: [1,2,2,3,5,6]

示例1
输入：
[4,5,6],[1,2,3]
返回值：
[1,2,3,4,5,6]

 */
public class Q_MergeOrderedArrays {
    public void merge(int A[], int m, int B[], int n) {
        if (m == 0) {
            if (n >= 0) System.arraycopy(B, 0, A, 0, n);
            return;
        }
        if (n == 0) {
            return;
        }
        //从后往前合并，谁大先放谁
        int k = m + n - 1;
        m = m - 1;
        n = n - 1;
        while (k >= 0) {
            if (A[m] >= B[n]) {
                A[k] = A[m];
                m--;
            } else {
                A[k] = B[n];
                n--;
            }
            k--;
            if (m < 0) { //如果m小于0，说明A数组元素已放到指定位置，B数组剩余元素按照顺序放入即可
                if (k + 1 >= 0) System.arraycopy(B, 0, A, 0, k + 1);
                return;
            }
            if (n < 0) { // 如果n小于0，说明B数组元素已放到A中指定位置，其余元素已经满足升序排序，直接返回即可
                return;
            }
        }
    }

    public static void main(String[] args) {
        Q_MergeOrderedArrays app = new Q_MergeOrderedArrays();
        int[] A = {1, 0};
        int m = 1;
        int[] B = {2};
        int n = 1;
        app.merge(A, m, B, n);
        for (int i : A) {
            System.out.print(i + " ");
        }

    }
}
