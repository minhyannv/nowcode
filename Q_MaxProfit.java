import java.lang.ref.PhantomReference;

/**
 * @author wmy
 * @date 2021/6/13 21:45
 */
/*
描述
假定你知道某只股票每一天价格的变动。
你最多可以同时持有一只股票。但你可以无限次的交易（买进和卖出均无手续费）。
请设计一个函数，计算你所能获得的最大收益。
示例1
输入：
[5,4,3,2,1]
复制
返回值：
0
复制
说明：
由于每天股票都在跌，因此不进行任何交易最优。最大收益为0。

示例2
输入：
[1,2,3,4,5]
复制
返回值：
4
复制
说明：
第一天买进，最后一天卖出最优。中间的当天买进当天卖出不影响最终结果。最大收益为4。
备注：
总天数不大于200000。保证股票每一天的价格在[1,100]范围内。
 */
public class Q_MaxProfit {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 计算最大收益
     *
     * @param prices int整型一维数组 股票每一天的价格
     * @return int整型
     */
    public int maxProfit(int[] prices) {
        // write code here
        int len = prices.length;
        int profit = 0;
        for (int i = 1; i < len; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        Q_MaxProfit app = new Q_MaxProfit();
        int[] prices = {2, 4, 10, 57, 30, 82, 90, 12, 5, 13};
        int res = app.maxProfit(prices);
        System.out.println(res);

    }
}
