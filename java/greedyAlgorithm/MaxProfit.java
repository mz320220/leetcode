package greedyAlgorithm;

/**
 * 122. 买卖股票的最佳时机 II
 */
public class MaxProfit {

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
    }

    public static int maxProfit(int[] prices) {
        int num = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] < prices[i]) {
                /**
                 * 很典型的贪心，有受益就累加即可
                 */
                num = num + prices[i] - prices[i - 1];
            }
        }
        return num;
    }
}
