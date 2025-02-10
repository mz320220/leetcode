package interview150;

/**
 * 121.买卖股票的最佳时机
 */
public class MaxProfit {

    public static void main(String[] args) {
        int[] nums = {7,1,5,3,6,4};
        int result = maxProfit2(nums);
        System.out.println("result:" + result);
    }

    //暴力法会超时
    public static int maxProfit(int[] prices) {
        int size = prices.length;
        int profit = 0;
        for (int left = 0; left < size; left++) {
            int right = left + 1;
            while (right < size) {
                int tempProfit = prices[right] - prices[left];
                profit = tempProfit > profit ? tempProfit : profit;
                right++;
            }
        }
        return profit;
    }

    //单独变量记录当日之前的最小值 && 同时考虑当日卖出的最大利润 --> 循环一次即可
    public static int maxProfit2(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            minPrice = minPrice > prices[i] ? prices[i] : minPrice;
            int profit = prices[i] - minPrice;
            maxProfit = profit > maxProfit ? profit : maxProfit;
        }
        return maxProfit;
    }

}
