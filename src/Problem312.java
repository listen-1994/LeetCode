/**
 * @Author listen
 * @Create 20-5-25
 * @Description leetcode312 戳气球
 */
public class Problem312 {
    public int maxCoins(int[] nums) {
        int[] newNums = new int[nums.length + 2];
        newNums[0] = 1;
        newNums[nums.length + 1] = 1;
        int[][] dp = new int[newNums.length][newNums.length];
        for (int i = 0; i < nums.length; i++) {
            newNums[i + 1] = nums[i];
        }
        for (int i = 2; i < newNums.length; i++) {
            for (int j = newNums.length - 1; j >= i; j--) {
                //j-i,j
                int sub = Integer.MIN_VALUE;
                for (int k = j - i + 1; k < j; k++) {
                    sub = Math.max(dp[j - i][k] + dp[k][j] + newNums[k] * newNums[j - i] * newNums[j], sub);
                }
                dp[j - i][j] = sub;
            }
        }

        return dp[0][newNums.length - 1];
    }

    public static void main(String[] args) {
        Problem312 problem312 = new Problem312();
        int result = problem312.maxCoins(new int[]{3,1,5,8});
        System.out.println(result);
    }
}
