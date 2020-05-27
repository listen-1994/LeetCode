/**
 * @Author listen
 * @Create 20-5-24
 * @Description leetcode 309 最佳买卖股票时机含冷冻期
 */
public class Problem309 {
/*  超时，淦
    public int maxProfit(int[] prices) {
        if (null == prices || prices.length == 0) {
            return 0;
        }
        boolean[][] check = new boolean[prices.length][prices.length];
        int[][] sav = new int[prices.length][prices.length];

        return dfs(check, sav, 0, prices.length - 1, prices);
    }

    public int dfs(boolean[][] check, int sav[][], int begin, int end, int[] prices) {
        if (check[begin][end]) {
            return sav[begin][end];
        }
        if (end <= begin) {
            check[begin][end] = true;
            return 0;
        }
        int subResult = Math.max(0, prices[end] - prices[begin]);
        int minus = end - begin;
        if (minus > 1) {
            subResult = Math.max(subResult, dfs(check, sav, begin, end - 1, prices));
            subResult = Math.max(subResult, dfs(check, sav, begin + 1, end, prices));
        }
        if (minus > 2) {
            subResult = Math.max(subResult, dfs(check, sav, begin, end - 2, prices));
            subResult = Math.max(subResult, dfs(check, sav, begin + 2, end, prices));
        }
        if (minus > 3) {
            for (int i = begin + 1; i <= end - 3; i++) {
                subResult = Math.max(subResult, dfs(check, sav, begin, i, prices) + dfs(check, sav, i + 2, end, prices));
            }
        }
        check[begin][end] = true;
        sav[begin][end] = subResult;
        return subResult;
    }
*/

    public static void main(String[] args) {
        Problem309 problem309 = new Problem309();
        System.out.println(problem309.maxProfit(new int[]{1, 2, 3, 0, 2}));
    }

    public int maxProfit(int[] prices) {
        int empty = 0;
        int hold = Integer.MIN_VALUE;
        int freeze = 0;

        int i = 0;
        for (int price : prices) {
            int pre_freeze = freeze;
            freeze = hold + price;
            hold = Math.max(hold, empty - price);
            empty = Math.max(empty, pre_freeze);

            System.out.println("第" + (++i) + "天");
            System.out.println("持仓：" + hold + ",空仓：" + empty + ",冷冻：" + freeze);
        }
        return Math.max(empty, freeze);
    }
}
