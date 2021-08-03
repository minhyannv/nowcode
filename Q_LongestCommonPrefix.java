/**
 * @author wmy
 * @date 2021/6/13 21:45
 */
/*
描述
编写一个函数来查找字符串数组中的最长公共前缀。
示例1
输入：
["abca","abc","abca","abc","abcc"]
返回值：
"abc"
*/
public class Q_LongestCommonPrefix {
    /**
     * @param strs string字符串一维数组
     * @return string字符串
     */
    public String longestCommonPrefix(String[] strs) {
        // write code here
        if (strs.length == 0) {
            return "";
        }
        int minLen = Integer.MAX_VALUE;
        for (String str : strs) {
            if (str.length() < minLen) {
                minLen = str.length();
            }
        }
        for (int i = 0; i < minLen; i++) {
            char temp = strs[0].charAt(i);
            for (String str : strs) {
                if (str.charAt(i) != temp) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0].substring(0, minLen);
    }


    public static void main(String[] args) {
        Q_LongestCommonPrefix app = new Q_LongestCommonPrefix();
        String[] strs = {"abca", "abc", "abca", "abc", "abcc"};
        String res = app.longestCommonPrefix(strs);
        System.out.println(res);

    }
}
