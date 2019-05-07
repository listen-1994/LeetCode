package DynamicProgramming;

/**
 * LeetCode 第152题
 * 乘积最大子序列
 */
public class MaximumProductSubarray {
    /**
     * 该方法时间复杂度o(n^2)
     * 其实存在o(n)的方法，以后再写吧
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int result = Integer.MIN_VALUE;
        int[] sav = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (i == j) {
                    sav[i] = nums[i];
                } else {
                    sav[j] = sav[j - 1] * nums[j];
                }
                if (sav[j] > result) {
                    result = sav[j];
                }
            }
            if (sav[nums.length - 1] > 0) {
                break;
            }
        }
        return result;
    }
}
