import java.util.ArrayList;

/**
 * @author wmy
 * @date 2021/6/12 15:13
 */
/*
描述
把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
示例1
输入：
[3,4,5,1,2]
复制
返回值：
1
复制
 */
public class Q_MinNumberInRotateArray {

    public int minNumberInRotateArray(int[] array) {
        int len = array.length;
        if (len == 0) {
            return 0;
        }
        int i = 0; //旋转点
        for (; i < len - 1; i++) {
            if (array[i + 1] < array[i]) {
                break;
            }
        }
        if (i + 1 == len) {
            return array[0];
        }
        return array[i + 1];
    }

    public static void main(String[] args) {
        Q_MinNumberInRotateArray app = new Q_MinNumberInRotateArray();
        int[] array = {1, 2, 2, 2, 2};
        int res = app.minNumberInRotateArray(array);
        System.out.println(res);
    }
}
