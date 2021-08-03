import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author wmy
 * @date 2021/6/13 21:45
 */
/*
描述
给定一个数组由一些非负整数组成，现需要将他们进行排列并拼接，使得最后的结果最大，返回值需要是string类型 否则可能会溢出
示例1
输入：
[30,1]
返回值：
"301"
 */
public class Q_MaxNum {
//    /**
//     * 最大数
//     *
//     * @param nums int整型一维数组
//     * @return string字符串
//     * <p>
//     * 排序规则：按照字符串字典序降序排序
//     */
//    public String solve(int[] nums) {
//        // write code here
//        int len = nums.length;
//        StringBuilder stringBuilder = new StringBuilder();
//        String[] strings = new String[len];
//        for (int i = 0; i < len; i++) {
//            strings[i] = String.valueOf(nums[i]);
//        }
//        if (strings[0].equals("0")) {
//            return "0";
//        }
//        Arrays.sort(strings, (o1, o2) -> (o2 + o1).compareTo((o1 + o2)));
//        for (int i = 0; i < len; i++) {
//            stringBuilder.append(strings[i]);
//        }
//        return stringBuilder.toString();
//    }

    /**
     * 最大数
     *
     * @param nums int整型一维数组
     * @return string字符串
     * <p>
     * 排序规则：按照字符串字典序降序排序
     */
    public String solve(int[] nums) {
        // write code here
        ArrayList<String> arrayList = new ArrayList<>();
        for (int num : nums) {
            arrayList.add(String.valueOf(num));
        }
        arrayList.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo((o1 + o2));
            }
        });
        if (arrayList.get(0).equals("0")) {
            return "0";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : arrayList) {
            stringBuilder.append(s);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Q_MaxNum app = new Q_MaxNum();
        int[] arr = {10, 1};
        String res = app.solve(arr);
        System.out.println(res);

    }
}
