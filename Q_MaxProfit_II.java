/**
 * @author wmy
 * @date 2021/6/13 21:45
 */
/*
描述
假定你知道某只股票每一天价格的变动。
你最多可以同时持有一只股票。但你最多只能进行两次交易（一次买进和一次卖出记为一次交易。买进和卖出均无手续费）。
请设计一个函数，计算你所能获得的最大收益。
示例1
输入：
[8,9,3,5,1,3]
复制
返回值：
4
复制
说明：
第三天买进，第四天卖出，第五天买进，第六天卖出。总收益为4。
*/
public class Q_MaxProfit_II {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 两次交易所能获得的最大收益
     *
     * @param prices int整型一维数组 股票每一天的价格
     * @return int整型
     */
    public int maxProfit(int[] prices) {
        // write code here
        int p1 = 0;
        int p2 = 0;
        int len = prices.length;
        int min = prices[0];
        for (int i = 1; i < len; i++) {
            if (prices[i] < prices[i - 1]) {
                if (prices[i - 1] - min > p1) {
                    p2 = p1;
                    p1 = prices[i - 1] - min;
                } else if (prices[i - 1] - min > p2) {
                    p2 = prices[i - 1] - min;
                }
                min = prices[i];
            }
        }
        if (prices[len - 1] - min > p1) {
            p2 = p1;
            p1 = prices[len - 1] - min;
        } else if (prices[len - 1] - min > p2) {
            p2 = prices[len - 1] - min;
        }
        return p1 + p2;
    }


    public static void main(String[] args) {
        Q_MaxProfit_II app = new Q_MaxProfit_II();
        int[] a = {2, 4, 10, 57, 30, 82, 90, 12, 5, 13};
        int res = app.maxProfit(a);
        System.out.println(res);

    }
}
