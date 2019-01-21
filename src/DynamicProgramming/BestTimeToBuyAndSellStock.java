package DynamicProgramming;

/**
 * LeetCode 第121题
 * 买卖股票的最佳时机
 */
public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        int minPrice=0;
        int result = 0;
        for(int i=0;i<prices.length;i++){
            if(i==0){
                minPrice=prices[0];
                continue;
            }
            if(prices[i]<minPrice){
                minPrice=prices[i];
            }else{
                if(prices[i]-minPrice>result){
                    result = prices[i]-minPrice;
                }
            }
        }
        return result;
    }
}
