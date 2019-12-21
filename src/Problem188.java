import javax.swing.plaf.IconUIResource;

public class Problem188 {
/*    public int maxProfit(int k, int[] prices) {
        if (k == 0 || null == prices || prices.length <= 1) {
            return 0;
        }

        int[][][] sav = new int[prices.length][prices.length][k + 1];
        boolean[][][] flag = new boolean[prices.length][prices.length][k + 1];
        return core(0, prices.length - 1, prices, k, sav, flag);
    }*/

/*    private Integer core(int begin, int end, int[] prices, int k, int[][][] sav, boolean[][][] flag) {
        if (begin >= end || k <= 0) {
            return 0;
        }
        if (flag[begin][end][k]) {
            return sav[begin][end][k];
        }
        if (k == 1) {
            int result = caculateOne(begin, end, prices);
            flag[begin][end][k] = true;
            sav[begin][end][k] = result;
            return result;
        }

        int result = 0;
        for (int i = begin; i <= end; i++) {
            result = Math.max(result, core(begin, i, prices, 1, sav, flag) + core(i + 1, end, prices, k - 1, sav, flag));
        }
        flag[begin][end][k] = true;
        sav[begin][end][k] = result;
        return result;
    }*/

    private Integer caculateOne(int begin, int end, int[] prices) {
        int minPrice=0;
        int result = 0;
        for(int i=begin;i<=end;i++){
            if(i==begin){
                minPrice=prices[begin];
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

    public int maxProfit(int k, int[] prices) {

        if (k == 0 || null == prices || prices.length <= 1) {
            return 0;
        }
        if(k >= prices.length/2) return greedy(prices);

        int[][] sav =new int[prices.length][k+1];
        for (int i = 1;i<prices.length;i++){
            int[] cal = new int[i+1];
            for(int x = 0;x<=i;x++){
                cal[x] = caculateOne(x,i,prices);
            }
            for (int j=1;j<=i&&j<=k;j++){
                int result = 0;
                for (int x=0;x<=i;x++){
                    result = Math.max(result,sav[x][j-1]+cal[x]);
                }
                sav[i][j] = result;
            }
        }
        if (k>prices.length-1){
            return sav[prices.length-1][prices.length-1];
        }
        return sav[prices.length-1][k];
    }
    private int greedy(int[] prices) {
        int max = 0;
        for(int i = 1; i < prices.length; ++i) {
            if(prices[i] > prices[i-1])
                max += prices[i] - prices[i-1];
        }
        return max;
    }

    public static void main(String[] args){
        Problem188 problem188 = new Problem188();
       // int result = problem188.maxProfit(2,prices);
       // System.out.println(result);
    }
}
