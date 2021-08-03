/**
 * @author wmy
 * @date 2021/6/13 21:45
 */
/*
描述
假设你有一个数组，其中第 i 个元素是股票在第 i 天的价格。
你有一次买入和卖出的机会。（只有买入了股票以后才能卖出）。请你设计一个算法来计算可以获得的最大收益。
示例1
输入：
[1,4,2]
返回值：
3
示例2
输入：
[2,4,1]
返回值：
2
复 */
public class Q_BestTimeforBuyAndSellShares {
    /**
     * @param prices int整型一维数组
     * @return int整型
     */
    public int maxProfit(int[] prices) {
        // write code here
        int minValue = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price > minValue) {
                //如果当前价格大于历史最小价格，则取当前天卖出最大利润和历史卖出最大利润的最大值
                maxProfit = Math.max(maxProfit, price - minValue);
            } else if (price < minValue) {
                //如果当前价格小于历史最小价格，则更新历史最小价格
                minValue = price;
            }
        }
        return maxProfit;
    }


    public static void main(String[] args) {
        Q_BestTimeforBuyAndSellShares app = new Q_BestTimeforBuyAndSellShares();
        int[] prices = {4, 1, 2};
        int res = app.maxProfit(prices);
        System.out.println(res);

    }
}
