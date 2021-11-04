package dp;

public class MaxProfitStock_jianzhi_63 {

  //    剑指 Offer 63. 股票的最大利润
  //    假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？

  public int maxProfit(int[] prices) {
    int len = prices.length;
    if (len <= 1) return 0;
    int res = 0;
    int min = prices[0];
    for (int i = 1; i < len; i++) {
      res = Math.max(res, prices[i] - min);
      if (prices[i] < min) min = prices[i];
    }
    return res;
  }
}
