package DynamicProgramming;

/**
 * LeetCode 第123题
 * 买卖股票的最佳时机III
 */
public class BestTimeToBuyAndSellStockIII {
        public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int[] sav1 = new int[prices.length + 1];
        int[] sav2 = new int[prices.length + 1];
        int[] biggest = new int[prices.length + 1];
        int[] smallest = new int[prices.length + 1];
        int result = 0;
        for (int i = prices.length; i >= 1; i--) {
            if (i == prices.length) {
                sav1[i] = 0;
                biggest[i] = prices[i - 1];
            } else {
                if (prices[i - 1] > biggest[i + 1]) {
                    biggest[i] = prices[i - 1];
                    sav1[i] = sav1[i + 1];
                } else {
                    biggest[i] = biggest[i + 1];
                    if (biggest[i] - prices[i - 1] > sav1[i + 1]) {
                        sav1[i] = biggest[i] - prices[i - 1];
                    } else {
                        sav1[i] = sav1[i + 1];
                    }
                }
            }
        }
        for (int i = 1; i < prices.length; i++) {
            if (i == 1) {
                sav2[i] = 0;
                smallest[i] = prices[i - 1];
            } else {
                if (prices[i - 1] < smallest[i - 1]) {
                    smallest[i] = prices[i - 1];
                    sav2[i] = sav2[i - 1];
                } else {
                    smallest[i] = smallest[i - 1];
                    if (prices[i - 1] - smallest[i] > sav2[i - 1]) {
                        sav2[i] = prices[i - 1] - smallest[i];
                    } else {
                        sav2[i] = sav2[i - 1];
                    }
                }
            }

            if (sav2[i] + sav1[i + 1] > result) {
                result = sav2[i] + sav1[i + 1];
            }
        }
        if (sav1[1] > result) {
            result = sav1[1];
        }
        return result;
    }
}
