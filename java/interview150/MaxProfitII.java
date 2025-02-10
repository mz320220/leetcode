package interview150;

/**
 * 122.买卖股票的最佳时机 II
 */
public class MaxProfitII {

    public static void main(String[] args) {
        int[] nums = {7,1,5,3,6,4};
        int result = maxProfit(nums);
        System.out.println("result:" + result);
    }

    //贪心算法即可：只要是上升趋势则累加
    public static int maxProfit(int[] prices) {
        int size = prices.length;
        int maxProfit = 0;
        for (int i = 0; i < size - 1; i++) {
            int tempProfit = prices[i + 1] - prices[i];
            maxProfit += tempProfit > 0 ? tempProfit : 0;
        }
        return maxProfit;
    }
}
