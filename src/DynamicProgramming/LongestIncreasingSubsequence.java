package DynamicProgramming;

/**
 * LeetCode 第300题
 * 最长上升子序列
 */
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }
        int result = 1;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            int sub = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] <= nums[i]) {
                    if (dp[j] + 1 > sub) {
                        sub = dp[j] + 1;
                    }
                }
            }
            dp[i] = sub;
            if (sub > result) {
                result = sub;
            }
        }
        return result;
    }
}
