public class Problem322 {
    public int coinChange(int[] coins, int amount) {
        if (null == coins || coins.length == 0 || amount == 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        for (int coin : coins) {
            if (coin > amount) {
                continue;
            }
            dp[coin] = 1;
        }
        dfs(dp, amount, coins);
        return dp[amount] <= 0 ? -1 : dp[amount];
    }

    public int dfs(int[] dp, int amount, int[] coins) {
        if (amount <= 0) {
            return 0;
        }
        if (dp[amount] != 0) {
            return dp[amount];
        }
        boolean check = false;
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int sub = dfs(dp, amount - coins[i], coins);
            if (sub > 0) {
                check = true;
                result = Math.min(result, sub + 1);
            }
        }
        if (check) {
            dp[amount] = result;
        } else {
            dp[amount] = -1;
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        Problem322 problem322 = new Problem322();
        System.out.println(problem322.coinChange(new int[]{186, 419, 83, 408}, 6249));
    }
}
