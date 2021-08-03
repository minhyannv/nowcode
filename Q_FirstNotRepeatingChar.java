import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * @author wmy
 * @date 2021/6/13 21:45
 */
/*
描述
在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.（从0开始计数）
示例1
输入：
"google"
返回值：
4
*/
public class Q_FirstNotRepeatingChar {
    public int FirstNotRepeatingChar(String str) {
        HashMap<Character, Integer> hashMap = new LinkedHashMap<>();
        for (int i = 0; i < str.length(); i++) {
            hashMap.put(str.charAt(i), hashMap.getOrDefault(str.charAt(i), 0) + 1);

        }
        for (int i = 0; i < str.length(); i++) {
            if (hashMap.get(str.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Q_FirstNotRepeatingChar app = new Q_FirstNotRepeatingChar();
        String str = "aa";
        int res = app.FirstNotRepeatingChar(str);
        System.out.println(res);

    }
}
